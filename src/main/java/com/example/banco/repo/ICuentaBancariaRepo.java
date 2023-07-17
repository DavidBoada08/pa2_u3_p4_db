package com.example.banco.repo;

import java.util.List;

import com.example.banco.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	
	public void insertar (CuentaBancaria cuentaBancaria);
	public List<CuentaBancaria> seleccionar (String numero);
	public void actualizar (CuentaBancaria cuentaBancaria);
	

}
