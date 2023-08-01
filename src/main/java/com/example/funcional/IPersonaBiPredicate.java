package com.example.funcional;

@FunctionalInterface
public interface IPersonaBiPredicate<T,R> {

	public boolean evaluar (T arg1 , R arg2);
	
	
}
