package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PreguntaIngles extends TipoPregunta {
	protected static String respuestaCorrecta;
	protected static Set<String> todasRespuestas;
	
	public void PreguntaIngles() {
		todasRespuestas = new HashSet<String>();
		generarPregunta();
	}
	public String generarPregunta()  {
		String pregunta = "";
		File archivo = new File ("src/juego/ingles");
		Scanner leer;
		try {
			leer = new Scanner (archivo);
			int lineasFichero = 0;
			Integer aleatorio = generarAleatorio(lineasFichero-5);
			boolean preguntaEncontrada = false;
			while (leer.hasNext()) {
				leer.next();
				lineasFichero++;
			}
			leer.close();
			do {
				if ((aleatorio != 0) || (aleatorio != lineasFichero-5) || (aleatorio % 5 == 0)) {
					aleatorio += 1;
				} else {
					preguntaEncontrada = true;
				}	
			} while (!preguntaEncontrada);
			pregunta = rellenarPreguntaYrespuestas(aleatorio,lineasFichero);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR AL LEER EL FICHERO");
			e.printStackTrace();
		}
		return pregunta;
	}
	
	public String rellenarPreguntaYrespuestas(Integer aleatorio, int lineasFichero) {
		File archivo = new File ("src/juego/ingles");
		Scanner leer;
		String pregunta = "";
		try {
			leer = new Scanner (archivo);
			ArrayList<String> preguntaYrespuestas = new ArrayList<String>();
			//String respuestaCorrecta = "";
			//ENCONTRAR PREGUNTA LOCALIZADA EN LA LINEA ALEATORIA Y METERLA EN PREGUNTA Y LAS RESPUESTAS EN UN LINKEDHASHSET
			int i = 0;
			boolean relleno = false;
			while ((i < lineasFichero) && (!relleno)) {
				if (i == aleatorio) {
					pregunta = leer.next();
				} else if ((i > aleatorio) && (preguntaYrespuestas.size() < 6)) {
					preguntaYrespuestas.add(leer.next());
					todasRespuestas.add(preguntaYrespuestas.get(i));
				}
				if (preguntaYrespuestas.size() == 6) {
					relleno = true;
					respuestaCorrecta = preguntaYrespuestas.get(2);//GUARDO LA RESPUESTA CORRECTA
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR AL LEER EL FICHERO");
			e.printStackTrace();
		}
		return pregunta;
		//mostrarPregunta(pregunta, respuestas);
		
	}
	
	public static void mostrarPregunta(String pregunta, Set<String> respuestas) {
		System.out.println(pregunta);
		Iterator it = todasRespuestas.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
	}
	


}
