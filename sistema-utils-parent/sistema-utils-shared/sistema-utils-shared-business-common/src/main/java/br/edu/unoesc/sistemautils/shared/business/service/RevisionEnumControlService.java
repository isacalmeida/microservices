package br.edu.unoesc.sistemautils.shared.business.service;

import br.edu.unoesc.sistemautils.arquitetura.business.ICrudService;
import br.edu.unoesc.sistemautils.shared.common.model.RevisionEnumControl;

public interface RevisionEnumControlService extends ICrudService<RevisionEnumControl> {

	RevisionEnumControl findByDescricaoEnum(String descricaoEnum);
}
