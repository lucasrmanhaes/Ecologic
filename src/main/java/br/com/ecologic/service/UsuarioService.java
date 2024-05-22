package br.com.ecologic.service;

import br.com.ecologic.Exception.UsuarioException;
import br.com.ecologic.dto.UsuarioCadastroDto;
import br.com.ecologic.dto.UsuarioExibicaoDto;
import br.com.ecologic.model.Usuario;
import br.com.ecologic.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto gravar(UsuarioCadastroDto usuarioCadastroDto){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioOpt.isPresent()){
            throw new UsuarioException("Usuario cadastrado na base dados");
        }
        else{
            usuarioRepository.save(usuario);
            return new UsuarioExibicaoDto(usuario);
        }
    }

    public UsuarioExibicaoDto BuscarPorId(UUID id){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if(usuarioOpt.isPresent()){
            return new UsuarioExibicaoDto(usuarioOpt.get());
        }
        else{
            throw new UsuarioException("Usuário não localizado na base de dados");
        }
    }

    public UsuarioExibicaoDto atualizar(Usuario usuario){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuario.getId());
        if(usuarioOpt.isPresent()){
            usuarioRepository.save(usuario);
            return new UsuarioExibicaoDto(usuario);
        }
        else{
            throw new UsuarioException("Usuário não localizado na base de dados");
        }
    }

    public void desativar(UUID id){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if(usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            usuario.setAtivo(false);
            usuarioRepository.save(usuario);
        }
        else{
            throw new UsuarioException("Usuário não localizado na base de dados");
        }
    }

}
