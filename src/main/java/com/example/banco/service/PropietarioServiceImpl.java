package com.example.banco.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Repository;

import com.example.banco.repo.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropietarioServiceImpl implements IPropietarioService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Propietario propietario) {
		this.entityManager.persist(propietario);
		
	}

	@Override
	public CompletableFuture<Integer> calcularEdad(LocalDate localDate) {
		
		Period edad= Period.between(localDate, localDate.now());
		try {
			TimeUnit.SECONDS.sleep(10);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(edad.getYears());
	}
	
	

	
}
