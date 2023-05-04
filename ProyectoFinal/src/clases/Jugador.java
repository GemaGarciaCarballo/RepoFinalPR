package clases;

import java.util.Scanner;

public class Jugador extends TipoJugador {

	public Jugador(String nombre) {
		super(nombre);
	}

	@Override
	public String responderPregunta(TipoPregunta pregunta) {// la pregunta no sirve para na
		Scanner leer = new Scanner (System.in);
		String respuesta = "";
		respuesta = leer.next();
		return respuesta;
	}

}
