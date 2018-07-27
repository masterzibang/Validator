package com.thiago.utils.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("validador")
public class ServicesValidator {
	
	@GET
	@Produces("text/plain")
	public String olaMundo() {
		return "Olá Mundo";
	}

}
