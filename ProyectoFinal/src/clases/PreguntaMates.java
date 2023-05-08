package clases;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class PreguntaMates extends TipoPregunta {
	private String respuestaCorrecta;

	public void PreguntaMates(){
		generarPregunta();
	}
	public void generarPregunta() {
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
		mostrarPregunta(pregunta);
	}
	public void mostrarPregunta(String pregunta) {
		System.out.println(pregunta);
	}
	public void guardarRespuestaCorrecta (String pregunta) {//guardar la respuesta correcta en una variable
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName(null); // no se lo que hace
		this.respuestaCorrecta = (String) engine.eval(pregunta);
		
	}
	
}
