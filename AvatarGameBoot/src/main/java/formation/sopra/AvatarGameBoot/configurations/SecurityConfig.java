package formation.sopra.AvatarGameBoot.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
				.antMatchers(HttpMethod.OPTIONS).anonymous()
				.antMatchers(HttpMethod.POST,"/api/auth/inscription").anonymous()
				.antMatchers(HttpMethod.GET,"/api/auth/check/**").authenticated()
				.antMatchers(HttpMethod.GET,"/api/auth/users/**").authenticated()
				.antMatchers(HttpMethod.GET,"/api/users/**").authenticated()
				.antMatchers("/api/**").authenticated()
			.and()
			.httpBasic();

		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}