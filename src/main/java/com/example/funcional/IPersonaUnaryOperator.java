package com.example.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator <T> {
	
	public T aplicar(T arg);

}
