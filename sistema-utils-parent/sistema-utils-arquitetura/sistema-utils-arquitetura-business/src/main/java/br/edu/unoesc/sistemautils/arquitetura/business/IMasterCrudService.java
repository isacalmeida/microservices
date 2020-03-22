package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;

public interface IMasterCrudService<EM extends AbstractMasterEntity> {

	Page<EM> getAllPaged(Integer page, Integer size);

    List<EM> getAll();

    Optional<EM> getOne(Long id);

    EM create(EM masterEntity);

    EM update(EM masterEntity);

    void delete(Long id);
}
