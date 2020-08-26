package br.edu.unoesc.sistemautils.arquitetura.constants;

public abstract class BasePackagesConstants {

	private static final String DOT = ".";
	public static final String BASE_PACKAGE = "br.edu.unoesc";
	
	public static final String SISTEMA_UTILS = BASE_PACKAGE + DOT + "sistemautils";
	public static final String ARQUITETURA = SISTEMA_UTILS + DOT + "arquitetura";
	public static final String SHARED = SISTEMA_UTILS + DOT + "shared";

	public static final String ADMIN_SERVER = BASE_PACKAGE + DOT + "adminserver";
	public static final String PESSOA_SERVICE = BASE_PACKAGE + DOT + "pessoaservice";
	public static final String ZUUL_SERVER = BASE_PACKAGE + DOT + "zuulserver";
	
}
