/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;



/**
 * @author xie.fei
 * @since 1.0
 */
@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig(){
		register(Endpoint.class);
		register(ReverseEndpoint.class);
	}
}
