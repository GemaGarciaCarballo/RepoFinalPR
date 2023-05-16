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

//		this.getJugadoresSistema()
//				.stream()
//				.filter(objeto -> objeto.getNombre().equals(nuevo.getNombre()))
//				.findFirst()
//				.orElseGet(() -> {
//					this.getJugadoresSistema().add(nuevo);
//					return nuevo;
//				});

		boolean encontrado = false;
		//LEER RANKING
		for(Jugador jugador : this.getJugadoresSistema()){
			if (jugador.getNombre().equals(nuevo.getNombre())){
				encontrado = true;
			}
		}
		
		if (!encontrado){
			this.getJugadoresSistema().add(nuevo);
		// GRABAR EN EL RANKING
			
		} else {
			System.out.println("EL JUGADOR YA EXISTE");
		}
	}
	public void eliminarJugador(String jugador) {
		//Iterator<Jugador> it = getJugadoresSistema().iterator();
		int cont = 0;
//		while (it.hasNext()) {
//			if (((GestionUsuario) it).getJugadoresSistema().get(cont).getNombre().equals(jugador)) {// ESTÁ MAL
//				this.jugadoresSistema.remove(it);
//			} else {
//				System.err.println("NO SE PUEDE ELIMINAR, NO EXSTE EN EL SISTEMA");
//			}
//			cont++;
//		}
		while (cont < this.jugadoresSistema.size()) {
			if (getJugadoresSistema().get(cont).getNombre().equals(jugador)) {
				this.jugadoresSistema.remove(cont);
				//ELIMINAR DEL RANKING Y DEL FICHERO JUGADORES
			} else {
				System.err.println("NO SE PUEDE ELIMINAR, NO EXSTE EN EL SISTEMA");
			}
			cont++;
		}
	}

	public ArrayList<Jugador> getJugadoresSistema() {
		return jugadoresSistema;
	}

	public static void setJugadoresSistema(Set<Jugador> jugadoresSistema) {
		jugadoresSistema = jugadoresSistema;
	}

	public boolean existeJugador(String nombre) {
		boolean encontrado = false;
		for(Jugador jugador : this.getJugadoresSistema()){
			if (!encontrado){
				if (jugador.getNombre().equals(nombre)){
					encontrado = true;
				}
			}
		}
		return encontrado;

//		return this.getJugadoresSistema()
//				.stream()
//				.filter(objeto -> objeto.getNombre().equals(nombre)).toList().size() > 0;
	}
}
