package br.com.ecologic.service;

import br.com.ecologic.constants.Status;
import br.com.ecologic.model.*;
import br.com.ecologic.util.Pontos;
import br.com.ecologic.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RotinasService {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private ResiduoService residuoService;

    @Autowired
    private CaminhaoService caminhaoService;

    @Autowired
    private LocalizacaoService localizacaoService;

    @Scheduled(fixedDelay = 5000)
    private void gerarAgendamentoAutomatico() {
        List<Residuo> lstResiduos = residuoService.buscarResiduosCapacidadeAtingida();
        if(!lstResiduos.isEmpty()) {
            for (Residuo residuo : lstResiduos) {
                Agendamento agendamento = agendamentoService.buscarAgendamentoEmAberto(residuo.getUsuario());
                if (agendamento == null) {
                    try {
                        Agendamento novoAgendamento = new Agendamento();
                        novoAgendamento.setDataAgendamento(Tools.retornaDataPosteriorDiasCorridos(new Date(), 1));
                        novoAgendamento.setUsuario(residuo.getUsuario());
                        novoAgendamento.setStatus(Status.PENDENTE);
                        Caminhao caminhao = caminhaoService.buscarCaminhaoRandom();
                        novoAgendamento.setCaminhao(caminhao);
                        novoAgendamento.setTipoResiduo(residuo.getTipoResiduo());
                        agendamentoService.gravar(novoAgendamento);
                        residuo.setAgendamento(novoAgendamento);
                        residuoService.gravar(residuo);
                        enviarNotificacao(new Notificacao().criarNotificacao(residuo.getUsuario(), "Agendamento de Coleta Realizado!", mensagemNotificacao(agendamento, null)));
                    } catch (Exception e) {
                        e.fillInStackTrace();
                    }
                }
            }
        }
    }

    @Scheduled(fixedDelay = 5000)
    private void gerarRastreamentoInicial(){
        List<Agendamento> lstAgendamentosPendentes = agendamentoService.buscarAgendamentoPendente();
        for(Agendamento agendamento : lstAgendamentosPendentes){
            agendamento.setStatus(Status.A_CAMINHO);
            agendamentoService.gravar(agendamento);

            Localizacao localizacao = new Localizacao();
            localizacao.setAgendamento(agendamento);
            localizacao.setDataOcorrencia(new Date());
            String[] latitudeLongitude = Tools.latitudeLongitude("01228200");
            if (latitudeLongitude != null) {
                localizacao.setLatidade(latitudeLongitude[0]);
                localizacao.setLongitute(latitudeLongitude[1]);
            }
            localizacaoService.gravar(localizacao);
            enviarNotificacao(new Notificacao().criarNotificacao(agendamento.getUsuario(), "O caminhão está a caminho da coleta!", mensagemNotificacao(agendamento, localizacao)));
        }
    }

    @Scheduled(fixedDelay = 5000)
    private void rastreamentoAutomaticoACaminho() {
        List<Agendamento> lstAgendamentosACaminho = agendamentoService.buscarAgendamentoEmTransito();

        for (Agendamento agendamento : lstAgendamentosACaminho) {
            Localizacao localizacaoInicial = localizacaoService.buscarLocalizacaoInicial(agendamento);
            Pontos ponto1 = new Pontos(Double.parseDouble(localizacaoInicial.getLatidade()), Double.parseDouble(localizacaoInicial.getLongitute()));
            Pontos ponto5 = new Pontos(Double.parseDouble(agendamento.getUsuario().getLatitude()), Double.parseDouble(agendamento.getUsuario().getLongitude()));

            // Calculando a diferença entre as coordenadas
            Pontos diferencaEntreDoisPontos = new Pontos((Double.parseDouble(ponto5.getLatitude()) - Double.parseDouble(ponto1.getLatitude())), (Double.parseDouble(ponto5.getLongitude()) - Double.parseDouble(ponto1.getLongitude())));

            // Dividindo a diferença em 3 partes
            Double latitudePor3 = Double.parseDouble(diferencaEntreDoisPontos.getLatitude()) / 4;
            Double longitudePor3 = Double.parseDouble(diferencaEntreDoisPontos.getLongitude()) / 4;

            // Criando os pontos intermediários
            List<Pontos> lstPontos = new ArrayList<>();
            for (int i = 1; i < 4; i++) {
                Pontos pontoIntermediario = new Pontos(ponto1.getLatitude() + latitudePor3 * i, ponto1.getLongitude() + longitudePor3 * i);
                lstPontos.add(pontoIntermediario);
            }
            lstPontos.add(ponto5); // Adicionando o ponto 5

            // Salvando as localizações
            for (Pontos ponto : lstPontos) {
                Localizacao novaLocalizacao = new Localizacao();
                novaLocalizacao.setDataOcorrencia(new Date());
                novaLocalizacao.setAgendamento(agendamento);
                novaLocalizacao.setLatidade(ponto.getLatitude());
                novaLocalizacao.setLongitute(ponto.getLongitude());
                localizacaoService.gravar(novaLocalizacao);
            }

            Localizacao ultimaLocalizacao = localizacaoService.buscarLocalizacaoFinal(agendamento);
            // Atualizando o status do agendamento
            agendamento.setStatus(Status.CONCLUIDO);
            agendamentoService.gravar(agendamento);
            enviarNotificacao(new Notificacao().criarNotificacao(agendamento.getUsuario(), "Realizamos sua coleta!", mensagemNotificacao(agendamento, ultimaLocalizacao)));
        }
    }

    private String mensagemNotificacao(Agendamento agendamento, Localizacao localizacao){
        String mensagem;

        mensagem = "Olá! Seu agendamento da sua coleta de " + agendamento.getTipoResiduo() + " está com o status " + agendamento.getStatus();

        if(localizacao != null){
            mensagem += " e foi atualizado em " + localizacao.getDataOcorrencia();
        }

        return mensagem;
    }

    private void enviarNotificacao(Notificacao notificacao) {
        try {
            notificacaoService.gravar(notificacao);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

}
