package com.example.matri.service;

import java.util.List;

import com.example.matri.repo.modelo.Materia;

public interface IMateriaService {
	
	public void guardar(Materia materia);
	public List<Materia> buscarPorCodigo (String codigo);
	
	

}
