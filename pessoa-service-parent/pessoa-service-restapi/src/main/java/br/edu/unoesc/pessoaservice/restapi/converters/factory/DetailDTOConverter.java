package br.edu.unoesc.pessoaservice.restapi.converters.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.restapi.IDetailDTOConverter;

public class DetailDTOConverter<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, DTO extends AbstractDTO<DTO>> implements IDetailDTOConverter<EM, ED, DTO> {

	private Class<ED> detailEntityClass;
	private Class<DTO> dtoClass;
	
	@Autowired
	private ModelMapper modelMapper;

	protected DetailDTOConverter(Class<ED> detailEntityClass, Class<DTO> dtoClass) {
		this.detailEntityClass = detailEntityClass;
		this.dtoClass = dtoClass;
	}

	@Override
	public DTO convertToDTO(ED detailEntity) {
		return modelMapper.map(detailEntity, dtoClass);
	}

	@Override
	public List<DTO> convertToDTO(List<ED> detailEntityList) {
		return detailEntityList.stream().map(detailEntity -> convertToDTO(detailEntity)).collect(Collectors.toList());
	}

	@Override
	public ED convertToEntity(DTO dto) {
		return modelMapper.map(dto, detailEntityClass);
	}

	@Override
	public List<ED> convertToEntity(List<DTO> dtoList) {
		return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
	}
}
