package br.com.ecologic.service;

import br.com.ecologic.dto.agendamento_dto.AgendamentoDto;
import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Caminhao;
import br.com.ecologic.model.Residuo;
import br.com.ecologic.model.Usuario;
import br.com.ecologic.repository.AgendamentoRepository;
import br.com.ecologic.repository.CaminhaoRepository;
import br.com.ecologic.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    private  AgendamentoRepository agendamentoRepository;
    private  UsuarioRepository usuarioRepository;
    private  CaminhaoRepository caminhaoRepository;


}


