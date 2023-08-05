package com.example.banco.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.banco.repo.modelo.CuentaBancaria;
import com.example.banco.service.CuentaBancariaServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaRepoImpl.class);

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
	
		LOG.info("Hilo Repository: "+Thread.currentThread().getName());
		
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
