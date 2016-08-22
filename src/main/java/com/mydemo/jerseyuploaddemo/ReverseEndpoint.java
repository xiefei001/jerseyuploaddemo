/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;



/**
 * @author xie.fei
 * @since 1.0
 */
@Component
@Path("/reverse")
public class ReverseEndpoint {
	@GET
	public String reverse(@QueryParam("input") @NotNull String input){
		return new StringBuilder(input).reverse().toString();
	}
}
