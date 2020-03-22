package br.edu.unoesc.sistemautils.arquitetura.restapi;

import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractEntity;

public interface IDTOConverter<E extends AbstractEntity, DTO extends AbstractDTO<DTO>> {

	DTO convertToDTO(E entity);

	List<DTO> convertToDTO(List<E> entityList);

	E convertToEntity(DTO dto);

	List<E> convertToEntity(List<DTO> dtoList);
}
