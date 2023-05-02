package clases;

import java.util.Scanner;

public abstract class TipoJugador {
	private String nombre;
	private int puntos;
	
	public TipoJugador() {
		
	}
	public TipoJugador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "TipoJugador [nombre=" + nombre + ", puntos=" + puntos + "]";
	}
	public abstract String responderPregunta(TipoPregunta pregunta);
	public void menuJugadores() {
		Scanner leer = new Scanner(System.in);
		int numJugadores = 0;
		System.out.println("¿Cuántos jugadores van a jugar?");
		numJugadores = leer.nextInt();
		//falta codigo
	}
	
}
