package br.com.ecologic.service;

import br.com.ecologic.dto.ResiduoCadastroDto;
import br.com.ecologic.model.Residuo;
import br.com.ecologic.repository.ResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResiduoService {

    @Autowired
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

    public List<Residuo> buscarResiduosCapacidadeAtingida(){
        List<Residuo> residuos = residuoRepository.findAll();

        return residuos.stream()
                .filter(r -> r.getCapacidade() >= r.getVolume())
                .collect(Collectors.toList());
    }
}
