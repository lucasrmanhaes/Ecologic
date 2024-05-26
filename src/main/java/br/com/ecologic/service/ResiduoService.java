package br.com.ecologic.service;

import br.com.ecologic.Exception.UsuarioException;
import br.com.ecologic.dto.ResiduoCadastroDto;
import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Residuo;
import br.com.ecologic.model.Usuario;
import br.com.ecologic.repository.ResiduoRepository;
import br.com.ecologic.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Residuo cadastrar(ResiduoCadastroDto residuoCadastroDto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(residuoCadastroDto.idUsuario());
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Residuo residuo = new Residuo();
            BeanUtils.copyProperties(residuoCadastroDto, residuo);
            residuo.setUsuario(usuario);
            return residuoRepository.save(residuo);
        }
        else{
            throw new UsuarioException("Usuário não encontrado na base de dados");
        }
    }

    public void gravar(Residuo residuo) {
        try{
            residuoRepository.save(residuo);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Residuo listar(UUID idResiduo){
        Optional<Residuo> residuoOpt = residuoRepository.findById(idResiduo);
        if (residuoOpt.isPresent()) {
            return residuoOpt.get();
        }
        else{
            throw new RuntimeException("Residuo não localizado na base de dados");
        }
    }

    public Residuo atualizar(Residuo residuo){
        Optional<Residuo> residuoOpt = residuoRepository.findById(residuo.getId());
        if(residuoOpt.isPresent()){
            return residuoRepository.save(residuo);
        }
        else{
            throw new RuntimeException("Residuo");
        }
    }

    public void remover(UUID id){
        Optional<Residuo> residuoOpt = residuoRepository.findById(id);
        if (residuoOpt.isPresent()) {
            residuoRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Residuo não localizado na base de dados");
        }
    }

    public List<Residuo> buscarResiduosCapacidadeAtingida(){
        List<Residuo> residuos = residuoRepository.findByCapacidadeEqualVolumeAndAgendamentoIsNull();
        if(!residuos.isEmpty()){
            return residuos;
        }
        else{
            return new ArrayList<>();
        }
    }
}
