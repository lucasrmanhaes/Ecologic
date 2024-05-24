package br.com.ecologic.service;

import br.com.ecologic.constants.Status;
import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Usuario;
import br.com.ecologic.repository.AgendamentoRepository;
import br.com.ecologic.repository.CaminhaoRepository;
import br.com.ecologic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    private  AgendamentoRepository agendamentoRepository;

    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Autowired
    private  CaminhaoRepository caminhaoRepository;

    public void gravar(Agendamento agendamento) {
        try{
           agendamentoRepository.save(agendamento);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*public Agendamento buscarAgendamentoEmAberto(Usuario usuario) {
        Agendamento agendamento = agendamentoRepository.findByUsuarioAndStatusNotEqual(usuario, Status.CONCLUIDO);
        return agendamento;
    }*/
}


