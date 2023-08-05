package com.example.banco.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banco.repo.ICuentaBancariaRepo;
import com.example.banco.repo.modelo.CuentaBancaria;

@Service
//@Transactional
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private ICuentaBancariaRepo bancariaRepo;
	@Autowired
	private IPruebaService iPruebaService;

	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;

	@Override
	public void guardarCta(CuentaBancaria cuentaBancaria) {

		LOG.info("Hilo Service: " + Thread.currentThread().getName());

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cuentaBancariaRepo.insertar(cuentaBancaria);

	}

	@Override
	public String guardarCta2(CuentaBancaria cuentaBancaria) {
		LOG.info("Hilo Service: " + Thread.currentThread().getName());

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cuentaBancariaRepo.insertar(cuentaBancaria);

		return cuentaBancaria.getNumero();

	}

	// @Transactional(value = TxType.NEVER)
	public void prueba() {

		System.out.println("metodo prueba");
	}

	@Override
	public List<CuentaBancaria> buscar(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepo.seleccionar(numero);
	}

	@Override
	public void modificar(CuentaBancaria cuentaBancaria) {
		this.cuentaBancariaRepo.actualizar(cuentaBancaria);

	}

}
