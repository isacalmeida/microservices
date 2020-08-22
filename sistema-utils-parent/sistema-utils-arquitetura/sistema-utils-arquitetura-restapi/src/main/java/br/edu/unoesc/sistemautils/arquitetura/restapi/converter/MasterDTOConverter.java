package br.edu.unoesc.sistemautils.arquitetura.restapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;

public class MasterDTOConverter<EM extends AbstractMasterEntity, DTO extends AbstractDTO<DTO>> implements IMasterDTOConverter<EM, DTO> {

	private Class<EM> masterEntityClass;
	private Class<DTO> dtoClass;
	
	@Autowired
	private ModelMapper modelMapper;

	protected MasterDTOConverter(Class<EM> masterEntityClass, Class<DTO> dtoClass) {
		this.masterEntityClass = masterEntityClass;
		this.dtoClass = dtoClass;
	}

	@Override
	public DTO convertToDTO(EM masterEntity) {
		return modelMapper.map(masterEntity, dtoClass);
	}

	@Override
	public List<DTO> convertToDTO(List<EM> masterEntityList) {
		return masterEntityList.stream().map(masterEntity -> convertToDTO(masterEntity)).collect(Collectors.toList());
	}

	@Override
	public EM convertToEntity(DTO dto) {
		return modelMapper.map(dto, masterEntityClass);
	}

	@Override
	public List<EM> convertToEntity(List<DTO> dtoList) {
		return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
	}
}
