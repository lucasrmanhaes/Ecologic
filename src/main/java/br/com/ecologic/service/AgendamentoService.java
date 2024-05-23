package br.com.ecologic.service;

import br.com.ecologic.repository.AgendamentoRepository;
import br.com.ecologic.repository.CaminhaoRepository;
import br.com.ecologic.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    private  AgendamentoRepository agendamentoRepository;
    private  UsuarioRepository usuarioRepository;
    private  CaminhaoRepository caminhaoRepository;


}


