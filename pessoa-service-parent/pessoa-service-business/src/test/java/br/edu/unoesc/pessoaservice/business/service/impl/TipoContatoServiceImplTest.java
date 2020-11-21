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

import br.edu.unoesc.pessoaservice.business.common.service.TipoContatoService;
import br.edu.unoesc.pessoaservice.common.model.TipoContato;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoContato;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoContatoRepository;

@RunWith(SpringRunner.class)
public class TipoContatoServiceImplTest {

	@TestConfiguration
	static class TipoContatoServiceImplTestContextConfiguration {
		
		@Bean
		public TipoContatoService TipoContatoService() {
			return new TipoContatoServiceImpl();
		}
	}

	@Autowired
	private TipoContatoService TipoContatoService;

	@MockBean
	private TipoContatoRepository TipoContatoRepository;

	@Before
	public void setUp() {
		List<TipoContato> TipoContatoList = EnumTipoContato.getListEntidade();
		
		Mockito.when(TipoContatoRepository.findAll()).thenReturn(TipoContatoList);
	}

	@Test
	public void deveRetornarAMesmaQuantidadeDeItensQueOPrevisto() {
		Integer quantidade = 3;
		List<TipoContato> TipoContatoList = TipoContatoService.getAll();
		
		assertThat(TipoContatoList.size()).isEqualTo(quantidade);
	}
}
