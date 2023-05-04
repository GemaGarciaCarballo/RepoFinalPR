package clases;

import java.util.Scanner;

public class GestionPartida {
	
//	public void pantallaSeleccionJugadores() {
//		Scanner leer = new Scanner (System.in);
//		int numJugadores = 0;
//		boolean exito = false;
//		System.out.println("BIENVENIDO A LA PARTIDA");
//		System.out.println("¿CUÁNTOS JUGADORES VAN A JUGAR?");
//		numJugadores = leer.nextInt();
//		while((numJugadores > 0) && (!exito)) {
//			System.out.println("¿DE QUÉ TIPO ES EL JUGADOR: JUGADOR O MÁQUINA?");
//			String tipo = leer.next();
//			if (tipo.equalsIgnoreCase("JUGADOR")) {
//				System.out.println("ESCRIBA EL NOMBRE DEL JUGADOR SIN ESPACIOS");
//				String nombre = leer.next();
//				if (GestionUsuario.getJugadoresSistema().contains(nombre)) {
//					jugadoresPartida.add(new Jugador (nombre));
//				} else {
//					System.out.println("ESTE JUGADOR NO FIGURA EN EL SISTEMA ¿DESEA DARLO DE ALTA?");
//					if (leer.next().equalsIgnoreCase("SI")) {
//						((GestionUsuario) GestionUsuario.getJugadoresSistema()).añadirUsuarioSistema((nombre));
//						exito = true;
//					} else {
//						exito = false;
//						System.err.println("ERROR");
//					}
//				}
//			}else if (tipo.equalsIgnoreCase("MAQUINA")) {
//				jugadoresPartida.add(new CPU());
//			} else {
//				System.err.println("ERROR, LOS JUGADORES DEBEN SER JUGADORES O MÁQUINAS");
//			}
//		}
//	}
}
