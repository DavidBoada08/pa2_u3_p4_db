package com.example.matri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.matri.repo.IEstudianteRepo;
import com.example.matri.repo.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepo estudianteRepo;

	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepo.insertar(estudiante);
	}

	@Override
	public List<Estudiante> buscarPorCedula(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarPorCedula(estudiante);
	}
	

	@Override
	public Estudiante buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionar(cedula);
	}

}
