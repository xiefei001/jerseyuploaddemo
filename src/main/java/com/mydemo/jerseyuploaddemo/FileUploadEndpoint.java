/* 
 * Copyright 2016 SWM Services GmbH
 */
package com.mydemo.jerseyuploaddemo;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
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

  /*
  <form action="/upload" method="post" enctype="multipart/form-data">
	<p> Wählen Sie eine Textdatei (*.txt, *.html usw.) von Ihrem Rechner aus:<br>
    <input name="file" type="file" size="50" accept="text/*"> </p>
     <p> <input name="filename" type="text"> </p>
    <input type="submit" value="... und ab geht die Post!" name="submit">
    </form>
    */
	@POST
	@Consumes({"multipart/form-data"})
	public String upload(@FormDataParam("file") InputStream fileInputStream,
		@FormDataParam("filename") String filename) {
		return "uploaded: " + filename;
	}
}
