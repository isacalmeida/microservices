package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;

@RestController
@RequestMapping(OperacaoRestapiConstants.ROOT_PATH)
public class ApplicationRestController {

	@GetMapping
	public ResponseEntity<?> getRootPath() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(OperacaoRestapiConstants.INCIDENTE_V1));
		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}

	@GetMapping(OperacaoRestapiConstants.API)
	public ResponseEntity<?> getApiPath() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(OperacaoRestapiConstants.INCIDENTE_V1));
		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}

	@GetMapping(OperacaoRestapiConstants.API_PATH)
	public ResponseEntity<?> getApiVersionOnePath() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(OperacaoRestapiConstants.INCIDENTE_V1));
		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}
}
