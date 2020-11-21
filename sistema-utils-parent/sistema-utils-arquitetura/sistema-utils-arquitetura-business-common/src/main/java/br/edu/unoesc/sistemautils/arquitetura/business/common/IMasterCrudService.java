package br.edu.unoesc.sistemautils.arquitetura.business.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;

public interface IMasterCrudService<EM extends AbstractMasterEntity> {

	Page<EM> getAllPaged(Pageable pageable);

    List<EM> getAll();

    Optional<EM> getOne(Long id);

    EM create(EM masterEntity);

    EM update(EM masterEntity);

    void delete(Long id);
}
