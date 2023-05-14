package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * @author Gema García Carballo
 *
 */
public class GestionPuntos {
	private static Map <String,Integer> historico = new HashMap<String,Integer>();
	private static Map<String, Integer> ranking = new LinkedHashMap<String,Integer>();
	
	public static void ranking() {
		File fichero = new File("src/juego/ranking.txt");
		try {
			FileWriter writer = new FileWriter(fichero,true);
			//ORDENAR RANKING CON SUS RESPECTIVAS CLAVES: DEBERÍA VOL
			List<Map.Entry<String, Integer>> listaHistorico = new ArrayList<>((historico.entrySet()));
			listaHistorico.sort(Entry.comparingByValue());
			for (Entry<String, Integer> entrada: listaHistorico) {
				ranking.put(entrada.getKey(), entrada.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void historico() {
		File fichero = new File("src/juego/historico.txt");
		try {
			FileWriter writer = new FileWriter(fichero,true);
			writer.write(getHistorico().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Map<String, Integer> getHistorico() {
		return historico;
	}
	public static void setHistorico(Map<String, Integer> historico) {
		GestionPuntos.historico = historico;
	}
	public static Map<String, Integer> getRanking() {
		return ranking;
	}
	public static void setRanking(Map<String, Integer> ranking) {
		GestionPuntos.ranking = ranking;
	}

}
