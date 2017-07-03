package com.spring.henallux.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfig {
	@Bean
	public TilesConfigurer tilesConfirgurer()
	{
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {"WEB-INF/resources/tiles.xml"});
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	@Bean
	public ViewResolver tilesViewResolver ()
	{
		final TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	@Bean
	public DefaultMessageCodesResolver defaultMessageCodesResolver(){
		DefaultMessageCodesResolver defaultMessageCodesResolver = new DefaultMessageCodesResolver();
		return defaultMessageCodesResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasenames("translations/general","translations/errors");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}
	
}

