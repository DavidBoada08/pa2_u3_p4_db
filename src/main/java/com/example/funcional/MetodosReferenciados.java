package com.example.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	public Integer getID() {
		return 8;
	}

	public void aceptar(String arg) {
		String cadena = "Christian";
		LOG.info(cadena+ " " +arg);

	}
	
	public boolean evaluar(Integer valor) {
		Integer valor2 = 10;
		valor = valor + valor2;
		if (valor.compareTo(100) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
