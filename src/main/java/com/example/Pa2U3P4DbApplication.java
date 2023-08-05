package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4DbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// System.out.println("Main: " +
		// TransactionSynchronizationManager.isActualTransactionActive());

		// imprime el nombre del hilo que se ejecuta el programa
		LOG.info("Hilo: " + Thread.currentThread().getName());
/*
		// incio
		long tiempoInicial=System.currentTimeMillis();
		
		for (int i = 0; i <= 30; i++) {
			Propietario pro = new Propietario();
			pro.setApellido("b");
			pro.setCedula("123456789");

			CuentaBancaria cb = new CuentaBancaria();
			cb.setNumero(String.valueOf(i));
			cb.setSaldo(new BigDecimal(2000));
			cb.setTipo("Ahorros");
			cb.setPropietario(pro);
			this.bancariaService.guardarCta(cb);
		}
		// fin
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		
		*/
		//-----------------------------------------------------------------
		
		/*
		// incio
				long tiempoInicial=System.currentTimeMillis();
				
				List<CuentaBancaria> lista = new ArrayList<>();
				
				
				for (int i = 1; i <= 100; i++) {
					Propietario pro = new Propietario();
					pro.setApellido("b");
					pro.setCedula("123456789");

					CuentaBancaria cb = new CuentaBancaria();
					cb.setNumero(String.valueOf(i));
					cb.setSaldo(new BigDecimal(2000));
					cb.setTipo("Ahorros");
					cb.setPropietario(pro);
					lista.add(cb);
					//this.bancariaService.guardarCta(cb);
				}
				
				//lista.stream().forEach(cta-> this.bancariaService.guardarCta(cta));
				
				lista.parallelStream().forEach(cta-> this.bancariaService.guardarCta(cta));

				
				
				// fin
				long tiempoFinal=System.currentTimeMillis();
				long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
				LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
				LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
				
		
		*/
		
		long tiempoInicial=System.currentTimeMillis();
		
		List<CuentaBancaria> lista = new ArrayList<>();
		
		
		for (int i = 1; i <= 100; i++) {
			Propietario pro = new Propietario();
			pro.setApellido("b");
			pro.setCedula("123456789");

			CuentaBancaria cb = new CuentaBancaria();
			cb.setNumero(String.valueOf(i));
			cb.setSaldo(new BigDecimal(2000));
			cb.setTipo("Ahorros");
			cb.setPropietario(pro);
			lista.add(cb);
			//this.bancariaService.guardarCta(cb);
		}
		
		//lista.stream().forEach(cta-> this.bancariaService.guardarCta(cta));
		
		
		Stream <String> listaFinal = lista.parallelStream().map(cta-> this.bancariaService.guardarCta2(cta));
		LOG.info("Se guardaronm las siguientes cuentas: ");
		listaFinal.forEach(cadena-> LOG.info(cadena));
		
		
		// fin
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		
		
		
	}

}
