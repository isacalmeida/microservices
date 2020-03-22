package br.edu.unoesc.sistemautils.arquitetura.restapi;

import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;

public interface IMasterDTOConverter<EM extends AbstractMasterEntity, DTO extends AbstractDTO<DTO>> {

	DTO convertToDTO(EM masterEntity);

	List<DTO> convertToDTO(List<EM> masterEntityList);

	EM convertToEntity(DTO dto);

	List<EM> convertToEntity(List<DTO> dtoList);
}
