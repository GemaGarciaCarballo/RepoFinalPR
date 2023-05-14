package juego;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import clases.*;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class Principal {
	public static void main(String[] args) throws FileNotFoundException {
		Partida a = new Partida();
		a.menuPrincipal();
		
//		TipoPregunta l = new PreguntaLengua();
//		int lineas = ((PreguntaLengua) l).leerFichero();
//		
//		char pregunta[] = ((PreguntaLengua) l).generarPregunta(lineas);
//		((PreguntaLengua) l).mostrarPregunta(pregunta.length/3,pregunta);
		
//		TipoPregunta i = new PreguntaIngles();
//		int lineas = ((PreguntaIngles) i).leerFichero();
//		String pregunta = ((PreguntaIngles)i).generarPregunta(lineas);
//		System.out.println(pregunta);
	}
}
