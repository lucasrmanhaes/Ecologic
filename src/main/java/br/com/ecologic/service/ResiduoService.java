package br.com.ecologic.service;

import br.com.ecologic.dto.residuo_dto.ResiduoCadastroDto;
import br.com.ecologic.model.Residuo;
import br.com.ecologic.repository.ResiduoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResiduoService {

    private ResiduoRepository residuoRepository;

    public ResponseEntity<Residuo> cadastrar(ResiduoCadastroDto residuoCadastroDto) {
        var residuo = new Residuo(
                residuoCadastroDto.tipoResiduo(),
                residuoCadastroDto.capacidade(),
                residuoCadastroDto.volume()
        );

        Residuo residuoSalvo = residuoRepository.save(residuo);
        return ResponseEntity.ok(residuoSalvo);
    }
}
