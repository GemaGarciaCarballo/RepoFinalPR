package clases;

import java.util.Iterator;
import java.util.Set;

public class CPU extends TipoJugador {
	static private int nCPUs = 1; //para que cada vez que se juegue se reinicien las cpus
	public CPU() {
		super();
		this.setNombre("CPU"+nCPUs);
		nCPUs++;
	}
	
	
	public void responderPregunta(int tipoPregunta) {
		String respuesta = "";
		if (tipoPregunta == 1) {
			this.setPuntosHistorico(this.getPuntosHistorico()+1);
			System.out.println("HA ACERTADO");
		} else {
			System.out.println("HA FALLADO");
		}
	}

	public String responderPregunta(Set<String> respuestas) {
		String respuesta = "";
		int numAleatorio = TipoPregunta.generarAleatorio(respuestas.size()-1);
		Iterator it = respuestas.iterator();
		int cont = 0;
		while ((it.hasNext()) && (respuesta.equals(""))) {
			if (numAleatorio == cont) {
				respuesta = it.next().toString();
			}
			it.next();
			cont++;
		}
		return respuesta;
	}



}
