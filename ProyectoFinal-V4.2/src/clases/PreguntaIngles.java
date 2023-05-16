package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class PreguntaIngles extends TipoPregunta {
	protected static String respuestaCorrecta;
	protected static Set<String> todasRespuestas = new HashSet<String>();;
	
	public void PreguntaIngles() {
		//generarPregunta();
	}
	public int leerFichero() {
		File fichero = new File ("src/juego/ingles.txt");
		Scanner leer;
		int lineasFichero = 0;
		try {
			leer = new Scanner (fichero);
			while (leer.hasNextLine()) {
				leer.nextLine();
				lineasFichero++;
			}
			leer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		return lineasFichero;
	}
	public String generarPregunta(int lineasFichero)  {
		String pregunta = "";
		File archivo = new File ("src/juego/ingles.txt");
		Scanner leer;
		try {
			leer = new Scanner (archivo);
			Integer linea = 1;
			int tope = (lineasFichero/5)-1;
			Integer indiceAleatorio = generarAleatorio(1,tope);
			if (indiceAleatorio != 1) {
				for (int i = 0; i < indiceAleatorio; i++) {
					linea += 5;
				}
				indiceAleatorio = linea;
			}
			pregunta = rellenarPreguntaYrespuestas(indiceAleatorio,lineasFichero);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR AL LEER EL FICHERO");
			e.printStackTrace();
		}
		return pregunta;
	}
	
	public String rellenarPreguntaYrespuestas(Integer aleatorio, int lineasFichero) {
		File archivo = new File ("src/juego/ingles.txt");
		Scanner leer;
		String pregunta = "";
		try {
			leer = new Scanner (archivo);
			ArrayList<String> respuestas = new ArrayList<String>();
			//ENCONTRAR PREGUNTA LOCALIZADA EN LA LINEA ALEATORIA Y METERLA EN PREGUNTA Y LAS RESPUESTAS EN UN LINKEDHASHSET
			int i = 1;
			boolean respuestaCorrectaRellena = false;
			while (todasRespuestas.size() < 4) {
				if (i == aleatorio) {
					pregunta = leer.nextLine();
					i += 1;
				} else if ((i > aleatorio) && (respuestas.size() < 5)) {
					if (i == (aleatorio+1)) {
						respuestaCorrecta = leer.nextLine(); //guardo la respuesta correcta
						todasRespuestas.add(respuestaCorrecta);
//						i -=1;
					} else {
						todasRespuestas.add(leer.nextLine());//guardo todas las respuestas
					}
					i += 1;
				}else {
					for(int j = 0; j < 5; j++) {
						leer.nextLine();
					}
					i += 5;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR AL LEER EL FICHERO");
			e.printStackTrace();
		}
		return pregunta;
		
	}
	
	public static void mostrarPregunta(String pregunta, Set<String> respuestas) {
		System.out.println(pregunta);
		Iterator it = todasRespuestas.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
	}
	public static String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	public static void setRespuestaCorrecta(String respuestaCorrecta) {
		PreguntaIngles.respuestaCorrecta = respuestaCorrecta;
	}
	public static Set<String> getTodasRespuestas() {
		return todasRespuestas;
	}
	public static void setTodasRespuestas(Set<String> todasRespuestas) {
		PreguntaIngles.todasRespuestas = todasRespuestas;
	}
	


}
