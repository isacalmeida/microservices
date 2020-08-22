package br.edu.unoesc.sistemautils.shared.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.unoesc.sistemautils.shared.common.model.RevisionEnumControl;
import br.edu.unoesc.sistemautils.shared.persistence.repository.RevisionEnumControlRepository;

public class RevisionEnumControlServiceImplTest {

	@InjectMocks
	private RevisionEnumControlServiceImpl revisionEnumControlServiceImpl;

	@Mock
	private RevisionEnumControlRepository revisionEnumControlRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindRevisionEnumControl() {
		Long id = 1L;
		
		RevisionEnumControl revisionEnumControlFind = new RevisionEnumControl();
		revisionEnumControlFind.setId(id);
		
		Optional<RevisionEnumControl> revisionEnumControlFindOptional = Optional.of(revisionEnumControlFind);
		when(revisionEnumControlRepository.findById(id)).thenReturn(revisionEnumControlFindOptional);
		
		Optional<RevisionEnumControl> revisionEnumControlOptional = revisionEnumControlServiceImpl.getOne(id);
		
		verify(revisionEnumControlRepository).findById(id);
		assertEquals(Boolean.TRUE, revisionEnumControlOptional.isPresent());
		assertEquals(id, revisionEnumControlOptional.get().getIdRevisionEnumControl());
	}
}
