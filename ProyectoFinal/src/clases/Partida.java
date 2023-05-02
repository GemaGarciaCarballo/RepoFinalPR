package clases;

import java.util.Scanner;

public class Partida {
	//jugadores

	public Partida() {

	}
	
	public void menuPrincipal() {
		Scanner leer = new Scanner (System.in);
		int respuesta = 0;
		System.out.println("***********************");
		System.out.println("BIENVENIDO, ELIGE UNA OPCIÓN: \n 1) JUGAR PARTIDA \n 2) RANKING \n 3) HISTORICO \n 4)JUGADORES \n 5) SALIR");
		respuesta = leer.nextInt();
		switch (respuesta) {
		case 1: 
			jugar();
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
				verJugadores();
				break;
			case 2:
				añadirJugador();
				break;
			case 3:
				eliminarJugador();
				break;
			case 4:
				menuPrincipal();
				break;
			default: 
				System.err.println("DEBE ELEGIR UNA DE LAS 4 OPCIONES DISPONIBLES");
		}
	}
	public void verJugadores() {
		
	}
	public void añadirJugador() {
		
	}
	public void eliminarJugador() {
		
	}
	public void jugar() {
		
	}
	public void ranking() {
		
	}
	public void historico() {
		
	}
}
