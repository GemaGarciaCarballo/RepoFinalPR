package clases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public abstract class TipoJugador {
	private String nombre;
	private int puntos;
	//private static Set <Jugador> jugadoresSistema;
	
	public TipoJugador() {
		
	}
	public TipoJugador(String jugador) {
		this.nombre = jugador;
		this.puntos = 0;
		GestionUsuario.añadirUsuarioSistema(jugador);
//		jugadoresSistema = new HashSet<Jugador>();
//		jugadoresSistema.add(jugador,0);
	}
	
//	public static Set<Jugador> getJugadoresSistema() {
//		return jugadoresSistema;
//	}
//	public static void setJugadoresSistema(Set<Jugador> jugadoresSistema) {
//		TipoJugador.jugadoresSistema = jugadoresSistema;
//	}
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
