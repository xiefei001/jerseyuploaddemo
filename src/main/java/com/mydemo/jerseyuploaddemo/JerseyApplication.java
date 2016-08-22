/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;



/**
 * @author xie.fei
 * @since 1.0
 */
@SpringBootApplication
public class JerseyApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		new JerseyApplication().configure(new SpringApplicationBuilder(JerseyApplication.class)).run(args);
	}
}
