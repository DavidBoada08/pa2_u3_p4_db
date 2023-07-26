package com.example.banco.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.banco.repo.modelo.Transferencia;

public interface ITransferenciaService {

	public void guardar(Transferencia transferencia);

	public List<Transferencia> mostrar(String numeroCtaOrigen);
	
	public void hacerTransferencia (String ctaOrigen, String ctaDestino, BigDecimal monto) ;

}
