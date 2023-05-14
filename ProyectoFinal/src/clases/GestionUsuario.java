package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class GestionUsuario {
	private final ArrayList<Jugador> jugadoresSistema;

	public GestionUsuario() {
		jugadoresSistema = new ArrayList<Jugador>();
	}

	public void verJugadores() {
		this.getJugadoresSistema()
				.forEach(System.out::println);
	}

	public void annadirJugador(Jugador nuevo) {

		this.getJugadoresSistema()
				.stream()
				.filter(objeto -> objeto.getNombre().equals(nuevo.getNombre()))
				.findFirst()
				.orElseGet(() -> {
					this.getJugadoresSistema().add(nuevo);
					return nuevo;
				});

		//patron de la bandera
//		boolean encontrado = Boolean.FALSE;
//		for(Jugador j : this.getJugadoresSistema()){
//			if (!encontrado){
//				if (j.getNombre().equals(nuevo.getNombre())){
//					encontrado = Boolean.TRUE;
//				}
//			}
//		}
//		if (!encontrado){
//			this.getJugadoresSistema().add(nuevo);
		// Y GRABAR EN EL FICHERO DE JUGADORES
//		} else {
//			System.out.println("El jugador ya existe en el juego");
//		}
	}
//	public void eliminarJugador(String jugador) {
//		Iterator<Jugador> it = getJugadoresSistema().iterator();
//		while (it.hasNext()) {
//			if ( ((TipoJugador)  ((GestionUsuario) it).getJugadoresSistema()).getNombre().equals(jugador)) {// ESTÁ MAL
//				this.jugadoresSistema.remove(it);
//			} else {
//				System.err.println("NO SE PUEDE ELIMINAR, NO EXSTE EN EL SISTEMA");
//			}
//		}
//	}

	public ArrayList<Jugador> getJugadoresSistema() {
		return jugadoresSistema;
	}

	public static void setJugadoresSistema(Set<Jugador> jugadoresSistema) {
		jugadoresSistema = jugadoresSistema;
	}

	public boolean existeJugador(String nombre) {
		//patron de la bandera
		boolean encontrado = Boolean.FALSE;
		for(Jugador j : this.getJugadoresSistema()){
			if (!encontrado){
				if (j.getNombre().equals(nombre)){
					encontrado = Boolean.TRUE;
				}
			}
		}
		return encontrado;

//		return this.getJugadoresSistema()
//				.stream()
//				.filter(objeto -> objeto.getNombre().equals(nombre)).toList().size() > 0;
	}
}
