package br.edu.unoesc.pessoaservice.application.security;

//@Configuration
//@EnableResourceServer
//@EnableConfigurationProperties(SecurityProperties.class)
public class ResourceServerConfig { //extends ResourceServerConfigurerAdapter {

//	private static final String ROOT_PATTERN = "/**";
//
//    private final SecurityProperties securityProperties;
//
//    private TokenStore tokenStore;
//
//    public ResourceServerConfig(final SecurityProperties securityProperties) {
//        this.securityProperties = securityProperties;
//    }
//
//    @Override
//    public void configure(final ResourceServerSecurityConfigurer resources) {
//        resources.tokenStore(tokenStore());
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET, ROOT_PATTERN).access("#oauth2.hasScope('read')")
//                .antMatchers(HttpMethod.POST, ROOT_PATTERN).access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.PATCH, ROOT_PATTERN).access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.PUT, ROOT_PATTERN).access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.DELETE, ROOT_PATTERN).access("#oauth2.hasScope('write')");
//    }
//
//    @Bean
//    public DefaultTokenServices tokenServices(final TokenStore tokenStore) {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setTokenStore(tokenStore);
//        return tokenServices;
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        if (tokenStore == null) {
//            tokenStore = new JwtTokenStore(jwtAccessTokenConverter());
//        }
//        return tokenStore;
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setVerifierKey(getPublicKeyAsString());
//        return converter;
//    }
//
//    private String getPublicKeyAsString() {
//        try {
//            return IOUtils.toString(securityProperties.getJwt().getPublicKey().getInputStream(), UTF_8);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
