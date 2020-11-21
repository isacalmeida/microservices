package br.edu.unoesc.transicaoservice.restapi.common.constants;

import static br.edu.unoesc.sistemautils.arquitetura.restapi.common.constants.RestapiConstants.ID_PARENT;

import br.edu.unoesc.sistemautils.shared.restapi.common.SistemaUtilsRestapiConstants;

public class TransicaoRestapiConstants {

	public static final String ROOT_PATH = SistemaUtilsRestapiConstants.ROOT_PATH;

	public static final String API = SistemaUtilsRestapiConstants.API;
	public static final String API_PATH = SistemaUtilsRestapiConstants.API_V1_PATH;
	public static final String BASE_PATH = SistemaUtilsRestapiConstants.BASE_PATH_V1;

	public static final String ITEM_CONFIGURACAO_V1 = BASE_PATH + "/itemconfiguracao";

	public static final String MUDANCA_V1 = BASE_PATH + "/mudanca";
	public static final String MUDANCA_ITEM_CONFIGURACAO_V1 = MUDANCA_V1 + ID_PARENT + "/itemconfiguracao";

	public static final String CATEGORIA_ITEM_CONFIGURACAO_V1 = BASE_PATH + "/categoriaitemconfiguracao";
	public static final String IMPACTO_V1 = BASE_PATH + "/impacto";
	public static final String PRIORIDADE_V1 = BASE_PATH + "/prioridade";
	public static final String STATUS_ITEM_CONFIGURACAO_V1 = BASE_PATH + "/statusitemconfiguracao";
	public static final String STATUS_MUDANCA_V1 = BASE_PATH + "/statusmudanca";
	public static final String TIPO_ITEM_CONFIGURACAO_V1 = BASE_PATH + "/tipoitemconfiguracao";
}
