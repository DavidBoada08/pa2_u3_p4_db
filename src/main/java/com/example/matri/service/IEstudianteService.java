package com.example.matri.service;

import java.util.List;

import com.example.matri.repo.modelo.Estudiante;

public interface IEstudianteService {
	
	public void guardar (Estudiante estudiante);
	public List<Estudiante> buscarPorCedula (String cedula);
	

}
