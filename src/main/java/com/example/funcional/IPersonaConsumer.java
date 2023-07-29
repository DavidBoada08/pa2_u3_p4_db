package com.example.funcional;

@FunctionalInterface
public interface IPersonaConsumer <T>{
	
	public void accept(T arg);

}
