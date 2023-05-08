package clases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public abstract class TipoJugador {
	private String nombre;
	private int puntosHistorico;
	
	public TipoJugador() {
		
	}
	public TipoJugador(String jugador) {
		this.nombre = jugador;
		this.puntosHistorico = 0;
		GestionUsuario.añadirJugador(new Jugador(jugador));
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getpuntosHistorico() {
		return puntosHistorico;
	}

	public void setpuntosHistorico(int puntos) {
		this.puntosHistorico = puntos;
	}

	@Override
	public String toString() {
		return "TipoJugador [nombre=" + nombre + ", puntos=" + puntosHistorico + "]";
	}
//	public static abstract String responderPregunta(TipoPregunta pregunta);
//	public static abstract String responderPregunta();

	
	
}
