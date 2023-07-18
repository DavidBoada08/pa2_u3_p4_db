package com.example.matri.repo;

import java.util.List;

import com.example.matri.repo.modelo.Estudiante;

public interface IEstudianteRepo {

	
	public void insertar (Estudiante estudiante);
	public List<Estudiante> seleccionarPorCedula (String cedula);
	
}
