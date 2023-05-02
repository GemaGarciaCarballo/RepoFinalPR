package clases;

public class PreguntaMates extends TipoPregunta {

	
	public void generarPregunta() {
		int longitudPregunta = generarAleatorio(8);
		boolean preguntaTerminada = false;
		while (!preguntaTerminada) {
			if (longitudPregunta > 4) {
				
				generarAleatorio(12);
				preguntaTerminada = true;
			}else {
				longitudPregunta = generarAleatorio(8);
			}
		}
		
		
	}

}
