/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;



/**
 * @author xie.fei
 * @since 1.0
 */
@Component
@Path("/hello")
public class Endpoint {
	private final Service service;

	public Endpoint(Service service){
		this.service = service;
	}

	@GET
	public String message(){
		return service.message();
	}
}
