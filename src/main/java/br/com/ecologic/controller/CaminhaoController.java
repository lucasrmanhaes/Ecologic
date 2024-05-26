package br.com.ecologic.controller;

import br.com.ecologic.dto.CaminhaoDto;
import br.com.ecologic.model.Caminhao;
import br.com.ecologic.service.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/caminhao")
    @ResponseStatus(HttpStatus.OK)
    public Caminhao selecionarPorId(@RequestBody @Valid CaminhaoDto caminhaoDto) {
        return caminhaoService.selecionarPorId(caminhaoDto);
    }
}