package com.thiago.utils.validadores;

import com.thiago.utils.validadores.interfaces.IValidadorCNPJ;

public class ValidadorCNPJ extends BaseValidador implements IValidadorCNPJ {
	private final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

	@Override
	public boolean validaCNPJ(String cnpj) {
		//retira mascara do CNPJ
		cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "").trim();
		
		//valida o tamanho do cnpj
		if(!validaTamanhoDigitos(cnpj)) return false;
		
		//valida se o cnpj informado é valido
		if(!verificaDigitos(cnpj)) return false;
		
		return true;
	}

	@Override
	public boolean verificaDigitos(String cnpj) {
		Integer d1 = calculaDigitos(cnpj.substring(0, 12), pesoCNPJ);
		Integer d2 = calculaDigitos(cnpj.substring(0, 12) + d1, pesoCNPJ);
		
		return cnpj.equals(cnpj.substring(0, 12) + d1.toString() + d2.toString());
	}

}
