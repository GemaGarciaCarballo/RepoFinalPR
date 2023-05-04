package clases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Partida {
	private Set<TipoJugador> jugadoresPartida;
	private int rondas;

	public Partida() {
		this.jugadoresPartida = new HashSet<TipoJugador>();
		this.jugadoresPartida.add(null);
	}
	
	public void menuPrincipal() {
		Scanner leer = new Scanner (System.in);
		int respuesta = 0;
		System.out.println("***********************");
		System.out.println("BIENVENIDO, ELIGE UNA OPCIÓN: \n 1) JUGAR PARTIDA \n 2) RANKING \n 3) HISTORICO \n 4)JUGADORES \n 5) SALIR");
		respuesta = leer.nextInt();
		switch (respuesta) {
		case 1: 
			pantallaSeleccionJugadores();
			int rondas = seleccionRondas();
			jugar(rondas);
			break;
		case 2:
			ranking();
			break;
		case 3:
			historico();
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
				menuPrincipal();
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
						((GestionUsuario) GestionUsuario.getJugadoresSistema()).añadirUsuarioSistema((nombre));
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
		System.out.println("¿CUÁNTAS RONDAS QUIERE JUGAR?");
		int numRondas = leer.nextInt();
		return numRondas;
	}
	public void jugar(int rondas) {
		
	}
	public void ranking() {
		
	}
	public void historico() {
		
	}
}
