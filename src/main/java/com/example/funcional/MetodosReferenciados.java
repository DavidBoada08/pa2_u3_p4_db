package com.example.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	public static Integer getID() {
		return 8;
	}
	
	public static String getIDHO() {
		LOG.info("Metodos REferenciados y HO");
		return "Christian Boada";
	}


	public static void  aceptar(String arg) {
		String cadena = "Christian";
		LOG.info(cadena+ " " +arg);

	}
	
	public boolean evaluar(Integer valor) {
		Integer valor2 = 10;
		valor = valor + valor2;
		if (valor.compareTo(100) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String aplicar(Integer numero) {
		String valorFinal = numero.toString().concat("Valor");
		return valorFinal;
		
	}
	
	public Integer aplicarUnari1(Integer numero) {
		Integer valor = numero+(numero*2);
		return valor;
		
	}
	
	
	
	/////// deber
	
	// SUPPLIER
    // Método que devuelve un saludo personalizado
    public static String ejemplo1() {
        return "¡Hola! Bienvenido a este ejemplo.";
    }

    // CONSUMER
    // Método que imprime el cuadrado de un número
    public static void ejemplo12(Integer num) {
        int cuadrado = num * num;
        LOG.info("Ejemplo de Consumer - Cuadrado de " + num + ": " + cuadrado);
    }

    // PREDICATE
    // Método que devuelve true si un número es positivo
    public static boolean ejemplo3(Integer num) {
        boolean resultado = num > 0;
        if (resultado) {
            LOG.info("Ejemplo de Predicate - Número positivo: " + num);
        }
        return resultado;
    }

    // FUNCTION
    // Método que devuelve la última letra de una cadena
    public static Character ejemplo4(String arg) {
        char ultimaLetra = arg.charAt(arg.length() - 1);
        LOG.info("Ejemplo de Function - Última letra de la cadena: " + ultimaLetra);
        return ultimaLetra;
    }

    // UnaryOperator
    // Método que devuelve el número incrementado en 1
    public static Integer ejemplo5(Integer num) {
        int incrementado = num + 1;
        LOG.info("Ejemplo de UnaryOperator - Número incrementado: " + incrementado);
        return incrementado;
    }

	
	
	
}
