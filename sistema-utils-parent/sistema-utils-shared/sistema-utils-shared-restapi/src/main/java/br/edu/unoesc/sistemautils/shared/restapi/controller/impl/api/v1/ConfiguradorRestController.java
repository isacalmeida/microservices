package br.edu.unoesc.sistemautils.shared.restapi.controller.impl.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.shared.business.migration.AbstractEnumMigration;
import br.edu.unoesc.sistemautils.shared.business.migration.EnumMigration;
import br.edu.unoesc.sistemautils.shared.business.service.RevisionEnumControlService;
import br.edu.unoesc.sistemautils.shared.restapi.common.SistemaUtilsRestapiConstants;

@RestController
@RequestMapping(SistemaUtilsRestapiConstants.CONFIGURAR_V1)
public class ConfiguradorRestController {

	@Autowired
	private ApplicationContext applicationContext;

	@GetMapping("/enum/service/{service}")
	public ResponseEntity<String> configurarEnum(@PathVariable("service") String serviceSimpleClassName) {
		try {
			RevisionEnumControlService revisionEnumControlService = applicationContext.getBean(RevisionEnumControlService.class);
			EnumMigration enumMigration = new EnumMigration(revisionEnumControlService, applicationContext);
		
			AbstractEnumMigration abstractConfigurarEnumService = (AbstractEnumMigration) applicationContext.getBean(serviceSimpleClassName);
			abstractConfigurarEnumService.callMigration(enumMigration);
		
			return ResponseEntity.ok().build();
		}
		catch (Exception exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		}
	}
}
