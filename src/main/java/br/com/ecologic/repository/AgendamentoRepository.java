package br.com.ecologic.repository;

import br.com.ecologic.constants.Status;
import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {

    @Query("select t from TB_AGENDAMENTO t where t.usuario = ?1 and t.status = ?2")
    Agendamento findByUsuarioAndStatusNotEqual(Usuario usuario, Status status);
}
