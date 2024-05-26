package br.com.ecologic.model;

import br.com.ecologic.constants.UsuarioRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "TB_USUARIO")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_usuario")
    private UUID id;
    private String nome;
    private String cpf;
    private String telefone;
    private String cep;
    private String latitude;
    private String longitude;
    private String email;
    private String senha;
    private boolean ativo = true;
    @Enumerated(EnumType.STRING)
    private UsuarioRole role = UsuarioRole.USER;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UsuarioRole.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        else{
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    //########################### NÃO SE APLICA ###########################
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @PostLoad
    public void postLoad(){
        if(this.cep.contains("-")){
            this.cep = this.cep.replace("-", "");
        }
    }
}
