package com.thiago.utils.validadores;

import com.thiago.utils.validadores.interfaces.IValidadorCPF;

/**
 * @version 1.0
 * @author thiago.siqueira
 */
public class ValidadorCPF implements IValidadorCPF{
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	
	/**
	 * @param cpf numero do cpf a ser validado
	 * @return retorna se um cpf é valido ou não
	 */
	@Override
	public boolean validaCPF(String cpf) {
		boolean retorno = false;
		//Retira a mascara caso o CPF tenha
		cpf = cpf.replace(".", "").replace("-", "").trim();
		
		//Impede que CPF que sejam compostos de numeros iguais não sejam validados
		if(!validaDigitosCPFTamanhoCPF(cpf)) retorno = false;
		
		//Valida se o numero do CPF é informado é valido
		if(verificaDigitos(cpf)) retorno = true;
		
		return retorno;		
	}
	
	/**
	 * 
	 * @param cpf numero do cpf a ser validado
	 * @return retorna se o cpf tem o formato correto para validação
	 */
	private static boolean validaDigitosCPFTamanhoCPF(String cpf) {
		return (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333")
				|| cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777")
				|| cpf.equals("88888888888") || cpf.equals("99999999999") || cpf.length() != 11 || cpf == null);
	}
	/**
	 * 
	 * @param cpf numero de cpf a ser validado os digitos verificadores
	 * @param peso array com os numeros necessários para o calculo da validação
	 * @return retorno 0 se o calculo for invalido e retorno a soma caso seja valido
	 */
	private static int calculaDigitos(String cpf, int[] peso) {
		int soma = 0;
		for(int i = cpf.length() - 1, digito; i >= 0; i--) {
			digito = Integer.parseInt(cpf.substring(i, i + 1));
			soma += digito*peso[peso.length - cpf.length() + i];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}
	/**
	 * 
	 * @param cpf numero do cpf a ser validado
	 * @return retorna se o calculo dos digitos verificadores confore com o numemro do cpf informado
	 */
	private static boolean verificaDigitos(String cpf) {
		Integer d1 = calculaDigitos(cpf.substring(0, 9), pesoCPF);
		Integer d2 = calculaDigitos(cpf.substring(0, 9) + d1, pesoCPF);
		return cpf.equals(cpf.substring(0,9) + d1.toString() + d2.toString());
	}

}
