package com.iqmsoft.spring.velocity.wls.config;

import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.iqmsoft.spring.velocity.wls.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

	// private static final String MESSAGE_SOURCE =
	// "classpath:i18n/messages/velocitysample";
	private static final String VIEWS = "/WEB-INF/views/";
	private static final String RESOURCE_LOCATION = "/resources/";
	private static final String RESOURCE_HANDLER = RESOURCE_LOCATION + "**";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(RESOURCE_HANDLER).addResourceLocations(RESOURCE_LOCATION);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(viewResolver());
	}

	@Bean
	public VelocityConfigurer velocityConfigurer() {
		VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
		velocityConfigurer.setVelocityProperties(velocityProperties());
		velocityConfigurer.setResourceLoaderPath(VIEWS);
		return velocityConfigurer;

	}

	@Bean
	Properties velocityProperties() {
		Properties properties = new Properties();
		properties.setProperty("input.encoding", "UTF-8");
		properties.setProperty("outṕut.encoding", "UTF-8");
		return properties;
	}

	@Bean
	public VelocityEngine velocityEngine() {
		VelocityEngine velocityEngine = new VelocityEngine();
		return velocityEngine;
	}

	@Bean
	public ViewResolver viewResolver() {
		VelocityViewResolver velocityViewResolver = new VelocityViewResolver();
		velocityViewResolver.setCache(true);
		velocityViewResolver.setPrefix("/");
		velocityViewResolver.setSuffix(".vm");
		velocityViewResolver.setViewClass(VelocityLayoutView.class);
		return velocityViewResolver;

	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages/");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

	}

}
