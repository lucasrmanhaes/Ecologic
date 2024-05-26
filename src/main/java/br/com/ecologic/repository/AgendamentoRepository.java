package br.com.ecologic.repository;

import br.com.ecologic.constants.Status;
import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {

    @Query("select t from TB_AGENDAMENTO t where t.usuario = ?1 and t.status in (?2, ?3)")
    Agendamento findByUsuarioAndStatusEqual(Usuario usuario, Status status, Status status2);

    @Query("select t from TB_AGENDAMENTO t where t.status = ?1")
    List<Agendamento> findByStatusEqual(Status status);
}
