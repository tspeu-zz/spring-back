package com.jmb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jmb.component.ReqTimeInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class WebMvcConfiguration.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

	/** The req time interceptor. */
	@Autowired
	@Qualifier("reqTimeInterceptor")
	private ReqTimeInterceptor reqTimeInterceptor;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(reqTimeInterceptor);
	}

	/* para utilizar la configuracion del
	 * 
	 * 
	 * */

}
