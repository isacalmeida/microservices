package br.edu.unoesc.acessoaservice.business.service.impl;

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

import br.edu.unoesc.acessoservice.business.common.service.TipoServicoService;
import br.edu.unoesc.acessoservice.business.service.impl.TipoServicoServiceImpl;
import br.edu.unoesc.acessoservice.common.model.TipoServico;
import br.edu.unoesc.acessoservice.common.model.enums.EnumTipoServico;
import br.edu.unoesc.acessoservice.persistence.repository.TipoServicoRepository;

@RunWith(SpringRunner.class)
public class TipoServicoServiceImplTest {

	@TestConfiguration
	static class TipoServicoServiceImplTestContextConfiguration {
		
		@Bean
		public TipoServicoService tipoServicoService() {
			return new TipoServicoServiceImpl();
		}
	}

	@Autowired
	private TipoServicoService tipoServicoService;

	@MockBean
	private TipoServicoRepository tipoServicoRepository;

	@Before
	public void setUp() {
		List<TipoServico> tipoServicoList = EnumTipoServico.getListEntidade();
		
		Mockito.when(tipoServicoRepository.findAll()).thenReturn(tipoServicoList);
	}

	@Test
	public void deveRetornarAMesmaQuantidadeDeItensQueOPrevisto() {
		Integer quantidade = 2;
		List<TipoServico> tipoDocumentoList = tipoServicoService.getAll();
		
		assertThat(tipoDocumentoList.size()).isEqualTo(quantidade);
	}
}
