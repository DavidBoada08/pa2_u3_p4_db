package com.example;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.banco.repo.modelo.CuentaBancaria;
import com.example.banco.repo.modelo.Propietario;
import com.example.banco.service.ICuentaBancariaService;
import com.example.banco.service.ITransferenciaService;
import com.example.matri.service.IEstudianteService;
import com.example.matri.service.IMateriaService;
import com.example.matri.service.IMatriculaService;

@SpringBootApplication
public class Pa2U3P4DbApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService iestudianteService;

	@Autowired
	private IMateriaService iMateriaService;

	@Autowired
	private IMatriculaService iMatriculaService;

	@Autowired
	private ITransferenciaService iTransferenciaService;

	@Autowired
	private ICuentaBancariaService bancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//System.out.println("Main:     " + TransactionSynchronizationManager.isActualTransactionActive());

		Propietario pro = new Propietario();

		pro.setApellido("b");

		Propietario pro1 = new Propietario();

		pro1.setApellido("c");

		CuentaBancaria cb = new CuentaBancaria();
		cb.setNumero("1232456789");
		cb.setSaldo(new BigDecimal(2000));
		cb.setTipo("Ahorros");
		cb.setPropietario(pro);

		CuentaBancaria cb1 = new CuentaBancaria();
		cb1.setNumero("987654321");
		cb1.setSaldo(new BigDecimal(1000));
		cb1.setTipo("Ahorros");
		cb1.setPropietario(pro1);

		//this.bancariaService.guardarCta(cb);
		//this.bancariaService.guardarCta(cb1);
		
		this.iTransferenciaService.hacerTransferencia("987654321", "1232456789", new BigDecimal(1100));

	}

}
