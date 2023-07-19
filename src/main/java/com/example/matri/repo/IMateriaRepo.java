package com.example.matri.repo;

import java.util.List;

import com.example.matri.repo.modelo.Materia;

public interface IMateriaRepo {

	public void insertar (Materia materia);
	public List<Materia> seleccionarPorCodigo (String codigo);
	public List<Materia> seleccionarPorCodigo2 (String codigo);
	
	
	
}
