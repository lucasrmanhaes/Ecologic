package br.com.ecologic.service;

import br.com.ecologic.model.Notificacao;
import br.com.ecologic.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private void gerarAgendamentoAutomatico(){

    }

    private void enviarNotificacao(Usuario usuario, String titulo, String mensagem){
        Notificacao notificacao = new Notificacao();
        notificacao.
    }

}
