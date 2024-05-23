package br.com.ecologic.repository;

import br.com.ecologic.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResiduoRepository extends JpaRepository<Residuo, UUID> {
}
