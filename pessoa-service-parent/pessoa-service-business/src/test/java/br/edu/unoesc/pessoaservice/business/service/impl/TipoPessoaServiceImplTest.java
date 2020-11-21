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

import br.edu.unoesc.pessoaservice.business.common.service.TipoPessoaService;
import br.edu.unoesc.pessoaservice.common.model.TipoPessoa;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoPessoa;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoPessoaRepository;

@RunWith(SpringRunner.class)
public class TipoPessoaServiceImplTest {

	@TestConfiguration
	static class TipoPessoaServiceImplTestContextConfiguration {
		
		@Bean
		public TipoPessoaService TipoPessoaService() {
			return new TipoPessoaServiceImpl();
		}
	}

	@Autowired
	private TipoPessoaService TipoPessoaService;

	@MockBean
	private TipoPessoaRepository TipoPessoaRepository;

	@Before
	public void setUp() {
		List<TipoPessoa> TipoPessoaList = EnumTipoPessoa.getListEntidade();
		
		Mockito.when(TipoPessoaRepository.findAll()).thenReturn(TipoPessoaList);
	}

	@Test
	public void deveRetornarAMesmaQuantidadeDeItensQueOPrevisto() {
		Integer quantidade = 3;
		List<TipoPessoa> TipoPessoaList = TipoPessoaService.getAll();
		
		assertThat(TipoPessoaList.size()).isEqualTo(quantidade);
	}
}
