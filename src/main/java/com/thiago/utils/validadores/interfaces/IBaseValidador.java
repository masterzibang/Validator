package com.thiago.utils.validadores.interfaces;

public abstract interface IBaseValidador {
	 int calculaDigitos(String verificador, int[] peso);
	 boolean validaTamanhoDigitos(String cpf_cnpj);
}
