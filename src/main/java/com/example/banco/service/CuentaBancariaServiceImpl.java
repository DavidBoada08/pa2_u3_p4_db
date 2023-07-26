package com.example.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.banco.repo.ICuentaBancariaRepo;
import com.example.banco.repo.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
//@Transactional
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepo bancariaRepo;
	@Autowired
	private IPruebaService iPruebaService;
	
	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;

	@Override
	public void guardarCta(CuentaBancaria cuentaBancaria) {
		System.out.println("service:  "+ TransactionSynchronizationManager.isActualTransactionActive());
		this.cuentaBancariaRepo.insertar(cuentaBancaria);
		//this.prueba();
		//this.iPruebaService.prueba();
		//this.iPruebaService.prueba2();
		//this.iPruebaService.pruebaSupports();
		//this.iPruebaService.pruebaNoi_Supported();
		//this.iPruebaService.pruebaRequited();
		//this.iPruebaService.pruebaRequitedNew();
		
	}

	//@Transactional(value = TxType.NEVER)
	public void prueba() {

		System.out.println("metodo prueba");
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
