package br.com.ecologic.service;

import br.com.ecologic.constants.Status;
import br.com.ecologic.model.*;
import br.com.ecologic.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //@Scheduled(fixedDelay = 5000)
    private void gerarAgendamentoAutomatico(){
        // para gerar o agendamento será necessário localizar todos os resíduos que atingiram a capacidade
        // em seguida, será criado o agendamento.
        // o agendamento será atrelado

        List<Residuo> lstResiduos = residuoService.buscarResiduosCapacidadeAtingida();
        if(!lstResiduos.isEmpty()){
            for(Residuo residuo : lstResiduos){
                //VERIFICAR SE EXISTE AGENDAMENTO PARA ESTE USUÁRIO EM ABERTO
                Agendamento agendamento = agendamentoService.buscarAgendamentoEmAberto(residuo.getUsuario());
                Caminhao caminhao = caminhaoService.buscarCaminhaoRandom();

                if(agendamento == null){
                    try{
                    Agendamento novoAgendamento = new Agendamento();
                    novoAgendamento.setDataAgendamento(Tools.retornaDataPosteriorDiasCorridos(new Date(), 1));
                    novoAgendamento.setUsuario(residuo.getUsuario());
                    novoAgendamento.setStatus(Status.PENDENTE);
                    novoAgendamento.setCaminhao(caminhao);
                    novoAgendamento.setTipoResiduo(residuo.getTipoResiduo());
                    agendamentoService.gravar(novoAgendamento);
                    enviarNotificacao(new Notificacao().criarNotificacao(residuo.getUsuario(), residuo.getTipoResiduo()));
                    }
                    catch(Exception e){
                        e.fillInStackTrace();
                    }
                }

            }
        }
    }

    private void enviarNotificacao(Notificacao notificacao){
        try{
            notificacaoService.gravar(notificacao);
        }
        catch(Exception e){
            e.fillInStackTrace();
        }
    }

}
