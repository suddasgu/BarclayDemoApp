package com.barclay.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 * 
 * @author NirajPandey
 * @version 1.0
 * 
 */
@Configuration
public class TestContext {
	 @Bean
	    public PodamFactory podamFactory() {
	        return new PodamFactoryImpl();
	    }

}
