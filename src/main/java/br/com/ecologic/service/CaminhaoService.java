package br.com.ecologic.service;

import br.com.ecologic.dto.CaminhaoDto;
import br.com.ecologic.model.Caminhao;
import br.com.ecologic.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public CaminhaoService(CaminhaoRepository caminhaoRepository) {
        this.caminhaoRepository = caminhaoRepository;
    }

    public ResponseEntity<Caminhao> selecionarPorId(CaminhaoDto caminhaoDto) {
        Caminhao caminhao = caminhaoRepository.findById(caminhaoDto.id())
                .orElseThrow(() -> new IllegalArgumentException("Caminhão não encontrado"));
        return ResponseEntity.ok(caminhao);
    }

    public Caminhao buscarCaminhaoRandom() {
        List<Caminhao> lstCaminhoes = caminhaoRepository.findAll();
        Collections.shuffle(lstCaminhoes);
        return lstCaminhoes.get(0);
    }
}