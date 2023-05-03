package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PreguntaLengua extends TipoPregunta {

	public void PreguntaLengua() throws FileNotFoundException{
		generarPregunta();
	}
	public void generarPregunta() throws FileNotFoundException{
		File fichero = new File ("src/clases/juego/diccionario.txt");
		Scanner leer = new Scanner (fichero);
		int lineasFichero = 0;
		while (leer.hasNextLine()) {
			lineasFichero++;
		}
		leer.close();
		ArrayList<String> palabras = new ArrayList<String>();
		int indiceAleatorio = generarAleatorio(lineasFichero);
		String pregunta = palabras.get(indiceAleatorio); //meto en pregunta la palabra aleatoria
		char palabraPorPartes[] = pregunta.toCharArray(); //convierto la palabra en un array de letras
		int numLetrasOcultas = palabraPorPartes.length / 3;
		
		mostrarPregunta(numLetrasOcultas, palabraPorPartes);
	}
	
	public Set<String> mostrarPregunta(int numLetrasOcultas, char palabra[]){
		Set<String> letrasOcultas = new HashSet<String>();
		while (numLetrasOcultas > 0) {
			int longitud = palabra.length;
			int i = 0;
			int aleatorio = generarAleatorio(longitud);
			if (aleatorio == palabra[i]) {
				System.out.println("_");
				letrasOcultas.add(String.valueOf(palabra[i]));
			} else {
				System.out.println(palabra[i]);
			}
			longitud--;
			numLetrasOcultas--;
		}
		return letrasOcultas;
	}
	

}
