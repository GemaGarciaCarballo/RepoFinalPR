package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PreguntaIngles extends TipoPregunta {
	
	public void PreguntaInges()throws FileNotFoundException {
		generarPregunta();
	}
	public void generarPregunta() throws FileNotFoundException {
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
		rellenarPreguntaYrespuestas(aleatorio,lineasFichero);
	}
	
	public String rellenarPreguntaYrespuestas(int aleatorio, int lineasFichero) throws FileNotFoundException{
		File archivo = new File ("src/juego/ingles");
		Scanner leer = new Scanner (archivo);
		ArrayList<String> respuestas = new ArrayList<String>();
		String pregunta = "";
		String respuestaCorrecta = "";
		//ENCONTRAR PREGUNTA LOCALIZADA EN LA LINEA ALEATORIA Y METERLA EN PREGUNTA Y LAS RESPUESTAS EN UN LINKEDHASHSET
		int i = 0;
		boolean relleno = false;
		while ((i < lineasFichero) && (!relleno)) {
			if (i == aleatorio) {
				pregunta = leer.next();
			} else if ((i > aleatorio) && (respuestas.size() < 4)) {
				respuestas.add(leer.next());
			}
			if (respuestas.size() == 4) {
				relleno = true;
				respuestaCorrecta = respuestas.get(0);
			}
			i++;
		}
		mostrarPregunta(pregunta, respuestas);
		return respuestaCorrecta;
	}
	
	public void mostrarPregunta(String pregunta, ArrayList respuestas) {
		int cont = 0;
		System.out.println(pregunta);
		int aleatorio = generarAleatorio(respuestas.size());
		while (respuestas.size() > 0) {
			System.out.println(respuestas.get(aleatorio));
			respuestas.remove(aleatorio);
			aleatorio--;
		}
	}
	


}
