package com.thiago.utils.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.thiago.utils.validadores.ValidadorCNPJ;
import com.thiago.utils.validadores.ValidadorCPF;
import com.thiago.utils.validadores.interfaces.IValidadorCNPJ;
import com.thiago.utils.validadores.interfaces.IValidadorCPF;

@Path("validador")
public class ServicesValidator {
	
	private IValidadorCPF validadorCPF = new ValidadorCPF();
	private IValidadorCNPJ validadorCNPJ = new ValidadorCNPJ();
	
	@GET
	@Path("cpf/{cpf}")
	@Produces("application/json")
	public String validaCPF(@PathParam("cpf") String cpf) {
		String resultado = "";
		if(validadorCPF.validaCPF(cpf)) {
			resultado = "valido";
		}else {
			resultado = "não é valido";
		}
		return "CPF informado: " + resultado;
	}
	
	@GET
	@Path("cnpj/{cnpj}")
	@Produces("application/json")
	public String validaCNPJ(@PathParam("cnpj") String cnpj) {
		String resultado = "";
		if(validadorCNPJ.validaCNPJ(cnpj)) {
			resultado = "valido";
		}else {
			resultado = "não é valido";
		}
		
		return "CNPJ informado: " + resultado;
	}

}
