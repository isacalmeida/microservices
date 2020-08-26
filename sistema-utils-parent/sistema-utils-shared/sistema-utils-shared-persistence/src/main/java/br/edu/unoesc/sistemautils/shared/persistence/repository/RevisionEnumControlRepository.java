package br.edu.unoesc.sistemautils.shared.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IIdentityRepository;
import br.edu.unoesc.sistemautils.shared.common.model.RevisionEnumControl;

@Repository
public interface RevisionEnumControlRepository extends IIdentityRepository<RevisionEnumControl, Long> {

	RevisionEnumControl findByDescricaoEnum(String descricaoEnum);
}
