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

import br.edu.unoesc.pessoaservice.business.common.service.TipoDocumentoService;
import br.edu.unoesc.pessoaservice.common.model.TipoDocumento;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoDocumento;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoDocumentoRepository;

@RunWith(SpringRunner.class)
public class TipoDocumentoServiceImplTest {

	@TestConfiguration
	static class TipoDocumentoServiceImplTestContextConfiguration {
		
		@Bean
		public TipoDocumentoService tipoDocumentoService() {
			return new TipoDocumentoServiceImpl();
		}
	}

	@Autowired
	private TipoDocumentoService tipoDocumentoService;

	@MockBean
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Before
	public void setUp() {
		List<TipoDocumento> tipoDocumentoList = EnumTipoDocumento.getListEntidade();
		
		Mockito.when(tipoDocumentoRepository.findAll()).thenReturn(tipoDocumentoList);
	}

	@Test
	public void deveRetornarAMesmaQuantidadeDeItensQueOPrevisto() {
		Integer quantidade = 3;
		List<TipoDocumento> tipoDocumentoList = tipoDocumentoService.getAll();
		
		assertThat(tipoDocumentoList.size()).isEqualTo(quantidade);
	}
}
