package com.example.funcional;

public class PersonaUnaryOperatorImpl implements IPersonaUnaryOperator<Integer>{

	@Override
	public Integer aplicar(Integer arg) {
		arg = arg*2;
		return arg;
	}
	
	

}
