package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.crud;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.CepService;
import br.edu.unoesc.pessoaservice.business.common.service.CidadeService;
import br.edu.unoesc.pessoaservice.business.common.service.EstadoService;
import br.edu.unoesc.pessoaservice.common.model.Cep;
import br.edu.unoesc.pessoaservice.common.model.Cidade;
import br.edu.unoesc.pessoaservice.common.model.Estado;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.CepDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.CepDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.thrid.viacep.ViacepResponseDTO;
import br.edu.unoesc.sistemautils.shared.restapi.third.viacep.ViacepClient;

@RestController
@RequestMapping(PessoaRestapiConstants.CEP_V1)
public class CepRestController extends AbstractRestController<Cep, CepDTO, CepService, CepDTOConverter> {

	@Autowired
	private ViacepClient viacepClient;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	@GetMapping("/find/{cep}/viacep")
	ResponseEntity<CepDTO> findOneViacep(@PathVariable String cep) {
		if(Objects.isNull(cep) || cep.length() != 8) {
			return ResponseEntity.notFound().build();
		}
		
		Cep cepFind = getService().getOneByCep(cep);
		if(Objects.nonNull(cepFind)) {
			return ResponseEntity.ok().body(getConverter().convertToDTO(cepFind));
		}
		
		ViacepResponseDTO viacepResponse = viacepClient.buscarEnderecoByCep(cep);		
		if(Objects.isNull(viacepResponse)) {
			return ResponseEntity.notFound().build();
		}
		
		String uf = viacepResponse.getUf();
		String localidade = viacepResponse.getLocalidade();
		Cidade cidade = cidadeService.findOneCidadeBySiglaAndDescricao(uf, localidade);
		if(Objects.isNull(cidade)) {
			
			Estado estado = estadoService.getOneBySigla(uf);
			if(Objects.isNull(estado)) {
				return ResponseEntity.notFound().build();				
			}
			cidade = criarCidade(viacepResponse, estado);
		}
		
		Cep cepCreated = criarCep(cep, viacepResponse, cidade);
		return create(getConverter().convertToDTO(cepCreated));
	}

	private Cep criarCep(String cepStr, ViacepResponseDTO viacepResponse, Cidade cidade) {
		Cep cep = new Cep();

		cep.setCep(cepStr);
		cep.setCidade(cidade);
		cep.setIbge(viacepResponse.getIbge());
		cep.setBairro(viacepResponse.getBairro());
		cep.setLogradouro(viacepResponse.getLogradouro());
		return cep;
	}

	private Cidade criarCidade(ViacepResponseDTO viacepResponse, Estado estado) {
		Cidade cidade = new Cidade();
		
		cidade.setDescricao(viacepResponse.getLocalidade());
		cidade.setEstado(estado);
		return cidadeService.create(cidade);
	}
}
