/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.InputStream;



/**
 * @author xie.fei
 * @since 1.0
 */
@Component
@Path("/upload")
public class FileUploadEndpoint {

	@POST
	public String upload(@FormDataParam("file") InputStream fileInputStream,
		@FormDataParam("filename") String filename) {
		return "uploaded: " + filename;
	}
}
