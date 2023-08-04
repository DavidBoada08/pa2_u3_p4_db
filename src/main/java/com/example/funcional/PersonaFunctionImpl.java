package com.example.funcional;

public class PersonaFunctionImpl  implements IPersonaFunction<String, Integer> {

	@Override
	public String aplicar(Integer numero) {
		
		String valorFinal = numero.toString().concat("Valor");
		
		return valorFinal;
	
	}

}
