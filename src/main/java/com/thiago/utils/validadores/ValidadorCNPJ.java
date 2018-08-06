package com.thiago.utils.validadores;

import com.thiago.utils.models.ReturnObject;
import com.thiago.utils.validadores.interfaces.IValidadorCNPJ;

public class ValidadorCNPJ extends BaseValidador implements IValidadorCNPJ {
	private final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

	@Override
	public ReturnObject validaCNPJ(String cnpj) {
		boolean isValido = true;
		ReturnObject retorno = new ReturnObject();
		//retira mascara do CNPJ
		cnpj = cnpj.replaceAll("[^0-9]", "");
		
		//valida o tamanho do cnpj
		if(!validaTamanhoDigitos(cnpj)) isValido = false;
		
		//valida se o cnpj informado é valido
		if(!verificaDigitos(cnpj)) isValido = false;
		
		retorno.setData(cnpj);
		
		if(isValido) {
			retorno.setMensagem("CNPJ válido");
		}else {
			retorno.setMensagem("CNPJ inválido");
		}
		
		return retorno;
	}

	private boolean verificaDigitos(String cnpj) {
		Integer d1 = calculaDigitos(cnpj.substring(0, 12), pesoCNPJ);
		Integer d2 = calculaDigitos(cnpj.substring(0, 12) + d1, pesoCNPJ);
		
		return cnpj.equals(cnpj.substring(0, 12) + d1.toString() + d2.toString());
	}

}
