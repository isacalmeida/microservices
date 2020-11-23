package br.edu.unoesc.sistemautils.shared.restapi.common;

public class SistemaUtilsRestapiConstants {

	public static final String SLASH = "/";
	public static final String API = "api";
	public static final String V1_PATH = SLASH + "v1";
	public static final String API_V1_PATH = API + V1_PATH;
	
	public static final String ROOT_PATH = SLASH;
	public static final String BASE_PATH_V1 = ROOT_PATH + API_V1_PATH;
	
	public static final String API_PATH = API_V1_PATH;
	public static final String SISTEMAUTILS_V1 = BASE_PATH_V1 + "/sistemautils";

	public static final String CONFIGURAR_V1 = SISTEMAUTILS_V1 + "/configurar";
	
	public static final String ZUUL_SERVER = "zuul-server";

	public static final String OPERACAO_SERVICE = "operacao-service";
	public static final String OPERACAO_V1 = SLASH + API_V1_PATH;

	public static final String PESSOA_SERVICE = "pessoa-service";
	public static final String PESSOA_V1 = SLASH + PESSOA_SERVICE + SLASH + API_V1_PATH;

	public static final String TRANSICAO_SERVICE = "transicao-service";
	public static final String TRANSICAO_V1 = SLASH + TRANSICAO_SERVICE + SLASH + API_V1_PATH;
}
