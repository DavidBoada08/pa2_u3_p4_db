package com.example.matri.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.matri.repo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public List<Estudiante> seleccionarPorCedula(Estudiante estudiante) {
		
		Query myQuery = this.entityManager.createQuery("SELECT m FROM Matricula m WHERE m.estudiante = :datoEstudiante");
		myQuery.setParameter("datoEstudiante", estudiante);		
		return myQuery.getResultList();
	}

	@Override
	public Estudiante seleccionar(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> query= this.entityManager.createQuery("SELECT e from Estudiante e where e.cedula=:datoCedula", Estudiante.class);
	     query.setParameter("datoCedula",cedula);
		return query.getSingleResult();
	}

	
	
}
