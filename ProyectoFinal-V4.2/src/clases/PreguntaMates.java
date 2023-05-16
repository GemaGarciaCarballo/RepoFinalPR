package clases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class PreguntaMates extends TipoPregunta {
	private static int respuestaCorrecta;

	public void PreguntaMates(){
		generarPregunta();
	}
	public String generarPregunta() {
		String pregunta = "";
		int cont = 0;
		Set<String> signos = new HashSet<String>();
		signos.add(" + ");
		signos.add(" - ");
		signos.add(" * ");
		Iterator it = signos.iterator();
		int longitudPregunta = generarAleatorio(8,4);
		while (cont < longitudPregunta) {
			pregunta +=  generarAleatorio(12,2);
			if (cont != longitudPregunta-1) {
				if (cont == 3 || cont == 6){
					it = signos.iterator();
					pregunta += it.next();
				}else {
					pregunta += it.next();
				}
			}
			cont++;
		}
		return pregunta;
		//mostrarPregunta(pregunta);
	}
	public static void mostrarPregunta(String pregunta) {
		System.out.println(pregunta);
	}
	public static int guardarRespuestaCorrecta (String pregunta) {//guardar la respuesta correcta en una variable
		//SI VALUEOF NO FUNCIONA CON CHAR:
		    //result += String.valueOf(pregunta.substring(cont)) + valueOf(pregunta.substring(cont+2));
		String preguntaAux = pregunta;
		int cont = 0;
		int resul = 0;
		char[] arrayPregunta = pregunta.toCharArray();
		while (cont < preguntaAux.length()){
		    //int anterior = valueOf(arrayPregunta[cont]);
		    if (arrayPregunta[cont+1] == '*'){
		        if (arrayPregunta[cont-1] == '+'){
		            resul += Character.valueOf(arrayPregunta[cont]) * Character.valueOf(arrayPregunta[cont+2]);
		            arrayPregunta[cont] = '0';
		            arrayPregunta[cont+2] = '0';
		        }else {
		            resul -= Character.valueOf(arrayPregunta[cont]) * Character.valueOf(arrayPregunta[cont+2]);
		            arrayPregunta[cont] = '0';
		            arrayPregunta[cont+2] = '0';
		        }
		    }
		    cont += 2;
		}
		cont = 0;
		while (cont < preguntaAux.length()){
		   if (arrayPregunta[cont] != '0') {
				if (arrayPregunta[cont+1] == '+'){
			        resul += Character.valueOf(arrayPregunta[cont]) + Character.valueOf(arrayPregunta[cont+2]);
			    }else if (arrayPregunta[cont+1] == '-'){
			        resul -= Character.valueOf(arrayPregunta[cont]) - Character.valueOf(arrayPregunta[cont+2]);
			    }
		   }
		    cont += 2;
		}
		respuestaCorrecta = resul;
		return respuestaCorrecta;
	}
	
}
