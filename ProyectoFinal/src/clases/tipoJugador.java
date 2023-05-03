package clases;

import java.util.Scanner;

public abstract class TipoJugador {
	private String nombre;
	private int puntos;
	
	public TipoJugador(String nombre) {
		this.nombre = nombre;
		this.puntos = 0;
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
	
	
}
