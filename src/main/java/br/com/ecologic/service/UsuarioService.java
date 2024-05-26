package br.com.ecologic.service;

import br.com.ecologic.Exception.UsuarioException;
import br.com.ecologic.constants.UsuarioRole;
import br.com.ecologic.dto.UsuarioCadastroDto;
import br.com.ecologic.dto.UsuarioExibicaoDto;
import br.com.ecologic.model.Usuario;
import br.com.ecologic.repository.UsuarioRepository;
import br.com.ecologic.util.Tools;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioExibicaoDto gravar(UsuarioCadastroDto usuarioCadastroDto){
        UserDetails usuarioDetails = usuarioRepository.findByEmail(usuarioCadastroDto.email());
        if(usuarioDetails != null){
            throw new UsuarioException("Usuário já cadastrado na base");
        }
        else{
            String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());
            Usuario usuario = new Usuario();
            BeanUtils.copyProperties(usuarioCadastroDto, usuario);
            usuario.setSenha(senhaCriptografada);

            if(usuario.getRole() == null){
                usuario.setRole(UsuarioRole.USER);
            }
            if(!usuario.isAtivo()){
                usuario.setAtivo(true);
            }

            //localiza latitude longitude
            String[] latitudeLongitude = Tools.latitudeLongitude(usuarioCadastroDto.cep());
            if (latitudeLongitude != null) {
                usuario.setLatitude(latitudeLongitude[0]);
                usuario.setLongitude(latitudeLongitude[1]);
            }

            return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
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
