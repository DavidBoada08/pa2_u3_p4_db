package com.example.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.query.spi.Limit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	// Impresion
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] arg) {
		IPersona per = new PersonaImpl();
		per.caminar();

		// 1.SUPPLIER
		LOG.info("\n\n\tInterfaz funcional Supplier");

		// Clases:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase: " + supplier1.getID());
		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "1720030723";
		LOG.info("Supplier Lambda: " + supplier2.getID());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1720030723";
			cedula = cedula + "zzzzzz";
			return cedula;
		};
		LOG.info("Supplier Lambda2 : " + supplier3.getID());

		// Metodos referenciados

		MetodosReferenciados metodos = new MetodosReferenciados();

		// //uso de los metodos referenciados los dos puntos ::
		IPersonaSupplier<Integer> supplier4 = MetodosReferenciados::getID;
		LOG.info("Supplier Metodo Referenciado: " + supplier4.getID());

		// 2.CONSUMER
		LOG.info("\n\n\tInterfaz funcional Consumer");

		// clases
		IPersonaConsumer<String> cosumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer clase: ");
		cosumer1.accept("Christian Betancourt");

		// LAMBDA
		IPersonaConsumer<String> cosumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};

		LOG.info("Consumer lambda: ");
		cosumer2.accept("Alejandro Alban");

		// Metodos referenciales

		IPersonaConsumer<String> consumer3 = MetodosReferenciados::aceptar;
		LOG.info("Consumer Metodos Referenciados");
		consumer3.accept("A");

		// 3. PREDICATE
		// Lambdas
		LOG.info("\n\n\tInterfaz funcional Predicate");
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("PRedicate lambda: " + predicate1.evaluar(4));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate lambda: " + predicate2.evaluar(95));

		String nombre = "Christian";
		IPersonaPredicate<String> predicate3 = valor -> nombre.contains("k");
		LOG.info(nombre + " contiente " + predicate3.evaluar(nombre));

		// ejemplo
		IPersonaPredicate<String> predicate4 = letra -> "David".contains(letra);
		LOG.info("Contiente " + predicate4.evaluar("h"));
		// Cuando resibo dos valores se agrega el bi exepto al unary y consumer

		IPersonaBiPredicate<String, String> predicate5 = (letra, cadena) -> cadena.contains(letra);
		LOG.info("Predicate lambda 5: " + predicate5.evaluar("q", "Christian"));

		// metodos referenciados

		IPersonaPredicate<Integer> preficate6 = metodos::evaluar;
		LOG.info("Predicate Metodos Referenciados: " + preficate6.evaluar(95));

		// 4. Function
		LOG.info("\n\n\tInterfaz funcional Function");
//						retorna 	recibe
		IPersonaFunction<String, Integer> function1 = numero -> numero.toString();
		LOG.info("Function lambda: " + function1.aplicar(10));

		IPersonaFunction<String, Integer> function = numero -> {
			String valorFinal = numero.toString().concat("Valor");
			return valorFinal;
		};

		LOG.info("Function lambda: " + function.aplicar(10));

		// Metodos Referenciados
		IPersonaFunction<String, Integer> function3 = metodos::aplicar;

		LOG.info("Function Metodos Referenciados: " + function.aplicar(10));

		// 5. UnaryOperator
		LOG.info("\n\n\tInterfaz funcional Unary Operator");
		IPersonaUnaryOperator<Integer> unary = numero -> numero + (numero * 2);
		LOG.info("UnaryOperator lambda: " + unary.aplicar(10));

		IPersonaUnaryOperatorFuction<Integer> unary1 = numero -> numero + (numero * 2);
		LOG.info("UnaryOperator lambda: " + unary1.aplicar(10));

		// metodos Referenciados
		IPersonaUnaryOperator<Integer> unary2 = metodos::aplicarUnari1;
		LOG.info("UnaryOperator Metodos Refrenciados: " + unary2.aplicar(10));

		LOG.info("\n\n\tMetodos HighOrder");

		// ******************************************************
		// METODOS HIGH OREDER

		LOG.info("\n\n\tMetodos HighOrder Supplier");
		MetodosHighOrder highOrder = new MetodosHighOrder();
		// 1. CLase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		highOrder.metodo(supplierHO);
		// 2. Lambdas
		highOrder.metodo(() -> "1720030723 HO");
		// 3. Metodos Referenciados
		highOrder.metodo(MetodosReferenciados::getIDHO);

		// -------------------------------------------------------------------
		LOG.info("\n\n\tMetodos HighOrder Consumer");
		// Clase

		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(), "Clase consumer");

		IPersonaConsumer<String> cosumerHO = new PersonaConsumerImpl();
		LOG.info("Consumer clase: ");
		cosumerHO.accept("Christian Betancourt");

		// lambda

		MetodosHighOrder.metodoConsumer(cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		}, "Lamda Consumer");

		// MR
		MetodosHighOrder.metodoConsumer(MetodosReferenciados::aceptar, "Metdo Referenciado Consumer");

		// ---------------------------------------------------------------------------------------------------
		// PROGRAMACION INTERFACES FUNCIONALES JAVA
		// ---------------------------------------------------------------------------------------------------

		// 1. Supplier
		// Supplier
		LOG.info("\n\n\tPROGRAMACION INTERFACES FUNCIONALES JAVA SUPPLIER");
		Stream<String> lsita = Stream.generate(() -> "1720030723").limit(10);
		lsita.forEach(cadena -> LOG.info(cadena));

		// 2. Consumer
		LOG.info("\n\n\tPROGRAMACION INTERFACES FUNCIONALES JAVA CONSUMER");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
				20, 21, 22, 23, 24, 25, 26, 27);
		listaNumeros.forEach(cadena -> {
			LOG.info("Prueba Consumer: " + cadena);
		});

		// 3. Predicate
		LOG.info("\n\n\tPROGRAMACION INTERFACES FUNCIONALES JAVA PREDICATE");
		Stream<Integer> listaFinal = listaNumeros.stream().filter(numero -> numero >= 5);
		listaFinal.forEach(numero -> LOG.info("Prueba Predicate: " + numero));

		// 4. Function
		LOG.info("\n\n\tPROGRAMACION INTERFACES FUNCIONALES JAVA FUNCTION");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> "N: " + numero);
		listaCambiada.forEach(cadena -> LOG.info(cadena));

		Stream<String> listaCambiada1 = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return "N: " + num;
		});
		listaCambiada1.forEach(cadena -> LOG.info(cadena));

		// 5. UnaryOperator
		LOG.info("\n\n\tPROGRAMACION INTERFACES FUNCIONALES JAVA UnaryOperator");
		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return num;
		});
		listaCambiada2.forEach(cadena -> LOG.info(cadena.toString()));
	}
}
