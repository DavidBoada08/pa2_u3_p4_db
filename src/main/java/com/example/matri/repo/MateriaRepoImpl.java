package com.example.matri.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.matri.repo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
	}

	@Override
	public List<Materia> seleccionarPorCodigo(String codigo) {		
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo", Materia.class);
		myQuery.setParameter("datoCodigo", codigo);		
		return myQuery.getResultList();
	}
	
	@Override
	public List<Materia> seleccionarPorCodigo2(String codigo) {		
		Query myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo");
		myQuery.setParameter("datoCodigo", codigo);		
		return myQuery.getResultList();
	}

}
