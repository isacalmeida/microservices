package br.edu.unoesc.sistemautils.arquitetura.restapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractEntity;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;

public class DTOConverter<E extends AbstractEntity, DTO extends AbstractDTO<DTO>> implements IDTOConverter<E, DTO> {

	private Class<E> entityClass;
	private Class<DTO> dtoClass;
	
	@Autowired
	private ModelMapper modelMapper;

	protected DTOConverter(Class<E> entityClass, Class<DTO> dtoClass) {
		this.entityClass = entityClass;
		this.dtoClass = dtoClass;
	}

	@Override
	public DTO convertToDTO(E entity) {
		return modelMapper.map(entity, dtoClass);
	}

	@Override
	public List<DTO> convertToDTO(List<E> entityList) {
		return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
	}

	@Override
	public E convertToEntity(DTO dto) {
		return modelMapper.map(dto, entityClass);
	}

	@Override
	public List<E> convertToEntity(List<DTO> dtoList) {
		return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}
}
