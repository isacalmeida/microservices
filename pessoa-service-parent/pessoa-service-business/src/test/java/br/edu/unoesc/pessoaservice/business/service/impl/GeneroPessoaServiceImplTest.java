package br.edu.unoesc.pessoaservice.business.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.unoesc.pessoaservice.business.common.service.GeneroPessoaService;
import br.edu.unoesc.pessoaservice.common.model.GeneroPessoa;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumGeneroPessoa;
import br.edu.unoesc.pessoaservice.persistence.repository.GeneroPessoaRepository;

@RunWith(SpringRunner.class)
public class GeneroPessoaServiceImplTest {

	@TestConfiguration
	static class GeneroPessoaServiceImplTestContextConfiguration {
		
		@Bean
		public GeneroPessoaService generoPessoaService() {
			return new GeneroPessoaServiceImpl();
		}
	}

	@Autowired
	private GeneroPessoaService generoPessoaService;

	@MockBean
	private GeneroPessoaRepository generoPessoaRepository;

	@Before
	public void setUp() {
		List<GeneroPessoa> generoPessoaList = EnumGeneroPessoa.getListEntidade();
		
		Mockito.when(generoPessoaRepository.findAll()).thenReturn(generoPessoaList);
	}

	@Test
	public void deveRetornarAMesmaQuantidadeDeItensQueOPrevisto() {
		Integer quantidade = 3;
		List<GeneroPessoa> generoPessoaList = generoPessoaService.getAll();
		
		assertThat(generoPessoaList.size()).isEqualTo(quantidade);
	}
}
