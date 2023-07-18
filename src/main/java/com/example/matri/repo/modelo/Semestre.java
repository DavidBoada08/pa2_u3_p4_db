package com.example.matri.repo.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "semestre")
public class Semestre {

	@Id
	@SequenceGenerator(name = "seq_seme", sequenceName = "seq_seme", allocationSize = 1)
	@GeneratedValue(generator = "seq_seme", strategy = GenerationType.SEQUENCE)
	@Column(name = "seme_id")
	private Integer id;
	
	@Column(name = "seme_numero")
	private String numero;
	
	@Column(name = "seme_facultad")
	private String facultad;
	
	@Column(name = "seme_universidad")
	private String universidad;
	
	@OneToMany(mappedBy = "semestre",cascade = CascadeType.ALL)
	private List<Materia> materias;
	
	//GET y SET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	


	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Semestre [id=" + id + ", numero=" + numero + ", facultad=" + facultad + ", universidad=" + universidad
				+ "]";
	}
	
	
	

}
