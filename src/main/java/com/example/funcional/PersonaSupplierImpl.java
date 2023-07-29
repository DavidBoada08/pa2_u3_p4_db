package com.example.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

	@Override
	public String getID() {
		
		String cedula = "1720030723";
		
		cedula = cedula+"zzzzzz";
		// TODO Auto-generated method stub
		return cedula;
	}



}
