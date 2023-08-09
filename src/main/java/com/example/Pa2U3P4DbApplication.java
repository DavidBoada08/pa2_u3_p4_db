package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.banco.repo.modelo.CuentaBancaria;
import com.example.banco.repo.modelo.Propietario;
import com.example.banco.service.ICuentaBancariaService;
import com.example.banco.service.ITransferenciaService;
import com.example.matri.service.IEstudianteService;
import com.example.matri.service.IMateriaService;
import com.example.matri.service.IMatriculaService;

@SpringBootApplication
@EnableAsync
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

		// Asyncrono sin respuesta
		/*
		 * LOG.info("Hilo: " + Thread.currentThread().getName()); long
		 * tiempoInicial=System.currentTimeMillis(); List<CuentaBancaria> lista = new
		 * ArrayList<>(); for (int i = 1; i <= 10; i++) { Propietario pro = new
		 * Propietario(); pro.setApellido("b"); pro.setCedula("123456789");
		 * CuentaBancaria cb = new CuentaBancaria(); cb.setNumero(String.valueOf(i));
		 * cb.setSaldo(new BigDecimal(2000)); cb.setTipo("Ahorros");
		 * cb.setPropietario(pro); lista.add(cb);
		 * this.bancariaService.agregarAsincrono(cb); } // fin long
		 * tiempoFinal=System.currentTimeMillis(); long
		 * tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		 * LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		 * LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		 */

		// Asyncrono con respuesta
		LOG.info("Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuesta = new ArrayList<>();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			Propietario pro = new Propietario();
			pro.setApellido("b");
			pro.setCedula("123456789");
			CuentaBancaria cb = new CuentaBancaria();
			cb.setNumero(String.valueOf(i));
			cb.setSaldo(new BigDecimal(2000));
			cb.setTipo("Ahorros");
			cb.setPropietario(pro);
			lista.add(cb);
			CompletableFuture<String> respuesta = this.bancariaService.agregarAsincrono2(cb);
			listaRespuesta.add(respuesta);
		}
		//sequencia que espera que termine de procesarse todos lops hilos para obtener la respuesta
		CompletableFuture.allOf(listaRespuesta.get(0), listaRespuesta.get(1), listaRespuesta.get(2),
				listaRespuesta.get(3), listaRespuesta.get(4), listaRespuesta.get(5), listaRespuesta.get(6),
				listaRespuesta.get(7), listaRespuesta.get(8), listaRespuesta.get(9));
		
		LOG.info("Respuesta 0:" +listaRespuesta.get(0).get());
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
		LOG.info("Se termino todo el proceso");

	}

}
