package com.example.banco.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)
	@Column(name = "trans_id")
	private Integer id;
	
	@Column(name="trans_fecha")
	private LocalDateTime fecha;
	
	@Column(name="trans_monto")
	private BigDecimal monto;
	
	@ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cta_origen")
	private CuentaBancaria cuentaBancariaOrigen;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cta_destino")
	private CuentaBancaria cuentaBancariaDestino;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaBancariaOrigen() {
		return cuentaBancariaOrigen;
	}

	public void setCuentaBancariaOrigen(CuentaBancaria cuentaBancariaOrigen) {
		this.cuentaBancariaOrigen = cuentaBancariaOrigen;
	}

	public CuentaBancaria getCuentaBancariaDestino() {
		return cuentaBancariaDestino;
	}

	public void setCuentaBancariaDestino(CuentaBancaria cuentaBancariaDestino) {
		this.cuentaBancariaDestino = cuentaBancariaDestino;
	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", cuentaBancariaOrigen="
				+ cuentaBancariaOrigen + ", cuentaBancariaDestino=" + cuentaBancariaDestino + "]";
	}
	
	
}
