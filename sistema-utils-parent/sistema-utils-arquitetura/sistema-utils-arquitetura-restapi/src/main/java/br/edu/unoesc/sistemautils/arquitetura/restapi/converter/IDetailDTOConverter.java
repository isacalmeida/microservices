package br.edu.unoesc.sistemautils.arquitetura.restapi.converter;

import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;

public interface IDetailDTOConverter<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, DTO extends AbstractDTO<DTO>> {

	DTO convertToDTO(ED detailEntity);

	List<DTO> convertToDTO(List<ED> detailEntityList);

	ED convertToEntity(DTO dto);

	List<ED> convertToEntity(List<DTO> dtoList);
}
