package com.example;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.banco.repo.modelo.CuentaBancaria;
import com.example.banco.repo.modelo.Propietario;
import com.example.banco.service.ICuentaBancariaService;
import com.example.banco.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4DbApplication implements CommandLineRunner{
	
	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	
	@Autowired
	private ITransferenciaService transferenciaService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Propietario pro1 = new Propietario();
		pro1.setApellido("Boada");
		pro1.setCedula("1720030723");
		pro1.setNombre("David");
		
		
		Propietario pro2 = new Propietario();
		pro1.setApellido("Boada");
		pro1.setCedula("1720030715");
		pro1.setNombre("Clare");
		
		CuentaBancaria cta1 = new CuentaBancaria();
		cta1.setNumero("1010101010101");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		cta1.setPropietario(pro1);
		
		this.cuentaBancariaService.guardarCta(cta1);
		
		CuentaBancaria cta2 = new CuentaBancaria();
		cta2.setNumero("1010101010102");
		cta2.setSaldo(new BigDecimal(100));
		cta2.setTipo("A");
		cta2.setPropietario(pro2);
		
		this.cuentaBancariaService.guardarCta(cta2);*/
		
		
		System.out.println("Cuenta origen ");
		System.out.println(this.cuentaBancariaService.buscar("1010101010101"));
		System.out.println("\n\n");
		
		
		System.out.println("Cuenta destino ");
		System.out.println(this.cuentaBancariaService.buscar("1010101010102"));	
		
		System.out.println("\n\n");
		
	
		
		transferenciaService.hacerTransferencia("1010101010101", "1010101010102", new BigDecimal(50));
		
	
		
		System.out.println("\n\n");
		System.out.println("ACTUALIZACION DE CUENTAS");
		System.out.println("Cuenta origen ");
		System.out.println(this.cuentaBancariaService.buscar("1010101010101"));
		System.out.println("Cuenta destino ");
		System.out.println(this.cuentaBancariaService.buscar("1010101010102"));
		
		
	}

}
