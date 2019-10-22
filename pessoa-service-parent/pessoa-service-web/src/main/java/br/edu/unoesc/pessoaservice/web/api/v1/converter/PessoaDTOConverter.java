package br.edu.unoesc.pessoaservice.web.api.v1.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.unoesc.pessoaservice.api.dto.pessoa.PessoaDTO;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Pessoa;

public class PessoaDTOConverter {

	@Autowired
	private ModelMapper modelMapper;

	public PessoaDTO convertToDTO(Pessoa pessoa) {
		return modelMapper.map(pessoa, PessoaDTO.class);
	}

	public Pessoa convertToEntity(PessoaDTO pessoaDTO) {
		return modelMapper.map(pessoaDTO, Pessoa.class);
	}
}
