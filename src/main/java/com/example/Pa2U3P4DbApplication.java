package com.example;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.matri.repo.modelo.Estudiante;
import com.example.matri.repo.modelo.Materia;
import com.example.matri.repo.modelo.Matricula;
import com.example.matri.repo.modelo.Provincia;
import com.example.matri.repo.modelo.Semestre;
import com.example.matri.service.IEstudianteService;
import com.example.matri.service.IMateriaService;
import com.example.matri.service.IMatriculaService;

@SpringBootApplication
public class Pa2U3P4DbApplication implements CommandLineRunner{
	
	
	@Autowired
	private IEstudianteService iestudianteService;
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Provincia prov1 = new Provincia();
		prov1.setCanton("Quito");
		prov1.setNombre("Pichincha");
		prov1.setKm(12458.25);
		
		Estudiante estu1= new Estudiante();
		
		estu1.setApellido("Boada");
		estu1.setCedula("1720030723");
		estu1.setNombre("David");
		estu1.setProvincia(prov1);
		
		
		
		Semestre seme1 = new Semestre();
		seme1.setFacultad("Ciencias Fisicas");
		seme1.setNumero("Primero");
		seme1.setUniversidad("UCE");
		
		Materia mate1 = new Materia();
		mate1.setCapacidad(50);
		mate1.setNombre("Fisica");
		mate1.setCodigo("UCF001");
		mate1.setSemestre(seme1);

		
		Matricula matri1 = new Matricula();
		matri1.setBeca("Aplica");
		matri1.setFecha(LocalDateTime.now());
		matri1.setMateria(mate1);
		matri1.setEstudiante(estu1);
		matri1.setNumero("uno");
		
		this.iMatriculaService.guardar(matri1);
		
		
		
	
		
		
	}

}
