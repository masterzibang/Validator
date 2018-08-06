package com.thiago.utils.validadores.interfaces;

import com.thiago.utils.models.ReturnObject;

public interface IValidadorCartao {
	ReturnObject validaCartaoDeCredito(String cc);
}
