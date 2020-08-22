package br.edu.unoesc.sistemautils.shared.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;
import br.edu.unoesc.sistemautils.shared.common.model.RevisionEnumControl;

@Repository
public interface RevisionEnumControlRepository extends ICrudRepository<RevisionEnumControl, Long> {

	RevisionEnumControl findByDescricaoEnum(String descricaoEnum);
}
