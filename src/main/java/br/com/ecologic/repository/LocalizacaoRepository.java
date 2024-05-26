package br.com.ecologic.repository;

import br.com.ecologic.model.Agendamento;
import br.com.ecologic.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, UUID> {

    @Query("select t from TB_LOCALIZACAO t where t.agendamento = ?1")
    List<Localizacao> findByAgendamento(Agendamento agendamento);

    @Query("select t from TB_LOCALIZACAO t where t.agendamento = ?1 ORDER BY t.dataOcorrencia DESC")
    List<Localizacao> findByAgendamentoOrderByDataAgendamento(Agendamento agendamento);
}
