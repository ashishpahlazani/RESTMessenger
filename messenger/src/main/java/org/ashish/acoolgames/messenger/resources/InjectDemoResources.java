package org.ashish.acoolgames.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResources {

	@GET
	@Path("annotations")
	public String getParamUsingAnnotation(@MatrixParam("param") String param,
			@MatrixParam("param1") String param1,
			@HeaderParam("customHeaderValue") String customHeaderValue,
			@CookieParam("name") String cookieName) {
		return "Matrix Param: " + param + " param1:" + param1
				+ " customHeaderValue: " + customHeaderValue + " cookieName: "
				+ cookieName;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers)
	{
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		
		return "Path: " + path + " Cookies: " + cookies + " Headers: " + headers;
	}
	
}
