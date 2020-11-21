package br.edu.unoesc.acessoservice.restapi.common.constants;

import static br.edu.unoesc.sistemautils.arquitetura.restapi.common.constants.RestapiConstants.ID_PARENT;

import br.edu.unoesc.sistemautils.shared.restapi.common.SistemaUtilsRestapiConstants;

public class AcessoRestapiConstants {

	public static final String ROOT_PATH = SistemaUtilsRestapiConstants.ROOT_PATH;

	public static final String API = SistemaUtilsRestapiConstants.API;
	public static final String API_PATH = SistemaUtilsRestapiConstants.API_V1_PATH;
	public static final String BASE_PATH = SistemaUtilsRestapiConstants.BASE_PATH_V1;

	public static final String PERFIL_V1 = BASE_PATH + "/perfil";
	public static final String PERFIL_ACESSO_V1 = PERFIL_V1 + ID_PARENT + "/acesso";

	public static final String TIPO_SERVICO_V1 = BASE_PATH + "/tiposervico";

	public static final String PROGRAMA_V1 = BASE_PATH + "/programa";
	public static final String USUARIO_V1 = BASE_PATH + "/usuario";
}
