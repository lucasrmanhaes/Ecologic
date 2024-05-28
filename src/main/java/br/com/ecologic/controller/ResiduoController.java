package br.com.ecologic.controller;

import br.com.ecologic.dto.ResiduoCadastroDto;
import br.com.ecologic.dto.ResiduoExibicaoDto;
import br.com.ecologic.model.Residuo;
import br.com.ecologic.service.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ResiduoController {

    @Autowired
    private ResiduoService residuoService;

    @PostMapping("/residuos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResiduoExibicaoDto cadastrar(@RequestBody ResiduoCadastroDto residuoCadastroDto) {
        return new ResiduoExibicaoDto(residuoService.cadastrar(residuoCadastroDto));
    }

    @GetMapping("/residuos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Residuo listar(@PathVariable("id") UUID id){
        return residuoService.listar(id);
    }

    @PutMapping("/residuos")
    @ResponseStatus(HttpStatus.OK)
    public Residuo atualizar(@RequestBody Residuo residuo){
        return residuoService.atualizar(residuo);
    }

    @DeleteMapping("/residuos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remover(@PathVariable("id") UUID id){
        residuoService.remover(id);
    }

}