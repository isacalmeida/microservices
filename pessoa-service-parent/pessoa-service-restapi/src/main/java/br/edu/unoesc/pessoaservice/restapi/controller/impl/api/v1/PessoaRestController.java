package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;

@RestController
@RequestMapping(PessoaRestapiConstants.PESSOA_V1)
public class PessoaRestController {

	@GetMapping
	public ResponseEntity<?> get() {
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.OPTIONS)
	public HttpEntity<List<Link>> index() {
		Link pessoaFisica = linkTo(PessoaFisicaRestController.class).withRel("Pessoa Fisica");
		Link pessoaJuridica = linkTo(PessoaJuridicaRestController.class).withRel("Pessoa Juridica");
		Link pessoaContato = linkTo(PessoaContatoRestController.class).withRel("Contato");
		Link pessoaEndereco = linkTo(PessoaEnderecoRestController.class).withRel("Endereço");
		Link pessoaTipoDocumentoPessoa = linkTo(PessoaTipoDocumentoPessoaRestController.class).withRel("Documento");
		
		List<Link> links = new ArrayList<Link>();
		links.add(pessoaFisica);
		links.add(pessoaJuridica);
		links.add(pessoaContato);
		links.add(pessoaEndereco);
		links.add(pessoaTipoDocumentoPessoa);
		
		return new HttpEntity<List<Link>>(links);
	}
}
