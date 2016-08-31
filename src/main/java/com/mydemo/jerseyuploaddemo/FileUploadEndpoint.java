/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import com.mydemo.jerseyuploaddemo.configure.ContentLengthChecked;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.concurrent.TimeUnit;



/**
 * @author xie.fei
 * @since 1.0
 */
@Path("/upload")
public class FileUploadEndpoint {

	private static final Logger LOG = LoggerFactory.getLogger(FileUploadEndpoint.class);
	/*
	 * <form action="/upload" method="post" enctype="multipart/form-data"> <p> Wählen Sie eine Textdatei (*.txt, *.html
	 * usw.) von Ihrem Rechner aus:<br> <input name="file" type="file" size="50" accept="text/*"> </p> <p> <input
	 * name="filename" type="text"> </p> <input type="submit" value="... und ab geht die Post!" name="submit"> </form>
	 */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@ContentLengthChecked
	public Response upload(@FormDataParam("filename") String filename, @Context HttpServletRequest request,
			@Context HttpHeaders headers){

		String headerString = headers.getHeaderString("Content-Length").trim();
		LOG.info("file length:" + headerString);
		LOG.info("file uploaded:" + filename);

		long length = Long.parseLong(headerString);
		if (length > 10000000) {
			return Response.status(413).entity("fehler!").build();
		}
		return Response.status(200).entity("erfolgreich hochladen").build();
	}

	/*public String upload(@FormDataParam("file") InputStream fileInputStream,
		@FormDataParam("file") FormDataContentDisposition contentDispositionHeader,
		@FormDataParam("filename") String filename, @HeaderParam("Content-Length") long length ) {
		LOG.info("---------------------------------------");

		LOG.info("file length:" + length);
		LOG.info("file uploaded:" + filename);
		LOG.info("file size: " + contentDispositionHeader);

		int read = 0;
		byte[] bytes = new byte[1024];

		try {
			OutputStream outputStream = new FileOutputStream(new File("c:\\dev\\" + filename));
			while((read = fileInputStream.read(bytes)) != -1 ) {
				outputStream.write(bytes, 0, read);
				TimeUnit.MICROSECONDS.sleep(10);
				//System.out.println("loaded: " + read + " bytes");
			}

			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "uploaded: " + filename;
	}*/
}
