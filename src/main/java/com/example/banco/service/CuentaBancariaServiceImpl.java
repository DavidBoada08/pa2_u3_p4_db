package com.example.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banco.repo.ICuentaBancariaRepo;
import com.example.banco.repo.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;

	@Override
	public void guardarCta(CuentaBancaria cuentaBancaria) {
		this.cuentaBancariaRepo.insertar(cuentaBancaria);

	}

	@Override
	public List<CuentaBancaria> buscar(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepo.seleccionar(numero);
	}

	@Override
	public void modificar(CuentaBancaria cuentaBancaria) {
		this.cuentaBancariaRepo.actualizar(cuentaBancaria);
		
	}

}
