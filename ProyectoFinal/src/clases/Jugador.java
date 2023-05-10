package clases;

import java.util.Scanner;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class Jugador extends TipoJugador {
	private int puntosRanking;
	public Jugador(String nombre) {
		super(nombre);
	}

	
	public static String responderPregunta() {
		Scanner leer = new Scanner (System.in);
		String respuesta = "";
		respuesta = leer.next();
		return respuesta;
	}


	public int getPuntosRanking() {
		return puntosRanking;
	}


	public void setPuntosRanking(int puntosRanking) {
		this.puntosRanking = puntosRanking;
	}



}
