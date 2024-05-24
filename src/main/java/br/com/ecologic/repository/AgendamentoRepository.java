package br.com.ecologic.repository;

import br.com.ecologic.constants.Status;
import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
    Agendamento findByUsuarioAndStatusNotEqual(Usuario usuario, Status status);
}
