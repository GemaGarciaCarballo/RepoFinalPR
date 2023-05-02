package clases;

import java.io.FileNotFoundException;
import java.util.Set;

public abstract class TipoPregunta {
	private int tipo;
	public TipoPregunta() {
		switch(tipo) {
		case 1: 
			//new PreguntaMates
		}
	}
	public abstract void mostrarPregunta() throws FileNotFoundException;
	public int generarAleatorio(int tope) {
		int aleatorio = (int) (Math.random()*(tope-1)+1);
		return aleatorio;
	}

}
