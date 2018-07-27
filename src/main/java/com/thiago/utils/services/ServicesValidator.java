package com.thiago.utils.services;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.thiago.utils.validadores.ValidadorCPF;
import com.thiago.utils.validadores.interfaces.IValidadorCPF;


@Path("validador")
public class ServicesValidator {
	
	private IValidadorCPF validador = new ValidadorCPF();
	
	@GET
	@Path("/{cpf}")
	@Produces("application/json")
	public String validaCPF(@PathParam("cpf") String cpf) {
		String resultado = "";
		if(validador.validaCPF(cpf)) {
			resultado = "valido";
		}else {
			resultado = "não é valido";
		}
		return "CPF informado: " + resultado;
	}

}
