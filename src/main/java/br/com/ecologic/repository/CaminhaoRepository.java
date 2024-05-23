package br.com.ecologic.repository;

import br.com.ecologic.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CaminhaoRepository extends JpaRepository<Caminhao, UUID> {
}
