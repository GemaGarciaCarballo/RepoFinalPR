package clases;

public class CPU extends TipoJugador {
	static private int nCPUs;
	public CPU() {
		super();
		//constructor CPUS sin parametros
	}
	
	@Override
	public String responderPregunta(TipoPregunta pregunta) {
		String respuesta = "";
		if (pregunta instanceof PreguntaMates) {
			this.setPuntos(this.getPuntos()+1);
			System.out.println("HA ACERTADO");
		} else if (pregunta instanceof PreguntaLengua) {
			this.setPuntos(this.getPuntos());
			System.out.println("HA FALLADO");
			//MOSTRAR RESPUESTA CORRECTA
		}else {
			int respuestaAleatoria = (int) (Math.random()*(4-1)+1);
			switch (respuestaAleatoria) {
			case 1:
				respuesta = "A";
				break;
			case 2:
				respuesta = "B";
				break;
			case 3: 
				respuesta = "C";
				break;
			case 4:
				respuesta = "D";
				break;
			
			}
		}
		return respuesta;
	}

}
