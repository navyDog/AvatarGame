package formation.sopra.AvatarGameBoot.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		//regle pour l'ensemble du site
		http.antMatcher("/**")
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.GET,"/avatar/**")
					.permitAll()
				
				.antMatchers("/api/**")
					.hasAnyRole("ADMIN")
					
				.anyRequest().authenticated()
				.and()
				.formLogin();
				//.anyRequest().permitAll();
		// @formatter:on
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//user en mémoire
		// @formatter:off
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("{noop}admin").roles("ADMIN")
//				.and()
//				.withUser("user1").password("{noop}user1").roles("USER");
		// @formatter:on
		auth.userDetailsService(userDetailsService);
	}
	
}