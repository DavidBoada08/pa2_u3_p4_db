package com.example.matri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.matri.repo.IMatriculaRepo;
import com.example.matri.repo.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepo matriculaRepo;

	@Override
	public void guardar(Matricula matricula) {
		this.matriculaRepo.insertar(matricula);
	}

}
