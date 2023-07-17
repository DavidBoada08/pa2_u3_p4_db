package com.example.banco.repo;
import java.util.List;

import com.example.banco.repo.modelo.Transferencia;

public interface ITransferenciaRepo {

	public void insertar (Transferencia transferencia);
	
	public List<Transferencia> seleccionar (String numero);
	
	
}
