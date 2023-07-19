package com.example.matri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.matri.repo.IMateriaRepo;
import com.example.matri.repo.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepo materiaRepo;

	@Override
	public void guardar(Materia materia) {
		this.materiaRepo.insertar(materia);
	}

	@Override
	public List<Materia> buscarPorCodigo(String codigo) {
		
		return this.materiaRepo.seleccionarPorCodigo(codigo);
	}
	
	@Override
	public List<Materia> buscarPorCodigo2(String codigo) {
		
		return this.materiaRepo.seleccionarPorCodigo(codigo);
	}

}
