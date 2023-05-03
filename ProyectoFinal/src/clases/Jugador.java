package clases;

import java.util.Scanner;

public class Jugador extends TipoJugador {

	public Jugador(String nombre) {
		super(nombre);
	}

	@Override
	public String responderPregunta(TipoPregunta pregunta) {
		Scanner leer = new Scanner (System.in);
		String respuesta = "";
		respuesta = leer.next();
		return respuesta;
	}

}
