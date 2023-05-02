package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PreguntaIngles extends TipoPregunta {
//TO DO: //ENCONTRAR PREGUNTA LOCALIZADA EN LA LINEA ALEATORIA 
	// METER LA PREGUNTA Y LAS RESPUESTAS EN ALGO Y PINTARLO
	
	public int generarPregunta() throws FileNotFoundException {
		File archivo = new File ("src/juego/ingles");
		Scanner leer = new Scanner (archivo);
		int lineasFichero = 0;
		int aleatorio = generarAleatorio(lineasFichero-5);
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
		Set<String> preguntaYrespuestas = new LinkedHashSet<String>();
		//ENCONTRAR PREGUNTA LOCALIZADA EN LA LINEA ALEATORIA 
		return aleatorio;
	}
	
	public void mostrarPregunta(int numeroPregunta) throws FileNotFoundException {
		File archivo = new File ("src/juego/ingles");
		Scanner leer = new Scanner (archivo);
		int cont = 0;
		String respuestaCorrecta = "";
		Set<String> respuestas = new LinkedHashSet<String>();
		System.out.println(leer.next());
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				respuestaCorrecta = leer.next();
			}
			respuestas.add(leer.next()); // meto las respuestas en un SET
		}
		Iterator it = respuestas.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		leer.close();
	}
	public boolean comprobarPregunta(int numeroPregunta) throws FileNotFoundException{
		File archivo = new File ("src/juego/ingles");
		Scanner leer = new Scanner (archivo);
		
		return true;
	}

}
