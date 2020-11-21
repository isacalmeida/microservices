package br.edu.unoesc.sistemautils.shared.restapi.third.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.unoesc.sistemautils.shared.restapi.common.thrid.viacep.ViacepResponseDTO;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface ViacepClient {

	@GetMapping("/{cep}/json")
	ViacepResponseDTO buscarEnderecoByCep(@PathVariable("cep") String cep);
}
