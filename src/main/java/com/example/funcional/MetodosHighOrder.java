package com.example.funcional;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	public void metodo(IPersonaSupplier<String> funcion) {

		funcion.getID();
		LOG.info("HighOrder Suplier: " + funcion.getID());

	}

	public static void metodoConsumer(IPersonaConsumer<String> funcion, String string) {
		LOG.info("HighOrder Consumer: ");
		funcion.accept(string);
		
	}
	


	
}
