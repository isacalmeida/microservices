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

import br.edu.unoesc.pessoaservice.business.common.service.TipoEnderecoService;
import br.edu.unoesc.pessoaservice.common.model.TipoEndereco;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoEndereco;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoEnderecoRepository;

@RunWith(SpringRunner.class)
public class TipoEnderecoServiceImplTest {

	@TestConfiguration
	static class TipoEnderecoServiceImplTestContextConfiguration {
		
		@Bean
		public TipoEnderecoService TipoEnderecoService() {
			return new TipoEnderecoServiceImpl();
		}
	}

	@Autowired
	private TipoEnderecoService TipoEnderecoService;

	@MockBean
	private TipoEnderecoRepository TipoEnderecoRepository;

	@Before
	public void setUp() {
		List<TipoEndereco> TipoEnderecoList = EnumTipoEndereco.getListEntidade();
		
		Mockito.when(TipoEnderecoRepository.findAll()).thenReturn(TipoEnderecoList);
	}

	@Test
	public void deveRetornarAMesmaQuantidadeDeItensQueOPrevisto() {
		Integer quantidade = 3;
		List<TipoEndereco> TipoEnderecoList = TipoEnderecoService.getAll();
		
		assertThat(TipoEnderecoList.size()).isEqualTo(quantidade);
	}
}
