package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class PreguntaLengua extends TipoPregunta {
	private static Map <String, Character> respuestasCorrectas;
	
	public void PreguntaLengua(){
		this.respuestasCorrectas = new HashMap<String, Character>();
//		int lineasFichero = leerFichero();
//		System.out.println(lineasFichero);
		//generarPregunta(lineasFichero);
	}
	public int leerFichero(){
		File fichero = new File ("src/juego/diccionario.txt");
		Scanner leer;
		int lineasFichero = 0;
		try {
			leer = new Scanner (fichero);
			while (leer.hasNextLine()) {
				leer.next();
				lineasFichero++;
			}
			leer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		return lineasFichero;
	}
	public char[] generarPregunta(int lineasFichero) {
		File fichero = new File ("src/juego/diccionario.txt");
		Scanner leer;
		char[] palabraPorPartes = null;
		try {
			ArrayList<String> palabras = new ArrayList<String>();
			int indiceAleatorio = generarAleatorio(lineasFichero);
			System.out.println(indiceAleatorio);
			leer = new Scanner (fichero);
			while (leer.hasNextLine()) {
				palabras.add(leer.next());
			}
			String pregunta = palabras.get(indiceAleatorio); //meto en pregunta la palabra aleatoria
			boolean palabraInvalida = true;
			while (palabraInvalida) {
				if (pregunta.length() < 3) {
					indiceAleatorio = generarAleatorio(lineasFichero);
					pregunta = palabras.get(indiceAleatorio);
				}else {
					palabraInvalida = false;
				}
			}
			palabraPorPartes = pregunta.toCharArray(); //convierto la palabra en un array de letras
			int numLetrasOcultas = palabraPorPartes.length / 3;
			leer.close();
			System.out.println(palabraPorPartes);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR AL LEER EL FICHERO");
			e.printStackTrace();
		}
		
		//mostrarPregunta(numLetrasOcultas, palabraPorPartes);
		return palabraPorPartes;
	}
	
	public static ArrayList<Integer> mostrarPregunta(int numLetrasOcultas, char palabra[]){
		Integer aleatorio = 0;
		//guardo todas las posiciones ocultas en un array
		
		ArrayList<Integer> aleatorioArray = new ArrayList<Integer>();
		boolean letraEncontrada = false;
		int longitud = palabra.length;
		while (numLetrasOcultas > 0) {
			int i = 0;
			aleatorio = generarAleatorio(longitud);
			while(i < longitud) {
				boolean error = false;
				if (aleatorio == i) {
					if (palabra[i]==('_')) {
						if (aleatorio == longitud) {
							aleatorio = i-1; 
							i++;
						}else {
							aleatorio = i+1;
							i++;
						}
						palabra[aleatorio]=('_');
						aleatorioArray.add(aleatorio);
						error = true;
						i++;
					}else {
						palabra[i]=('_');
						aleatorioArray.add(aleatorio);
						i++;
					}
				} else {
					i++;
				}
			}
			numLetrasOcultas--;
		}
		for(int j = 0; j < longitud; j++) {
			System.out.print(palabra[j]);
		}
		return aleatorioArray;
	}
//	public static Map <String, Character> guardarRespuestaCorrecta(int numLetrasOcultas, char[]palabra,ArrayList<Integer> posicionesOcultas){
//		Map <String, Character> palabraYletras = new HashMap<String, Character>();
//		int i = 0;
//		while (numLetrasOcultas > 0) {
//			int longitud = palabra.length;
//			boolean error = false;
//			for (int j = 0; j < longitud; j++) {
//				if (j == posicionesOcultas.get(i)) {
//					palabraYletras.put("oculta"+j, palabra[i]);
//				} else {
//					palabraYletras.put("visible"+j, palabra[i]);
//				}
//			}
//			i++;
//			numLetrasOcultas--;
//		}
//		respuestasCorrectas.putAll(palabraYletras);
//		return palabraYletras;
//		
//	}
	
	public static ArrayList <String> guardarRespuestaCorrecta (char[] palabra, ArrayList<Integer> aleatorio) {
		ArrayList<String> respuestasCorrectas = new ArrayList <String>();
		for (int i = 0; i < aleatorio.size(); i++) {
			//respuestasCorrectas.add(palabra[aleatorio.get(i)]);
			respuestasCorrectas.add(Character.toString(palabra[aleatorio.get(i)]));
		}
		return respuestasCorrectas;
	}
	

}
