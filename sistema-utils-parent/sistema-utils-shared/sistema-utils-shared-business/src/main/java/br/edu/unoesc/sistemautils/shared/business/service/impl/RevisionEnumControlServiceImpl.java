package br.edu.unoesc.sistemautils.shared.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;
import br.edu.unoesc.sistemautils.shared.business.service.RevisionEnumControlService;
import br.edu.unoesc.sistemautils.shared.common.model.RevisionEnumControl;
import br.edu.unoesc.sistemautils.shared.persistence.repository.RevisionEnumControlRepository;

@Service
public class RevisionEnumControlServiceImpl extends AbstractCrudService<RevisionEnumControl, RevisionEnumControlRepository> implements RevisionEnumControlService {

	@Override
	public RevisionEnumControl findByDescricaoEnum(String descricaoEnum) {
		return getRepository().findByDescricaoEnum(descricaoEnum);
	}
}
