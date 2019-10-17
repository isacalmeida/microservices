package br.edu.unoesc.uiservice.application.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {//extends WebSecurityConfigurerAdapter{
	
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	
	//@Autowired
	//private DataSource dataSource;
	
	//@Value("${spring.queries.users-query}")
	//private String userQuery;
	
	//@Value("${spring.queries.roles-query}")
	//private String roleQuery;
//	@Autowired
//	private UsuarioBean usuarioBean;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		String usuario = usuarioBean.getUsuario();
//		String senha = usuarioBean.getSenha();
//		String role = usuarioBean.getRole();
//		
//		if(usuario == null) {
//			usuario = "admin@admin.com";
//			senha = "123456";
//			role = "ROLE_ADMIN";
//		}
//		
//		auth
//			.inMemoryAuthentication()
//			.withUser(usuario)
//			.password(senha)
//			.authorities(role);
//			//.jdbcAuthentication()
//			//.usersByUsernameQuery(userQuery)
//			//.authoritiesByUsernameQuery(roleQuery)
//			//.dataSource(dataSource)
//			//.passwordEncoder(passwordEncoder);
//			
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception{
//		http
//			.authorizeRequests()
//			.antMatchers("/login").permitAll()
//			.anyRequest()
//				.authenticated()
//					.and().csrf().disable();
//				//.formLogin()
//				//	.loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/")
//				//	.usernameParameter("email").passwordParameter("senha")
//				//.and().logout()
//				//	.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception{
//		web.ignoring().antMatchers("/webjars/**");
//		web.ignoring().antMatchers("/static/**");
//	}
}
