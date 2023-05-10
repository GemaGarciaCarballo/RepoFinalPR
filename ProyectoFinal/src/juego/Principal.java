package juego;

import java.util.HashSet;
import java.util.Set;

import clases.*;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class Principal {
	public static void main(String[] args) {
		//Set<TipoJugador> j = new HashSet<TipoJugador>();
		Partida a = new Partida();
		a.menuPrincipal();
	}
}
