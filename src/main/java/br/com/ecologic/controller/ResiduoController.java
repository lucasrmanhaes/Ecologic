package br.com.ecologic.controller;

import br.com.ecologic.dto.ResiduoCadastroDto;
import br.com.ecologic.model.Residuo;
import br.com.ecologic.service.ResiduoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/residuos")
public class ResiduoController {

    private final ResiduoService residuoService;

    public ResiduoController(ResiduoService residuoService) {
        this.residuoService = residuoService;
    }

    @PostMapping
    public ResponseEntity<Residuo> cadastrarResiduo(@RequestBody @Valid ResiduoCadastroDto residuoCadastroDto) {
        return residuoService.cadastrar(residuoCadastroDto);
    }
}
