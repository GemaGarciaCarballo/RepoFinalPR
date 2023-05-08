package clases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GestionUsuario {
	private static Set <Jugador> jugadoresSistema;
	
//	public static void añadirUsuarioSistema(String jugador) {
//		jugadoresSistema = new HashSet<Jugador>();
//		jugadoresSistema.add(new Jugador(jugador));
//	}
	
	public static void verJugadores() {
		Iterator it = getJugadoresSistema().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public static void añadirJugador(Jugador nuevo) {
		if (((TipoJugador) getJugadoresSistema()).getNombre().equals(nuevo.getNombre())) {
			System.err.println("NO SE PUEDE AÑADIR, YA EXSTE EN EL SISTEMA");
		} else {
			jugadoresSistema.add(nuevo);
		}
	}
	public static void eliminarJugador(String jugador) {
		Iterator it = getJugadoresSistema().iterator();
		while (it.hasNext()) {
			if ( ((TipoJugador)  ((GestionUsuario) it).getJugadoresSistema()).getNombre().equals(jugador)) {// ESTÁ MAL
				jugadoresSistema.remove(it);
			} else {
				System.err.println("NO SE PUEDE ELIMINAR, NO EXSTE EN EL SISTEMA");
			}
		}
	}
	
	public static Set<Jugador> getJugadoresSistema() {
		return jugadoresSistema;
	}
	public static void setJugadoresSistema(Set<Jugador> jugadoresSistema) {
		jugadoresSistema = jugadoresSistema;
	}
}
