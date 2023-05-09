package clases;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.script.ScriptException;

public class Partida {
	private Set<TipoJugador> jugadoresPartida;
	private int rondas;

	public Partida(Set<TipoJugador> jugadores) {
		this.jugadoresPartida = new HashSet<TipoJugador>();
		this.jugadoresPartida.add((TipoJugador) jugadores);//añadiria los jugadores
	}
	
	public void menuPrincipal() throws FileNotFoundException, ScriptException {
		Scanner leer = new Scanner (System.in);
		int respuesta = 0;
		System.out.println("***********************");
		System.out.println("BIENVENIDO, ELIGE UNA OPCIÓN: \n 1) JUGAR PARTIDA \n 2) RANKING \n 3) HISTORICO \n 4)JUGADORES \n 5) SALIR");
		respuesta = leer.nextInt();
		switch (respuesta) {
		case 1: 
			pantallaSeleccionJugadores();
			int rondas = seleccionRondas();
			ArrayList<TipoJugador> orden = new ArrayList<TipoJugador>();
			orden = generarOrdenAleatorio();
			jugar(rondas, orden);
			break;
		case 2:
			GestionPuntos.ranking();
			break;
		case 3:
			GestionPuntos.historico();
			break;
		case 4:
			menuJugadores();
			break;
		case 5: 
			System.out.println("GRACIAS POR JUGAR, HASTA PRONTO");
			break;
		default:
			System.err.println("DEBE ELEGIR UNA OPCIÓN DE LAS 5 DISPONIBLES");
		}
	}
	public void menuJugadores() {
		Scanner leer = new Scanner (System.in);
		int respuesta = 0;System.out.println("***********************");
		System.out.println("OPCIONES DE JUGADORES: \n 1) VER JUGADORES \n 2) AÑADIR JUGADOR \n 3) ELIMINAR JUGADOR \n 4) VOLVER");
		respuesta = leer.nextInt();
		switch (respuesta) {
			case 1: 
				GestionUsuario.verJugadores();
				break;
			case 2:
				System.out.println("¿CUÁL ES EL NOMBRE DEL JUGADOR QUE DESEA AÑADIR?");
				GestionUsuario.añadirJugador(new Jugador(leer.next()));
				break;
			case 3:
				System.out.println("¿CUÁL ES EL NOMBRE DEL JUGADOR QUE DESEA ELIMINAR?");
				String jugador = leer.next();
				GestionUsuario.eliminarJugador(jugador);
				break;
			case 4:
				menuPrincipal();//controlar exceptoins con try y catch
				break;
			default: 
				System.err.println("DEBE ELEGIR UNA DE LAS 4 OPCIONES DISPONIBLES");
		}
	}

	public void pantallaSeleccionJugadores() {
		Scanner leer = new Scanner (System.in);
		int numJugadores = 0;
		boolean exito = false;
		System.out.println("BIENVENIDO A LA PARTIDA");
		System.out.println("¿CUÁNTOS JUGADORES VAN A JUGAR?");
		numJugadores = leer.nextInt();
		while((numJugadores > 0) && (!exito)) {
			System.out.println("¿DE QUÉ TIPO ES EL JUGADOR: JUGADOR O MÁQUINA?");
			String tipo = leer.next();
			if (tipo.equalsIgnoreCase("JUGADOR")) {
				System.out.println("ESCRIBA EL NOMBRE DEL JUGADOR SIN ESPACIOS");
				String nombre = leer.next();
				if (GestionUsuario.getJugadoresSistema().contains(nombre)) {
					jugadoresPartida.add(new Jugador (nombre));
				} else {
					System.out.println("ESTE JUGADOR NO FIGURA EN EL SISTEMA ¿DESEA DARLO DE ALTA?");
					if (leer.next().equalsIgnoreCase("SI")) {
						((GestionUsuario) GestionUsuario.getJugadoresSistema()).añadirJugador(new Jugador(nombre));
						exito = true;
					} else {
						exito = false;
						System.err.println("ERROR");
					}
				}
			}else if (tipo.equalsIgnoreCase("MAQUINA")) {
				jugadoresPartida.add(new CPU());
			} else {
				System.err.println("ERROR, LOS JUGADORES DEBEN SER JUGADORES O MÁQUINAS");
			}
		}
	}
	public int seleccionRondas() {
		Scanner leer = new Scanner (System.in);
		int numRondas = 0;
		System.out.println("¿QUÉ TIPO DE PARTIDA QUIERE JUGAR? RÁPIDA, CORTA, NORMAL O LARGA");
		String tipoPartida = leer.next();
		boolean error = false;
		do {
			error = false;
			switch (tipoPartida.toUpperCase()) {
			case "RAPIDA":
				numRondas = 3;
				break;
			case "CORTA":
				numRondas = 5;
				break;
			case "NORMAL":
				numRondas = 10;
				break;
			case "LARGA":
				numRondas = 20;
				break;
				default:
					System.out.println("EL TIPO DE PARTIDA DEBE SER UNA DE LAS CUATRO OPCIONES");
					error = true;
			}
		} while (error);
		
		return numRondas;
	}
	public ArrayList<TipoJugador> generarOrdenAleatorio() {
		ArrayList<TipoJugador> jugadoresOrdenados = new ArrayList<TipoJugador>();
		Set<TipoJugador> jugadoresPartidaAux = new HashSet<TipoJugador>();
		jugadoresPartidaAux.addAll(jugadoresPartida);
		Iterator it = jugadoresPartidaAux.iterator();
		while (it.hasNext()) {
			jugadoresOrdenados.add((TipoJugador) it.next());
			it.remove();
		}
		return jugadoresOrdenados;
	}
	public void jugar(int rondas, ArrayList<TipoJugador> orden) throws ScriptException, FileNotFoundException {
		int cont = 0;
		while (cont < rondas) {
			System.out.println("RONDA NÚMERO "+ cont+1 + ":");
			System.out.println("JUGADOR "+ cont+1 + "RESPONDE A LA PREGUNTA:");
			boolean respuestaCorrecta = false;
			int indicePreguntaAleatoria = TipoPregunta.generarAleatorio(3);
			if (orden.get(cont) instanceof CPU) {
				if (indicePreguntaAleatoria < 3) {
					((CPU) orden.get(cont)).responderPregunta(indicePreguntaAleatoria);
				}else {
					String respuesta =  ((CPU) orden.get(cont)).responderPregunta(PreguntaIngles.todasRespuestas);
					respuestaCorrecta = PreguntaIngles.comprobarPregunta(respuesta, PreguntaIngles.respuestaCorrecta);
					if (respuestaCorrecta) {
						orden.get(cont).setPuntosHistorico(orden.get(cont).getPuntosHistorico()+1);
						((CPU) orden.get(cont)).setPuntosRondas(orden.get(cont).getPuntosHistorico());

						System.out.println("HAS ACERTADO");
					}else {
						System.out.println("HAS FALLADO");
					}
				}
			}else {
				switch (indicePreguntaAleatoria) {
				case 1:
					String preguntaM = generarPreguntas(indicePreguntaAleatoria);
					PreguntaMates.mostrarPregunta(preguntaM);
					String respuestaJugadorM = ((Jugador) orden.get(cont)).responderPregunta();
					String respuestaRealM = PreguntaMates.guardarRespuestaCorrecta(preguntaM);
					respuestaCorrecta = PreguntaMates.comprobarPregunta(respuestaJugadorM,respuestaRealM);
					break;
				case 2:
					char[] preguntaL = generarPreguntas(indicePreguntaAleatoria).toCharArray();
					ArrayList<Integer> posicionesAleatorias = new ArrayList<Integer>();
					posicionesAleatorias = PreguntaLengua.mostrarPregunta(preguntaL.length/3,preguntaL);
					String respuestaJugadorL = ((Jugador) orden.get(cont)).responderPregunta();
					Map <String, Character> respuestaRealL = new HashMap<String, Character>();
					respuestaRealL = PreguntaLengua.guardarRespuestaCorrecta(preguntaL.length/3,preguntaL,posicionesAleatorias);
					respuestaCorrecta = PreguntaLengua.comprobarPregunta(respuestaJugadorL,respuestaRealL);
					break;
				case 3:
					String preguntaI = generarPreguntas(indicePreguntaAleatoria);
					PreguntaIngles.mostrarPregunta(preguntaI, PreguntaIngles.todasRespuestas);
					String respuestaJugadorI = ((Jugador) orden.get(cont)).responderPregunta();
					respuestaCorrecta = PreguntaIngles.comprobarPregunta(respuestaJugadorI, PreguntaIngles.respuestaCorrecta);
					break;
				}
				if (respuestaCorrecta) {
					orden.get(cont).setPuntosHistorico(orden.get(cont).getPuntosHistorico()+1);
					((Jugador) orden.get(cont)).setPuntosRondas(orden.get(cont).getPuntosHistorico());
					System.out.println("HAS ACERTADO");
				}else {
					System.out.println("HAS FALLADO");
				}
			}
			
			puntuacionRonda(cont,orden);
			cont++;
		}
		mostrarpuntuacionFinal(orden);
		guardarPuntuacionFinal(orden);
		GestionPuntos.historico();
		GestionPuntos.ranking();
	}
	public String generarPreguntas(int num) throws FileNotFoundException {
		TipoPregunta pregunta = null;
		String enunciado = "";
		switch (num) {
		case 1:
			pregunta = new PreguntaMates();
			enunciado = ((PreguntaMates)pregunta).generarPregunta();
			break;
		case 2:
			pregunta = new PreguntaLengua();
			enunciado = Arrays.toString(((PreguntaLengua) pregunta).generarPregunta());
			break;
		case 3:
			pregunta = new PreguntaIngles();
			enunciado = ((PreguntaIngles)pregunta).generarPregunta();
			break;
				
		}
		return enunciado;
	}
	public void puntuacionRonda (int numRonda,ArrayList<TipoJugador> orden) {
		System.out.println("PUNTOS DE LA RONDA "+ numRonda + ":");
		for (int i = 0; i < orden.size(); i++) {
			System.out.println((orden.get(i)).getNombre() + ": ");
			System.out.print((orden.get(i)).getPuntosRondas());
		}
		
	}
	
	public void mostrarpuntuacionFinal (ArrayList<TipoJugador> orden) {
		System.out.println("PUNTUACIÓN FINAL:");
		for (int i = 0; i < orden.size(); i++) {
			System.out.println((orden.get(i)).getNombre() + ": ");
			System.out.println((orden.get(i)).getPuntosRondas());
		}
	}
	
	public void guardarPuntuacionFinal (ArrayList<TipoJugador> orden) {
		Map<String,Integer> historicoAux = new HashMap <String,Integer>();
		for (int i = 0; i < orden.size(); i++) {
			historicoAux.put(orden.get(i).getNombre(), orden.get(i).getPuntosHistorico());
		}
		GestionPuntos.setHistorico(historicoAux);
	}
}
