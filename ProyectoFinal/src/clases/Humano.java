package clases;

import java.util.Scanner;

public class Humano extends TipoJugador {

	public Humano(String nombre) {
		super(nombre);
		
	}

	@Override
	public String responderPregunta(TipoPregunta pregunta) {
		Scanner leer = new Scanner (System.in);
		
		return null;
	}

}
