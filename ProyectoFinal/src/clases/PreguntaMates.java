package clases;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

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
			pregunta += it.next();
			cont++;
		}
		return pregunta;
		//mostrarPregunta(pregunta);
	}
	public static void mostrarPregunta(String pregunta) {
		System.out.println(pregunta);
	}
	public static String guardarRespuestaCorrecta (String pregunta) throws ScriptException {//guardar la respuesta correcta en una variable
//		ScriptEngineManager manager = new ScriptEngineManager();
//		ScriptEngine engine = manager.getEngineByName("p"); // no se lo que hace
//		respuestaCorrecta = (String) engine.eval(pregunta);
		//GENERAR CODIGO PARA RECOGER RESULTADO FORMULA SI ESTO NO FUNCIONA
		return respuestaCorrecta;
	}
	
}
