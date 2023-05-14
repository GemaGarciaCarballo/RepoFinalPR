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
		generarPregunta();
	}
	public char[] generarPregunta() {
		File fichero = new File ("src/juego/diccionario.txt");
		Scanner leer;
		char[] palabraPorPartes = null;
		try {
			leer = new Scanner (fichero);
			int lineasFichero = 0;
			while (leer.hasNextLine()) {
				lineasFichero++;
			}
			leer.close();
			ArrayList<String> palabras = new ArrayList<String>();
			int indiceAleatorio = generarAleatorio(lineasFichero);
			leer = new Scanner (fichero);
			while (leer.hasNextLine()) {
				palabras.add(leer.next());
			}
			String pregunta = palabras.get(indiceAleatorio); //meto en pregunta la palabra aleatoria
			palabraPorPartes = pregunta.toCharArray(); //convierto la palabra en un array de letras
			int numLetrasOcultas = palabraPorPartes.length / 3;
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR AL LEER EL FICHERO"); //a dado error al leer el fichero
			e.printStackTrace();
		}
		
		//mostrarPregunta(numLetrasOcultas, palabraPorPartes);
		return palabraPorPartes;
	}
	
	public static ArrayList<Integer> mostrarPregunta(int numLetrasOcultas, char palabra[]){
		Integer aleatorio = 0;
		ArrayList<Integer> aleatorioArray = new ArrayList<Integer>();//guardo todas las posiciones ocultas en un array
		while (numLetrasOcultas > 0) {
			int longitud = palabra.length;
			int i = 0;
			boolean error = false;
			aleatorio = generarAleatorio(longitud);
			if (aleatorio == palabra[i]) {
				if (palabra[i]==('_')) {
					aleatorio = generarAleatorio(longitud);
					aleatorioArray.add(aleatorio);
					error = true;
				}else {
					System.out.println("_");
					aleatorioArray.add(aleatorio);
				}
			} else {
				System.out.println(palabra[i]);
			}
			if(!error) {
				longitud--;
				numLetrasOcultas--;
			}
		}
		return aleatorioArray;
	}
	public static Map <String, Character> guardarRespuestaCorrecta(int numLetrasOcultas, char[]palabra,ArrayList<Integer> posicionesOcultas){
		Map <String, Character> palabraYletras = new HashMap<String, Character>();
		while (numLetrasOcultas > 0) {
			int longitud = palabra.length;
			int i = 0;
			boolean error = false;
			for (int j = 0; j < longitud; j++) {
				if (j == posicionesOcultas.get(i)) {
					palabraYletras.put("oculta"+j, palabra[i]);
				} else {
					palabraYletras.put("visible", palabra[i]);
				}
			}
		}
		respuestasCorrectas.putAll(palabraYletras);
		return palabraYletras;
		
	}
//	public static Set <String> guardarRespuestaCorrecta (Map <String, Character>palabraYletras) {
//		Set<String> respuestasCorrectas =
//		for (int i = 0; i < palabraYletras.size(); i++) {
//			if (palabraYletras.containsKey("oculta"+i)) {
//				
//			}
//		}
//		return respuestasCorrectas;
//	}
	

}
