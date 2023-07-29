package com.example.funcional;

@FunctionalInterface
public interface IPersonaPredicate<T> {
	
	public boolean evaluar(T arg);

}
