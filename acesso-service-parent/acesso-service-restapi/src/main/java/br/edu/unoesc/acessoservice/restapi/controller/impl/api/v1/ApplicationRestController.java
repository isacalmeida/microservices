package br.edu.unoesc.acessoservice.restapi.controller.impl.api.v1;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.acessoservice.restapi.common.constants.AcessoRestapiConstants;

@RestController
@RequestMapping(AcessoRestapiConstants.ROOT_PATH)
public class ApplicationRestController {

	@GetMapping
	public ResponseEntity<?> getRootPath() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(AcessoRestapiConstants.PERFIL_V1));
		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}

	@GetMapping(AcessoRestapiConstants.API)
	public ResponseEntity<?> getApiPath() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(AcessoRestapiConstants.PERFIL_V1));
		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}

	@GetMapping(AcessoRestapiConstants.API_PATH)
	public ResponseEntity<?> getApiVersionOnePath() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(AcessoRestapiConstants.PERFIL_V1));
		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}
}
