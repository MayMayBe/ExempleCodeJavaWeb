package com.spring.henallux.config;

import java.util.Locale;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MainConfig extends WebMvcConfigurerAdapter{
	@Bean
	public LocaleResolver localeResolver(){
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(-1);
		return (LocaleResolver) resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("locale");
		registry.addInterceptor(interceptor);
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(){
		return new HibernateJpaSessionFactoryBean();
	}

}