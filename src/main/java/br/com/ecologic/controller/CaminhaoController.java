package br.com.ecologic.controller;

import br.com.ecologic.dto.CaminhaoDto;
import br.com.ecologic.model.Caminhao;
import br.com.ecologic.service.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {

    private final CaminhaoService caminhaoService;

    public CaminhaoController(CaminhaoService caminhaoService) {
        this.caminhaoService = caminhaoService;
    }

    @PostMapping("/selecionar")
    public ResponseEntity<Caminhao> selecionarPorId(@RequestBody @Valid CaminhaoDto caminhaoDto) {
        return caminhaoService.selecionarPorId(caminhaoDto);
    }
}