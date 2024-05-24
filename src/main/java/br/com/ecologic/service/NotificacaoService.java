package br.com.ecologic.service;

import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Notificacao;
import br.com.ecologic.repository.AgendamentoRepository;
import br.com.ecologic.repository.CaminhaoRepository;
import br.com.ecologic.repository.NotificacaoRepository;
import br.com.ecologic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public void gravar(Notificacao notificacao) {
        try{
            notificacaoRepository.save(notificacao);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}


