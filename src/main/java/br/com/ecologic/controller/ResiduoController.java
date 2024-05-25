package br.com.ecologic.controller;

import br.com.ecologic.model.Residuo;
import br.com.ecologic.service.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResiduoController {

    @Autowired
    private ResiduoService residuoService;

    @PostMapping("/residuos")
    public Residuo cadastrarResiduo(@RequestBody Residuo residuo) {
        return residuoService.cadastrar(residuo);
    }
}