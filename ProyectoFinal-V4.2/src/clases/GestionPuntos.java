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
	
	public static void leerRanking() {
		File fichero = new File("src/juego/ranking.txt");
		try {
			Scanner entrada = new Scanner (fichero);
			while (entrada.hasNextLine()) {
				ranking.put(entrada.next(), entrada.nextInt());
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void escribirRanking() {
		File fichero = new File("src/juego/ranking.txt");
		try {
			FileWriter writer = new FileWriter(fichero,true);
			List<Map.Entry<String, Integer>> listaHistorico = new ArrayList<>((historico.entrySet()));
			listaHistorico.sort(Entry.comparingByValue());
			for (Entry<String, Integer> entrada: listaHistorico) {
				ranking.put(entrada.getKey(), entrada.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//FALTA TERMINARLO
	public static void mostrarRanking() {
		 Map<String, Integer> rankingAux = new LinkedHashMap<String,Integer>();
		 rankingAux.putAll(ranking);
		while (rankingAux.size() > 0) {
			System.out.println(rankingAux);
		}
	}

	//FALTA TERMINARLO
	public static void mostrarHistorico() {
		 Map<String, Integer> historicoAux = new LinkedHashMap<String,Integer>();
		 historicoAux.putAll(historico);
		while (historicoAux.size() > 0) {
			System.out.println(historicoAux);
		}
	}
	public static void escribirHistorico() {
		File fichero = new File("src/juego/historico.txt");
		try {
			FileWriter writer = new FileWriter(fichero,true);
			writer.write(getHistorico().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void leerHistorico() {
		File fichero = new File("src/juego/historico.txt");
		try {
			Scanner entrada = new Scanner (fichero);
			while (entrada.hasNextLine()) {
				historico.put(entrada.next(), entrada.nextInt());
			}
			entrada.close();
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
