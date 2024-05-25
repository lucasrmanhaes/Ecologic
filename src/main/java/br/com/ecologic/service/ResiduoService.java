package br.com.ecologic.service;

import br.com.ecologic.model.Residuo;
import br.com.ecologic.repository.ResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;

    public Residuo cadastrar(Residuo residuo) {
        return residuo = residuoRepository.save(residuo);
    }

    public List<Residuo> buscarResiduosCapacidadeAtingida(){
        List<Residuo> residuos = residuoRepository.findAll();
        return residuos.stream().filter(r -> r.getCapacidade() >= r.getVolume()).collect(Collectors.toList());
    }
}
