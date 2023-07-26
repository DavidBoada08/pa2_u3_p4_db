package com.example.banco.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banco.repo.ICuentaBancariaRepo;
import com.example.banco.repo.ITransferenciaRepo;
import com.example.banco.repo.modelo.CuentaBancaria;
import com.example.banco.repo.modelo.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
@Transactional
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepo transferenciaRepo;

	@Autowired
	private ICuentaBancariaRepo bancariaRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Transferencia transferencia) {
		
		this.transferenciaRepo.insertar(transferencia);

	}

	@Override

	public List<Transferencia> mostrar(String numeroCtaOrigen) {
		// TODO Auto-generated method stub
		return this.transferenciaRepo.seleccionar(numeroCtaOrigen);
	}

	@Override
@Transactional(value = TxType.REQUIRES_NEW)
	public void hacerTransferencia(String ctaOrigen, String ctaDestino, BigDecimal monto){
		// Obtener la cuenta de origen
		List<CuentaBancaria> cuentasOrigen = bancariaRepo.seleccionar(ctaOrigen);
		if (cuentasOrigen.isEmpty()) {
			throw new RuntimeException("La cuenta de origen no existe");
		}
		CuentaBancaria cuentaOrigen = cuentasOrigen.get(0);

		// Obtener la cuenta de destino
		List<CuentaBancaria> cuentasDestino = bancariaRepo.seleccionar(ctaDestino);
		if (cuentasDestino.isEmpty()) {
			throw new RuntimeException("La cuenta de destino no existe");
		}
		CuentaBancaria cuentaDestino = cuentasDestino.get(0);

		// Verificar que la cuenta de origen tenga fondos suficientes
		BigDecimal saldoOrigen = cuentaOrigen.getSaldo();
		if (saldoOrigen.compareTo(monto) < 0) {
			throw new RuntimeException("SALDO INSUFICIENTE");
		}

		// Realizar la transferencia
		BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
		BigDecimal nuevoSaldoDestino = cuentaDestino.getSaldo().add(monto);

		// Actualizar los saldos de las cuentas
		cuentaOrigen.setSaldo(nuevoSaldoOrigen);
		cuentaDestino.setSaldo(nuevoSaldoDestino);

		// Crear la entidad Transferencia
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaBancariaOrigen(cuentaOrigen);
		transferencia.setCuentaBancariaDestino(cuentaDestino);
		transferencia.setMonto(monto);

		// Guardar la transferencia
		transferenciaRepo.insertar(transferencia);
		
		//throw new Exception();
	}

}
