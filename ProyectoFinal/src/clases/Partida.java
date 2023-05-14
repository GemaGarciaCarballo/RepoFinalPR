package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Gema García Carballo
 *
 */
public class Partida {
	private Set<TipoJugador> jugadoresPartida;
	private int rondas;
	private GestionUsuario gestionUsuario= new GestionUsuario();

	public Partida() {
	}

	public void menuPrincipal() {
		Scanner leer = new Scanner (System.in);
		int respuesta = 0;
		boolean error = false;
		do {
			error = false;
			System.out.println("***********************");
			System.out.println("BIENVENIDO, ELIGE UNA OPCIÓN: \n 1) JUGAR PARTIDA \n 2) RANKING \n 3) HISTORICO \n 4)JUGADORES \n 5) SALIR");
			respuesta = leer.nextInt();
			switch (respuesta) {
			case 1: 
				pantallaSeleccionJugadores();//lanza NullPointerException
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
				error = true;
			}
		}while (error);
	}
	public void menuJugadores() {
		Scanner leer = new Scanner (System.in);
		int respuesta = 0;System.out.println("***********************");
		System.out.println("OPCIONES DE JUGADORES: \n 1) VER JUGADORES \n 2) AÑADIR JUGADOR \n 3) ELIMINAR JUGADOR \n 4) VOLVER");
		respuesta = leer.nextInt();
		switch (respuesta) {
			case 1:
				gestionUsuario.verJugadores();
				break;
			case 2:
				System.out.println("¿CUÁL ES EL NOMBRE DEL JUGADOR QUE DESEA AÑADIR?");
				gestionUsuario.annadirJugador(new Jugador(leer.next()));
				break;
			case 3:
				System.out.println("¿CUÁL ES EL NOMBRE DEL JUGADOR QUE DESEA ELIMINAR?");
				String jugador = leer.next();
//				gestionUsuario.eliminarJugador(jugador);
				break;
			case 4:
				menuPrincipal();
				break;
			default: 
				System.err.println("DEBE ELEGIR UNA DE LAS 4 OPCIONES DISPONIBLES");
		}
	}
	/**
	 * Método que permite al jugador elegir el número de jugadores y el tipo (Jugador o Máquina).
	 */
	public void pantallaSeleccionJugadores() {
		Scanner leer = new Scanner (System.in);
		int numJugadores = 0;
		boolean respuestaNula = false;
		boolean elegirOtroJugador = false;
		System.out.println("BIENVENIDO A LA PARTIDA");
		System.out.println("¿CUÁNTOS JUGADORES VAN A JUGAR?");
		numJugadores = leer.nextInt();
		this.jugadoresPartida = new HashSet<TipoJugador>();
		while((numJugadores > 0)) {
			System.out.println("¿DE QUÉ TIPO ES EL JUGADOR: JUGADOR O MÁQUINA?");
			String tipo = leer.next();
			try {
				if (tipo.equalsIgnoreCase("JUGADOR")) {
					do {
						System.out.println("ESCRIBA EL NOMBRE DEL JUGADOR SIN ESPACIOS");
						String nombre = leer.next();
						elegirOtroJugador = false;
						if (gestionUsuario.existeJugador(nombre)) {
							gestionUsuario.annadirJugador(new Jugador (nombre)); // esta linea es hacer un new a partir del fichero txt
							this.jugadoresPartida.add(new Jugador (nombre));
						} else {
							do {
								respuestaNula = false;
								System.out.println("ESTE JUGADOR NO FIGURA EN EL SISTEMA ¿DESEA DARLO DE ALTA?");
								String respuesta = leer.next();
								if (respuesta.equalsIgnoreCase("SI")) {
									this.gestionUsuario.annadirJugador(new Jugador(nombre));
									this.jugadoresPartida.add(new Jugador (nombre));
								}else if (respuesta.equalsIgnoreCase("NO")){
									//System.out.println("ESCRIBA EL NOMBRE DE OTRO JUGADOR");
									elegirOtroJugador = true;
								}else{
									respuestaNula = true;
								}
							}while (respuestaNula);
						}
					}while(elegirOtroJugador);
					numJugadores--;
				}else if (tipo.equalsIgnoreCase("MAQUINA")) {
					this.jugadoresPartida.add(new CPU());
					numJugadores--;
				} else {
					System.err.println("ERROR, LOS JUGADORES DEBEN SER JUGADORES O MÁQUINAS");
				}
				
			} catch (NullPointerException e){
				e.printStackTrace();
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
	/**
	 * Método que vuelca en una lista los jugadores en una lista aleatoriamente.
	 * @return Una lista con los jugadores ordenados de manera aleatoria
	 */
	public ArrayList<TipoJugador> generarOrdenAleatorio() {
		ArrayList<TipoJugador> jugadoresOrdenados = new ArrayList<TipoJugador>();
		Set<TipoJugador> jugadoresPartidaAux = new HashSet<TipoJugador>(this.jugadoresPartida);
		Iterator<TipoJugador> it = jugadoresPartidaAux.iterator();
		while (it.hasNext()) {
			jugadoresOrdenados.add((TipoJugador) it.next());
			it.remove();
		}
		return jugadoresOrdenados;
	}
	/**
	 * Método que permite leer y contestar preguntas a los jugadores.
	 * @param rondas Número de rondas que se van a jugar.
	 * @param orden Lista de jugadores ordenados aleatoriamente.
	 */
	public void jugar(int rondas, ArrayList<TipoJugador> orden){
		int contRondas = 0;
		while (contRondas < rondas) {
			System.out.println("RONDA NÚMERO "+ (contRondas+1) + ":");
			for (int i = 0; i < orden.size(); i++) {
				System.out.println("JUGADOR "+ (i+1) + " RESPONDE A LA PREGUNTA:");
				boolean respuestaCorrecta = false;
				int indicePreguntaAleatoria = TipoPregunta.generarAleatorio(3);
				if (orden.get(i) instanceof CPU) {
					if (indicePreguntaAleatoria < 3) {
						((CPU) orden.get(i)).responderPregunta(indicePreguntaAleatoria);
					}else {
						String respuesta =  ((CPU) orden.get(i)).responderPregunta(PreguntaIngles.todasRespuestas);
						respuestaCorrecta = PreguntaIngles.comprobarPregunta(respuesta, PreguntaIngles.respuestaCorrecta);
						if (respuestaCorrecta) {
							orden.get(i).setPuntosRondas(orden.get(i).getPuntosRondas()+1);
							((CPU) orden.get(i)).setPuntosRondas(orden.get(i).getPuntosRondas());
	
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
						String respuestaJugadorM = ((Jugador) orden.get(i)).responderPregunta();
						String respuestaRealM = PreguntaMates.guardarRespuestaCorrecta(preguntaM);
						respuestaCorrecta = PreguntaMates.comprobarPregunta(respuestaJugadorM,respuestaRealM);
						break;
					case 2:
						char[] preguntaL = generarPreguntas(indicePreguntaAleatoria).toCharArray();
						ArrayList<Integer> posicionesAleatorias = new ArrayList<Integer>();
						posicionesAleatorias = PreguntaLengua.mostrarPregunta(preguntaL.length/3,preguntaL);
						String respuestaJugadorL = ((Jugador) orden.get(i)).responderPregunta();
						Map <String, Character> respuestaRealL = new HashMap<String, Character>();
						respuestaRealL = PreguntaLengua.guardarRespuestaCorrecta(preguntaL.length/3,preguntaL,posicionesAleatorias);
						respuestaCorrecta = PreguntaLengua.comprobarPregunta(respuestaJugadorL,respuestaRealL);
						break;
					case 3:
						String preguntaI = generarPreguntas(indicePreguntaAleatoria);
						PreguntaIngles.mostrarPregunta(preguntaI, PreguntaIngles.getTodasRespuestas());
						String respuestaJugadorI = ((Jugador) orden.get(i)).responderPregunta();
						respuestaCorrecta = PreguntaIngles.comprobarPregunta(respuestaJugadorI, PreguntaIngles.respuestaCorrecta);
						break;
					}
					if (respuestaCorrecta) {
						orden.get(i).setPuntosRondas(orden.get(i).getPuntosRondas()+1);
						//((Jugador) orden.get(i)).setPuntosRondas(orden.get(i).getPuntosRondas());
						System.out.println("HAS ACERTADO");
					}else {
						System.out.println("HAS FALLADO");
					}
				}
			}
			puntuacionRonda(contRondas,orden);
			contRondas++;
		}
		mostrarpuntuacionFinal(orden);
		guardarPuntuacionFinal(orden);
		menuFinPartida();
	}
	public String generarPreguntas(int num) {
		TipoPregunta pregunta = null;
		String enunciado = "";
		int lineasFichero = 0;
		switch (num) {
		case 1:
			pregunta = new PreguntaMates();
			enunciado = ((PreguntaMates)pregunta).generarPregunta();
			break;
		case 2:
			pregunta = new PreguntaLengua();
			lineasFichero = ((PreguntaLengua) pregunta).leerFichero();
			enunciado = Arrays.toString(((PreguntaLengua) pregunta).generarPregunta(lineasFichero));
			break;
		case 3:
			
			pregunta = new PreguntaIngles();
			lineasFichero = ((PreguntaIngles) pregunta).leerFichero();
			enunciado = ((PreguntaIngles)pregunta).generarPregunta(lineasFichero);
			break;
				
		}
		return enunciado;
	}
	public void puntuacionRonda (int numRonda,ArrayList<TipoJugador> orden) {
		System.out.println("PUNTOS DE LA RONDA "+ (numRonda+1) + ":");
		for (int i = 0; i < orden.size(); i++) {
			System.out.print((orden.get(i)).getNombre() + ": ");
			System.out.print((orden.get(i)).getPuntosRondas() + "\n");
		}
		
	}
	
	public void mostrarpuntuacionFinal (ArrayList<TipoJugador> orden) {
		System.out.println("PUNTUACIÓN FINAL:");
		for (int i = 0; i < orden.size(); i++) {
			System.out.print((orden.get(i)).getNombre() + ": ");
			System.out.print((orden.get(i)).getPuntosRondas()+ "\n");
		}
	}
	
	public void guardarPuntuacionFinal (ArrayList<TipoJugador> orden) {
		Map<String,Integer> historicoAux = new HashMap <String,Integer>();
		for (int i = 0; i < orden.size(); i++) {
			historicoAux.put(orden.get(i).getNombre(), orden.get(i).getPuntosHistorico());
		}
		GestionPuntos.setHistorico(historicoAux);
	}
	public void menuFinPartida() {
		Scanner leer = new Scanner(System.in);
		GestionPuntos.historico();
		GestionPuntos.ranking();
		System.out.println("FIN DE LA PARTIDA");
		System.out.println("ELIJA UNA DE LAS DOS OPCIONES: \n VOLVER A JUGAR \n SALIR");
		String opcion = leer.next();
		boolean error = false;
		do {
			if (opcion.equalsIgnoreCase("SALIR")) {
				System.out.println("GRACIAS POR JUGAR. HASTA PRONTO");
			}else if (opcion.equalsIgnoreCase("Volver a jugar")) {
				menuPrincipal();
			}else {
				System.err.println("ERROR, DEBE ELEGIR UNA DE LAS DOS OPCIONES DISPONIBLES");
				error = true;
			}
		}while (error);
	}
}
