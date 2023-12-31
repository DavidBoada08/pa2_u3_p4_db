package com.example.banco.repo;	

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.banco.repo.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Transferencia transferencia) {
		this.entityManager.persist(transferencia);
	}

	@Override
	public List<Transferencia> seleccionar(String numero) {
		
		Query myQuery = this.entityManager.createQuery("SELECT t FROM Transferencia t WHERE t.numero = :datoNumero");
		myQuery.setParameter("datoNumero", numero);
		
		return myQuery.getResultList();
	}
	
	


}
