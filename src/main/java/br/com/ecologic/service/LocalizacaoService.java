package br.com.ecologic.service;

import br.com.ecologic.dto.CaminhaoDTO;
import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Caminhao;
import br.com.ecologic.model.Localizacao;
import br.com.ecologic.model.Notificacao;
import br.com.ecologic.repository.CaminhaoRepository;
import br.com.ecologic.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public void gravar(Localizacao localizacao) {
        try{
            localizacaoRepository.save(localizacao);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Localizacao buscarLocalizacaoInicial(Agendamento agendamento) {
        List<Localizacao> localizacao = localizacaoRepository.findByAgendamento(agendamento);
        if(!localizacao.isEmpty()){
            return localizacao.get(0);
        }
        else{
            return null;
        }
    }

    public Localizacao buscarLocalizacaoFinal(Agendamento agendamento) {
        List<Localizacao> localizacao = localizacaoRepository.findByAgendamentoOrderByDataAgendamento(agendamento);
        if(!localizacao.isEmpty()){
            return localizacao.get(0);
        }
        else{
            return null;
        }
    }
}