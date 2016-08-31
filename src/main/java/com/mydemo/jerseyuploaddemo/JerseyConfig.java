/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import com.mydemo.jerseyuploaddemo.filters.ContentLengthCheckFilter;
import com.mydemo.jerseyuploaddemo.filters.ContentLengthCheckNewFilter;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
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
		register(FileUploadEndpoint.class);
		register(MultiPartFeature.class);
		//register(ContentLengthCheckNewFilter.class);
		register(LoggingFilter.class);
	}
}
