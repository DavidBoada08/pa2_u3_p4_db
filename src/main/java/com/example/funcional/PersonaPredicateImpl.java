package com.example.funcional;

public class PersonaPredicateImpl implements IPersonaPredicate<Integer>{

	@Override
	public boolean evaluar(Integer valor) {
		
		valor = valor *valor;
		if (valor.compareTo(100) > 0) {
			return true;
		} else {
			return false;
		}
	}

}
