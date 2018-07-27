package com.thiago.utils.validadores;

import com.thiago.utils.validadores.interfaces.IBaseValidador;
/**
 * @version 1.0
 * @author thiago.siqueira
 *
 */
public abstract class BaseValidador implements IBaseValidador {
	
	/**
	 * 
	 * @param cpf numero de cpf a ser validado os digitos verificadores
	 * @param peso array com os numeros necessários para o calculo da validação
	 * @return retorno 0 se o calculo for invalido e retorno a soma caso seja valido
	 */
	@Override
	public int calculaDigitos(String cpf, int[] peso) {
		int soma = 0;
		for(int i = cpf.length() - 1, digito; i >= 0; i--) {
			digito = Integer.parseInt(cpf.substring(i, i + 1));
			soma += digito*peso[peso.length - cpf.length() + i];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}
	/**
	 * @return Retorno se o CPF ou CNPJ tem o tamanho e formatos validos
	 */
	@Override
	public boolean validaTamanhoDigitos(String cpf_cnpj) {
		boolean retorno = true;
		if(cpf_cnpj.length() == 14) {
			retorno = true;
		}else if(cpf_cnpj.length() == 11) {
			retorno = true;
			if(validaDigitosSequenciaisIguaisCPF(cpf_cnpj)) retorno = false;
		}else {
			retorno = false;
		}
		
		return retorno;
	}
	
	private boolean validaDigitosSequenciaisIguaisCPF(String cpf_cnpj) {
		return (cpf_cnpj.equals("00000000000") || cpf_cnpj.equals("11111111111") || cpf_cnpj.equals("22222222222")
				|| cpf_cnpj.equals("33333333333") || cpf_cnpj.equals("44444444444") || cpf_cnpj.equals("55555555555")
				|| cpf_cnpj.equals("66666666666") || cpf_cnpj.equals("77777777777") || cpf_cnpj.equals("88888888888") || cpf_cnpj.equals("99999999999"));
	}

}
