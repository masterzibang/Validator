package com.thiago.utils.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiago.utils.validadores.ValidadorCNPJ;
import com.thiago.utils.validadores.ValidadorCPF;
import com.thiago.utils.validadores.ValidadorCartao;
import com.thiago.utils.validadores.interfaces.IValidadorCNPJ;
import com.thiago.utils.validadores.interfaces.IValidadorCPF;
import com.thiago.utils.validadores.interfaces.IValidadorCartao;

@Path("validador")
public class ServicesValidator {
	
	private IValidadorCPF validadorCPF = new ValidadorCPF();
	private IValidadorCNPJ validadorCNPJ = new ValidadorCNPJ();
	private IValidadorCartao validadorCartao = new ValidadorCartao();
	private ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("cpf/{cpf}")
	@Produces({"application/xml", "application/json"})
	public String validaCPF(@PathParam("cpf") String cpf){
		try {
			return mapper.writeValueAsString(validadorCPF.validaCPF(cpf));
		}catch(JsonProcessingException e) {
			return "Erro ao validar CPF::"+e.getMessage();
		}	
	}
	
	@GET
	@Path("cnpj/{cnpj : .+}")
	@Produces({"application/xml", "application/json"})
	public String validaCNPJ(@PathParam("cnpj") String cnpj){
		try {
			return mapper.writeValueAsString(validadorCNPJ.validaCNPJ(cnpj));
		}catch(JsonProcessingException e) {
			return "Erro ao validar CNPJ::"+e.getMessage();
		}		
	}
	
	@POST
	@Path("cc/{cc}")
	@Produces({"application/xml", "application/json"})
	public String validaCartao(@PathParam("cc") String numeroCatao){
		try {
			return mapper.writeValueAsString(validadorCartao.validaCartaoDeCredito(numeroCatao));
		}catch (JsonProcessingException e) {
			return "Erro ao validar Cartão de Crédito::"+e.getMessage();
		}
	}

}
