package br.com.ecologic.service;

import br.com.ecologic.dto.caminhao_dto.CaminhaoDto;
import br.com.ecologic.model.Caminhao;
import br.com.ecologic.repository.CaminhaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CaminhaoService {

    private final CaminhaoRepository caminhaoRepository;

    public CaminhaoService(CaminhaoRepository caminhaoRepository) {
        this.caminhaoRepository = caminhaoRepository;
    }

    public ResponseEntity<Caminhao> selecionarPorId(CaminhaoDto caminhaoDto) {
        Caminhao caminhao = caminhaoRepository.findById(caminhaoDto.id())
                .orElseThrow(() -> new IllegalArgumentException("Caminhão não encontrado"));
        return ResponseEntity.ok(caminhao);
    }
}