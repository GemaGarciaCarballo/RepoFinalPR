package clases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class PreguntaMates extends TipoPregunta {
	private static String respuestaCorrecta;

	public void PreguntaMates(){
		generarPregunta();
	}
	public String generarPregunta() {
		String pregunta = "";
		int cont = 0;
		Set<String> signos = new HashSet<String>();
		signos.add(" + ");
		signos.add(" - ");
		signos.add(" * ");
		Iterator it = signos.iterator();
		int longitudPregunta = generarAleatorio(8,4);
		while (cont < longitudPregunta) {
			pregunta +=  generarAleatorio(12,2);
			if (it.next() != null){
				pregunta += it.next();
			}else {
				//o reiniciar de alguna manera el iterator o crear uno auxiliar o rellenarlo con mas signos
			}
			cont++;
		}
		return pregunta;
		//mostrarPregunta(pregunta);
	}
	public static void mostrarPregunta(String pregunta) {
		System.out.println(pregunta);
	}
	public static String guardarRespuestaCorrecta (String pregunta) {//guardar la respuesta correcta en una variable
//		ScriptEngineManager manager = new ScriptEngineManager();
//		ScriptEngine engine = manager.getEngineByName("Java"); // nombre de la factory de engine
//		respuestaCorrecta = (String) engine.eval(pregunta);
		//GENERAR CODIGO PARA RECOGER RESULTADO FORMULA SI ESTO NO FUNCIONA
		//BUSCAR LAS MULTIPLICACIONES
		
		
		return respuestaCorrecta;
	}
	
}
