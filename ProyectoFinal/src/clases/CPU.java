package clases;

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
			this.setpuntosHistorico(this.getpuntosHistorico()+1);
			System.out.println("HA ACERTADO");
		} else (tipoPregunta == 2) {
			System.out.println("HA FALLADO");
		}
			//MOSTRAR RESPUESTA CORRECTA PERO AQUI NO
//		}else {
//			int respuestaAleatoria = (int) (Math.random()*(4-1)+1);
//			switch (respuestaAleatoria) {
//			case 1:
//				respuesta = "0";
//				break;
//			case 2:
//				respuesta = "1";
//				break;
//			case 3: 
//				respuesta = "2";
//				break;
//			case 4:
//				respuesta = "3";
//				break;
//			
//			}
//		}
	}
	public String responderPregunta(Set<String> respuestas) {
		//coger una respuesta aleatoria del set
		//String respuesta = respuestas.
		return respuesta;
	}

}
