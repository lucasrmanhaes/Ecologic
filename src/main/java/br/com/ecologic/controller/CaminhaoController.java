package br.com.ecologic.controller;

import br.com.ecologic.dto.CaminhaoDTO;
import br.com.ecologic.dto.ResiduoCadastroDto;
import br.com.ecologic.dto.ResiduoExibicaoDto;
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
    public Caminhao selecionarPorId(@RequestBody @Valid CaminhaoDTO caminhaoDTO) {
        return caminhaoService.selecionarPorId(caminhaoDTO);
    }

}