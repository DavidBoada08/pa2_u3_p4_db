package com.example.funcional;

@FunctionalInterface
public interface IPersonaFunction<T,R> {
	
	public T aplicar(R arg);

}
