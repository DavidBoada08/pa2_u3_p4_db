package com.example.banco.service;

import java.util.List;

import com.example.banco.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	public void guardarCta (CuentaBancaria cuentaBancaria);
	public List<CuentaBancaria> buscar (String numero);
	public void modificar (CuentaBancaria cuentaBancaria);

}
