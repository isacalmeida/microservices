package br.edu.unoesc.pessoaservice.application.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.edu.unoesc.pessoaservice.common.model.enums.EnumGeneroPessoa;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoContato;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoDocumento;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoEndereco;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoPessoa;
import br.edu.unoesc.sistemautils.arquitetura.application.ApplicationStarter;
import br.edu.unoesc.sistemautils.arquitetura.constants.BasePackagesConstants;

@EntityScan(BasePackagesConstants.PESSOA_SERVICE)
@ComponentScan(BasePackagesConstants.PESSOA_SERVICE)
@EnableJpaRepositories(BasePackagesConstants.PESSOA_SERVICE)
@SpringBootApplication(scanBasePackages = BasePackagesConstants.PESSOA_SERVICE)
public class PessoaServiceApplication extends ApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(PessoaServiceApplication.class, args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Class<?>> getEnumList() {
		List<Class<?>> enumList = new ArrayList<>();
		enumList.add(EnumGeneroPessoa.class);
		enumList.add(EnumTipoContato.class);
		enumList.add(EnumTipoDocumento.class);
		enumList.add(EnumTipoEndereco.class);
		enumList.add(EnumTipoPessoa.class);
		return enumList;
	}
}
