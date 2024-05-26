package br.com.ecologic.service;

import br.com.ecologic.dto.CaminhaoDto;
import br.com.ecologic.model.Caminhao;
import br.com.ecologic.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public Caminhao selecionarPorId(CaminhaoDto caminhaoDto) {
        Optional<Caminhao> caminhaoOpt = caminhaoRepository.findById(caminhaoDto.id());
        if(caminhaoOpt.isPresent()) {
            return caminhaoOpt.get();
        }
        else throw new RuntimeException("Caminhão não localizado na base de dados");
    }

    public Caminhao buscarCaminhaoRandom() {
        List<Caminhao> lstCaminhoes = caminhaoRepository.findAll();
        Collections.shuffle(lstCaminhoes);
        return lstCaminhoes.get(0);
    }
}