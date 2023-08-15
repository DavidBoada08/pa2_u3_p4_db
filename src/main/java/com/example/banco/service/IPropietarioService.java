package com.example.banco.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import com.example.banco.repo.modelo.Propietario;

public interface IPropietarioService {
	
	public void crear (Propietario propietario);
	
	public CompletableFuture<Integer>  calcularEdad(LocalDate localDate);

}
