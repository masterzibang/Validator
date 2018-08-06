package com.thiago.utils.validadores;

import com.thiago.utils.models.ReturnObject;
import com.thiago.utils.validadores.interfaces.IValidadorCartao;

/**
 * @version Validação utilizando o algoritimo de Luhn (mod 10)
 * @author thiago.siqueira
 *
 */
public class ValidadorCartao implements IValidadorCartao  {

	@Override
	public ReturnObject validaCartaoDeCredito(String cc) {
		int soma = 0;
		boolean numeroAlterado = false;
		ReturnObject retorno = new ReturnObject();
		
		for(int i  = cc.length() - 1; i >= 0; i--) {
			
			int n = Integer.parseInt(cc.substring(i, i + 1));
			
			if(numeroAlterado) {
				n *= 2;
				if(n > 9) {
					n = (n % 10) + 1;
				}
			}
			
			soma += n;
			numeroAlterado = !numeroAlterado;
		}
		
		retorno.setData(cc);
		if(soma % 10 == 0) {
			retorno.setMensagem("Cartão " + validaBandeira(cc) + " válido");
		}else {
			retorno.setMensagem("Cartão " + validaBandeira(cc) + " inválido");
		}
		
		return retorno;
	}
	
	/**
	 * 
	 * @param cc
	 * @return retorna a bandeira do cartão, valido no momento para VISA e MASTER CARD
	 */
	private String validaBandeira(String cc) {
		String digito1 = cc.substring(0, 1);
		String digito2 = cc.substring(0, 2);
		String bandeira = "";
		
		if(digito1.equals("4")) {
			if(cc.length() == 13 || cc.length() == 16) {
				bandeira = "VISA";
			}
		}else if(digito2.compareTo("51") >= 0 && digito2.compareTo("55") <= 0) {
			if(cc.length() == 16) {
				bandeira = "MASTER CARD";
			}
		}else {
			bandeira = "BANDEIRA DESCONHECIDA";
		}
		
		return bandeira;
	}

}
