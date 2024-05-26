package br.com.ecologic.service;

import br.com.ecologic.constants.Status;
import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Caminhao;
import br.com.ecologic.model.Usuario;
import br.com.ecologic.repository.AgendamentoRepository;
import br.com.ecologic.repository.CaminhaoRepository;
import br.com.ecologic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Agendamento buscarAgendamentoEmAberto(Usuario usuario) {
        Agendamento agendamento = agendamentoRepository.findByUsuarioAndStatusEqual(usuario, Status.PENDENTE, Status.A_CAMINHO);
        return agendamento;
    }

    public List<Agendamento> buscarAgendamentoEmTransito() {
        List<Agendamento> agendamentos = agendamentoRepository.findByStatusEqual(Status.A_CAMINHO);
        if(!agendamentos.isEmpty()) {
            return agendamentos;
        }
        return new ArrayList<>();
    }

    public List<Agendamento> buscarAgendamentoPendente() {
        List<Agendamento> agendamentos = agendamentoRepository.findByStatusEqual(Status.PENDENTE);
        if(!agendamentos.isEmpty()) {
            return agendamentos;
        }
        return new ArrayList<>();
    }
}