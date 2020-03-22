package br.edu.unoesc.pessoaservice.restapi.constants;

import static br.edu.unoesc.sistemautils.arquitetura.common.RestapiConstants.ID_PARENT;

public class PessoaRestapiConstants {

	public static final String BASE_PATH_V1 = "/api/v1";
	
	public static final String PESSOA_V1 = BASE_PATH_V1 + "/pessoa";
	public static final String PESSOAFISICA_V1 = PESSOA_V1 + "/pessoafisica";
	public static final String PESSOAJURIDICA_V1 = PESSOA_V1 + "/pessoajuridica";
	public static final String PESSOA_CONTATO_V1 = PESSOA_V1 + ID_PARENT + "/contato";
	public static final String PESSOA_DOCUMENTO_V1 = PESSOA_V1 + ID_PARENT + "/documento";
	public static final String PESSOA_ENDERECO_V1 = PESSOA_V1 + ID_PARENT + "/endereco";
}
