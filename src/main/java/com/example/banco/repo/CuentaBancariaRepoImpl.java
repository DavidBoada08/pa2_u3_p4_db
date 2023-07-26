package com.example.banco.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.banco.repo.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
	
		this.entityManager.persist(cuentaBancaria);	
		
	}
 
	@Override
	public List<CuentaBancaria> seleccionar(String numero) {
		
		Query myQuery = this.entityManager.createQuery("SELECT cta FROM CuentaBancaria cta WHERE cta.numero = :datoNumero ");
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getResultList();
		
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.entityManager.merge(cuentaBancaria);
		
	}

} 
