package com.example.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	//Impresion 
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[]arg) {
		IPersona per = new PersonaImpl();
		per.caminar();
		
		//1.SUPPLIER
		//2.Clases:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase: "+supplier1.getID());
		//Lambdas
		IPersonaSupplier<String>supplier2 = ()->  "1720030723";
		LOG.info("Supplier Lambda: "+supplier2.getID());
		
		IPersonaSupplier<String>supplier3 = ()->{
			String cedula = "1720030723";
			cedula = cedula+"zzzzzz";
			return cedula;
		};
		LOG.info("Supplier Lambda2 : "+supplier3.getID());
		
		
	}

}
