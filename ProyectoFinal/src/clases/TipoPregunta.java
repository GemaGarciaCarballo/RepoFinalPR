package clases;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class TipoPregunta {
	private int tipo;

	
	//public abstract void mostrarPregunta() throws FileNotFoundException;
	public static int generarAleatorio(int tope) {
		int aleatorio = (int) (Math.random()*(tope-1)+1);
		return aleatorio;
	}
	public static int generarAleatorio(int tope, int min) {
		int aleatorio = (int) (Math.random() * (tope + 1 - min)) + min;
		return aleatorio;
	}
	public static boolean comprobarPregunta(String respuesta, String respuestaCorrecta) {
		if (respuesta.equalsIgnoreCase(respuestaCorrecta)) {
			return true;
		} else {
			return false;
		}
	}
//	public static boolean comprobarPregunta(String respuesta, Set<String> respuestasCorrectas) {
//		Set<String> respuestasCorrectasAux = new HashSet<String>();
//		respuestasCorrectasAux.addAll(respuestasCorrectas);
//		boolean acierto = false;
//		for (int i = 0; i < respuestasCorrectasAux.size(); i++) {
//			if (respuestasCorrectasAux.contains(respuesta)) {
//				acierto = true;
//			} else {
//				acierto = false;
//			}	
//		}
//		return acierto;
//	}
	public static boolean comprobarPregunta(String respuesta, Map<String,Character> respuestasCorrectas) {
		boolean acierto = false;
		int i = 0;
		while ((!acierto) && (i < respuestasCorrectas.size())){
			String clave = "oculta"+i;
			if (respuesta.equals(respuestasCorrectas.get(clave).toString())) {
				acierto = true;
			}
			i++;
		}
		return acierto;
	}
	

}
