package com.example.banco.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service


public class PruebaServiceImpl implements IPruebaService{

	@Override
	public void prueba() {
		
		System.out.println("Metodo de prueba");
		
	}

	@Override
	
	public void prueba2() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		System.out.println("Metodo de prueba2");
		
	}

	@Override
	@Transactional(value =  TxType.SUPPORTS)
	public void pruebaSupports() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		System.out.println("Metodo de prueba Supports");
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNoi_Supported() {
		
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		System.out.println("Metodo de prueba Not_Supported");
		
	}

	@Override
	@Transactional(value =  TxType.REQUIRED)
	public void pruebaRequited() {
		System.out.println("Metodo 2: "+TransactionSynchronizationManager.isActualTransactionActive());

		System.out.println("Metodo de prueba REQUIRED");		
	}

	@Override
	@Transactional (value =  TxType.REQUIRES_NEW)
	public void pruebaRequitedNew() {
		System.out.println("Metodo 2: "+TransactionSynchronizationManager.isActualTransactionActive());

		System.out.println("Metodo de prueba REQUIRES_NEW");
		
	}

}
