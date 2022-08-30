package siteAvatar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import AvatarGame.config.AppConfig;



@Configuration
@EnableWebMvc
@ComponentScan({ "siteAvatar.restController" })
@Import(AppConfig.class)
public class WebConfig implements WebMvcConfigurer {

}
