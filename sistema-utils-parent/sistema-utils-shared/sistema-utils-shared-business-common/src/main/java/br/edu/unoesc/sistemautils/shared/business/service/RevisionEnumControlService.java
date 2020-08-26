package br.edu.unoesc.sistemautils.shared.business.service;

import br.edu.unoesc.sistemautils.arquitetura.business.common.IIdentityService;
import br.edu.unoesc.sistemautils.shared.common.model.RevisionEnumControl;

public interface RevisionEnumControlService extends IIdentityService<RevisionEnumControl, Long> {

	RevisionEnumControl findByDescricaoEnum(String descricaoEnum);
}
