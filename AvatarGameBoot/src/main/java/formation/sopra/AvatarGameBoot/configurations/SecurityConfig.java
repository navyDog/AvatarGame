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
<<<<<<< HEAD
				.antMatchers(HttpMethod.GET,"/api/auth/check/**").anonymous()
				.antMatchers("/api/**").anonymous()
				.antMatchers(HttpMethod.GET,"/api/auth/check/**").permitAll()
				.antMatchers("/api/**").permitAll()
=======
				.antMatchers(HttpMethod.GET,"/api/auth/check/**").authenticated()
				.antMatchers(HttpMethod.GET,"/api/auth/users/**").authenticated()
				.antMatchers("/api/**").authenticated()
>>>>>>> 6c6c19ac95fe4779912c248eb122077170941f7d
			.and()
			.httpBasic();

		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}