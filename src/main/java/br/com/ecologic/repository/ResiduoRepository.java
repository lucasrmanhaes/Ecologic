package br.com.ecologic.repository;

import br.com.ecologic.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ResiduoRepository extends JpaRepository<Residuo, UUID> {

    @Query("select t from TB_RESIDUOS t where t.capacidade = t.volume and t.agendamento is null")
    List<Residuo> findByCapacidadeEqualVolumeAndAgendamentoIsNull();

}
