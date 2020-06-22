package br.edu.unoesc.sistemautils.arquitetura.restapi.converter;

import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;

public interface IIdentityDTOConverter<E extends IIdentityEntity<ID>, ID extends Number, DTO extends AbstractDTO<DTO>> {

	DTO convertToDTO(E entity);

	List<DTO> convertToDTO(List<E> entityList);

	E convertToEntity(DTO dto);

	List<E> convertToEntity(List<DTO> dtoList);
}
