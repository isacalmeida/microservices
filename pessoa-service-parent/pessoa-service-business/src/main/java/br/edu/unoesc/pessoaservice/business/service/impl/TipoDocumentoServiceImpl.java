package br.edu.unoesc.pessoaservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.business.common.service.TipoDocumentoService;
import br.edu.unoesc.pessoaservice.common.model.TipoDocumento;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoDocumentoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class TipoDocumentoServiceImpl extends AbstractIdentityService<TipoDocumento, Long, TipoDocumentoRepository> implements TipoDocumentoService {

}
