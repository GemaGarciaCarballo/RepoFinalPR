package clases;

public class CPU extends TipoJugador {
	static private int nCPUs = 1; //para que cada vez que se juegue se reinicien las cpus
	public CPU() {
		super();
		this.setNombre("CPU"+nCPUs);
		nCPUs++;
	}
	
	
	public String responderPregunta(TipoPregunta pregunta) {
		String respuesta = "";
		if (pregunta instanceof PreguntaMates) {
			this.setpuntosHistorico(this.getpuntosHistorico()+1);
			System.out.println("HA ACERTADO");
		} else if (pregunta instanceof PreguntaLengua) {
			this.setpuntosHistorico(this.getpuntosHistorico());
			System.out.println("HA FALLADO");
			//MOSTRAR RESPUESTA CORRECTA PERO AQUI NO
		}else {
			int respuestaAleatoria = (int) (Math.random()*(4-1)+1);
			switch (respuestaAleatoria) {
			case 1:
				respuesta = "0";
				break;
			case 2:
				respuesta = "1";
				break;
			case 3: 
				respuesta = "2";
				break;
			case 4:
				respuesta = "3";
				break;
			
			}
		}
		return respuesta;
	}

}
