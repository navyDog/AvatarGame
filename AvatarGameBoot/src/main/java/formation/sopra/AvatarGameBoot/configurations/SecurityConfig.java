package formation.sopra.AvatarGameBoot.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.servlet.SessionManagementDsl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/api/**")
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/api/item").permitAll()
				.anyRequest().authenticated()
			.and()
			.httpBasic();
//		http.antMatcher("/**")
//			.csrf().disable()
//			.authorizeRequests()
//				.antMatchers("/","/home").permitAll()
//				.antMatchers("/inscription","/login").anonymous()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//					.defaultSuccessUrl("/secure/home")
//					.failureUrl("/login?error=")
//				.and()
//				.logout()
//					.logoutUrl("/logout")
//					.logoutSuccessUrl("/home");
		return http.build();
		// @formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// @formatter:off
//		//regle pour l'ensemble du site
//		http.antMatcher("/**")
//			.csrf().disable()
//			.authorizeHttpRequests()
//				.antMatchers("/home").permitAll()
//				.antMatchers("/login").permitAll()
//				.antMatchers("/inscription").permitAll()
//				.antMatchers(HttpMethod.GET,"/avatar/**").permitAll()
//				.antMatchers("/accueil/").hasAnyRole("ADMIN","USER")
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//					.defaultSuccessUrl("/secure/accueil")
//					.failureUrl("/login?error=Nul")
//				.and()
//				.logout()
//					.logoutUrl("/logout")
//					.logoutSuccessUrl("/home");
//				//.anyRequest().permitAll();
//		// @formatter:on
//	}
	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//user en mémoire
//		// @formatter:off
////		auth.inMemoryAuthentication()
////				.withUser("admin").password("{noop}admin").roles("ADMIN")
////				.and()
////				.withUser("user1").password("{noop}user1").roles("USER");
//		// @formatter:on
//		auth.userDetailsService(userDetailsService);
//	}
//	

}