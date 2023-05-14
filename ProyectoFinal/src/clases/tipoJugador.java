package clases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/**
 * 
 * @author Gema García Carballo
 *
 */
public abstract class TipoJugador {
	private String nombre;
	private int puntosHistorico;
	private int puntosRondas; 
	public TipoJugador() {
		
	}
	public TipoJugador(String jugador) {
		this.nombre = jugador;
		this.puntosHistorico = 0;
//		GestionUsuario.añadirJugador(new Jugador(jugador));
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosHistorico() {
		return puntosHistorico;
	}
	public void setPuntosHistorico(int puntosHistorico) {
		this.puntosHistorico = puntosHistorico;
	}
	public int getPuntosRondas() {
		return puntosRondas;
	}
	public void setPuntosRondas(int puntosPartida) {
		this.puntosRondas = puntosPartida;
	}
	@Override
	public String toString() {
		return "TipoJugador [nombre=" + nombre + ", puntos=" + puntosHistorico + "]";
	}
//	public static abstract String responderPregunta(TipoPregunta pregunta);
//	public static abstract String responderPregunta();

	
	
}
