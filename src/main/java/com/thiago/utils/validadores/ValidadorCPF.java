package com.thiago.utils.validadores;

import com.thiago.utils.models.ReturnObject;
import com.thiago.utils.validadores.interfaces.IValidadorCPF;

/**
 * @version 1.0
 * @author thiago.siqueira
 */
public class ValidadorCPF extends BaseValidador implements IValidadorCPF{
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	
	/**
	 * @param cpf numero do cpf a ser validado
	 * @return retorna se um cpf � valido ou n�o
	 */
	@Override
	public ReturnObject validaCPF(String cpf) {
		//Retira a mascara caso o CPF tenha
		cpf = cpf.replaceAll("[^0-9]", "");
		boolean isTrue = true;
		ReturnObject retorno = new ReturnObject();
		
		//Impede que CPF que sejam compostos de numeros iguais n�o sejam validados
		if(!validaTamanhoDigitos(cpf)) isTrue = false;
		
		//Valida se o numero do CPF � informado � valido
		if(!verificaDigitos(cpf)) isTrue = false;
		
		retorno.setData(cpf);
		
		if(isTrue) {
			retorno.setMensagem("CPF v�lido");
		}else {
			retorno.setMensagem("CPF inv�lido");
		}
		
		return retorno;		
	}
	
	/**
	 * 
	 * @param cpf numero do cpf a ser validado
	 * @return retorna se o calculo dos digitos verificadores confore com o numemro do cpf informado
	 */
	private boolean verificaDigitos(String cpf) {
		Integer d1 = calculaDigitos(cpf.substring(0, 9), pesoCPF);
		Integer d2 = calculaDigitos(cpf.substring(0, 9) + d1, pesoCPF);
		return cpf.equals(cpf.substring(0,9) + d1.toString() + d2.toString());
	}

}
