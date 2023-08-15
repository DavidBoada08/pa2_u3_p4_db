package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

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
import com.example.banco.service.IPropietarioService;
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
	
	@Autowired
	private IPropietarioService iPropietarioService;

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4DbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		long tiempoInicialDb = System.currentTimeMillis();

		List<CompletableFuture<Integer>> listaEdades=new ArrayList<>();
		  Random random = new Random();
		
		  for (int i = 0; i < 5; i++) {
	            Propietario pro1 = new Propietario();
	            pro1.setApellido("Boada");
	            pro1.setCedula("1720030723");
	            
	            // Genera una fecha de nacimiento aleatoria en el rango deseado
	            int year = random.nextInt(21) + 1980; // Años entre 1980 y 2000
	            int month = random.nextInt(12) + 1;   // Meses entre 1 y 12
	            int day = random.nextInt(28) + 1;     // Días entre 1 y 28 
	            pro1.setFechaNacimiento(LocalDate.of(year, month, day));
	            
	            pro1.setNombre("David");
	            
	            listaEdades.add(iPropietarioService.calcularEdad(pro1.getFechaNacimiento()));
	        }


		CompletableFuture.allOf(listaEdades.get(0),listaEdades.get(1),
				listaEdades.get(2),listaEdades.get(3),
				listaEdades.get(4));
		
		float suma=0;
		for (CompletableFuture<Integer> cf : listaEdades) {
			LOG.info("Persona su edad es : "+cf.get());
			suma=suma+(float) cf.get();
		}
		
		LOG.info("La suma de edades es : "+suma);
		
		float promedio=suma/listaEdades.size();
		LOG.info("Promedio de las 5 personas : "+(float)promedio);

		long tiempoFinal = System.currentTimeMillis();
		LOG.info("Tiempo transcurido: " + (tiempoFinal-tiempoInicialDb));
		
		LOG.info("Tiempo transcurido en segundos es: " + (tiempoFinal-tiempoInicialDb)/1000);


	
}

}
