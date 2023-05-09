package tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.script.ScriptException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clases.PreguntaMates;
import clases.TipoPregunta;

class testPreguntaMates {
//	@BeforeAll
//	static void antesDeTodo() {
//		 TipoPregunta p = new PreguntaMates();
//	}
	@Test
	void testRespuestaCorrecta() throws ScriptException {
		TipoPregunta p = new PreguntaMates();
		int resultadoEsperado = 0;
		String resultadoReal = ((PreguntaMates) p).guardarRespuestaCorrecta("2+2");
		assertEquals(resultadoEsperado,String.valueOf(resultadoReal));
	}

}
