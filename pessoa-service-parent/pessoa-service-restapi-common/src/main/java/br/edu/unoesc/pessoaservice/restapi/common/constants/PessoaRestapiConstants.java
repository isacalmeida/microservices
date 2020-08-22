package br.edu.unoesc.pessoaservice.restapi.common.constants;

import static br.edu.unoesc.sistemautils.arquitetura.common.RestapiConstants.ID_PARENT;

import br.edu.unoesc.sistemautils.shared.restapi.common.SistemaUtilsRestapiConstants;

public class PessoaRestapiConstants {

	public static final String ROOT_PATH = SistemaUtilsRestapiConstants.ROOT_PATH;

	public static final String API = SistemaUtilsRestapiConstants.API;
	public static final String API_PATH = SistemaUtilsRestapiConstants.API_V1_PATH;
	public static final String BASE_PATH = SistemaUtilsRestapiConstants.BASE_PATH_V1;

	public static final String PESSOA_V1 = BASE_PATH + "/pessoa";
	public static final String PESSOAFISICA_V1 = PESSOA_V1 + "/pessoafisica";
	public static final String PESSOAJURIDICA_V1 = PESSOA_V1 + "/pessoajuridica";
	public static final String PESSOA_CONTATO_V1 = PESSOA_V1 + ID_PARENT + "/contato";
	public static final String PESSOA_DOCUMENTO_V1 = PESSOA_V1 + ID_PARENT + "/documento";
	public static final String PESSOA_ENDERECO_V1 = PESSOA_V1 + ID_PARENT + "/endereco";

	public static final String TIPO_DOCUMENTO_V1 = BASE_PATH + "/tipodocumento";
}
