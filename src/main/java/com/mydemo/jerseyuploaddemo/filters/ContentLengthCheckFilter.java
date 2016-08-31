/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo.filters;

import com.mydemo.jerseyuploaddemo.configure.ContentLengthChecked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;



/**
 * @author xie.fei
 * @since 1.0
 */
//@Component
@ContentLengthChecked
public class ContentLengthCheckFilter implements ContainerRequestFilter {

	private static Logger LOG = LoggerFactory.getLogger(ContentLengthCheckFilter.class);

	//@Value("${settings.max.length}")
	private long MAX_LENGTH = 10000000L;


	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String length = requestContext.getHeaderString("Content-Length");

		if (length == null){
			requestContext.abortWith(Response
					.status(Response.Status.LENGTH_REQUIRED)
					.header("Connection", "close")
					.header("Access-Control-Allow-Headers", "x-requested-with")
					.header("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE")
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Max-Age", "3600")
					.entity("Request length ist nicht gesetzt")
					.build());
			return;
		}

		long value = Long.parseLong(length);
		LOG.info("setting: " + value + "length: '" + length+"'");
		//Long actualLength
		if (value > MAX_LENGTH) {
			LOG.info("------------------------------");
			Response response = Response.status(413)
					.header("Connection", "close")
					.header("Access-Control-Allow-Headers", "x-requested-with")
					.header("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE")
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Max-Age", "3600")
					.header("Content-Length", 0)
					.build();
			//throw new WebApplicationException(response);

			//throw new RuntimeException("sdffffffffffffffffff");
			//requestContext.abortWith(response);
		}
	}
}
