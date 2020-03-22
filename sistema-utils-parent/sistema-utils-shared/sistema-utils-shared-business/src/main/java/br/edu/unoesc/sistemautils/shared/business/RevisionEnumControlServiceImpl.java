package br.edu.unoesc.sistemautils.shared.business;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;
import br.edu.unoesc.sistemautils.shared.common.RevisionEnumControl;
import br.edu.unoesc.sistemautils.shared.persistence.RevisionEnumControlRepository;

@Service
public class RevisionEnumControlServiceImpl extends AbstractCrudService<RevisionEnumControl, RevisionEnumControlRepository> implements RevisionEnumControlService {

}
