package br.edu.unoesc.pessoaservice.persistence.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.unoesc.pessoaservice.business.common.service.CepService;
import br.edu.unoesc.pessoaservice.business.service.impl.CepServiceImpl;
import br.edu.unoesc.pessoaservice.common.model.Cep;
import br.edu.unoesc.pessoaservice.persistence.repository.CepRepository;

@RunWith(SpringRunner.class)
public class CepServiceImplTest {
	
	@MockBean
	protected static CepRepository cepRepository;

	@TestConfiguration
	static class CepServiceImplTestContextConfiguration {
		
		@Bean
		public CepService cepService() {
			return new CepServiceImpl();
		}
	}
	
	@Autowired
	private CepService cepService;

	@Before
	public void setUp() {
		Cep cep = new Cep();
		cep.setCep("89805057");
		
		Mockito.when(cepRepository.findByCep(cep.getCep())).thenReturn(cep);
	}
	
	@Test
	public void quandoSalvarUmCepDeveRetornarOMesmo() {
		String cep = "89805057";
		Cep cepEncontrado = cepService.getOneByCep(cep);
		
		assertThat(cepEncontrado.getCep()).isEqualTo(cep);
	}
}
