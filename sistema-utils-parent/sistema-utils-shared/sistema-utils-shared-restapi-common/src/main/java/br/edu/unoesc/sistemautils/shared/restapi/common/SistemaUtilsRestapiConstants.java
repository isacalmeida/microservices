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
}
