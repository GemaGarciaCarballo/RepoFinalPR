package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * 
 * @author Gema García Carballo
 *
 */
public class GestionPuntos {
	private static Map <String,Integer> historico;
	private static ArrayList<String> ranking;
	
	public static void ranking() {
		//ranking = new ArrayList<String>();
		File fichero = new File("src/juego/ranking.txt");
		try {
			FileWriter writer = new FileWriter(fichero,true);
			//Set<String> clavesHistorico = historico.keySet(); 
			ArrayList<String> claves = new ArrayList<String>();
			Collection<Integer> valoresHistorico = historico.values();
			ArrayList<Integer> valores = new ArrayList<Integer>(valoresHistorico);//meto todos los puntos en una lista
			
			valores.sort(null);
			//ORDENAR RANKING CON SUS RESPECTIVAS CLAVES
			for (int i = 0; i <historico.size(); i++) {
				if (historico.)
				claves.add(historico.get(valores.get(i)));
				claves.a
			}
//			for (int i = 0; i <claves.size(); i++) {
//				writer.write(claves.get(i) + valores.get(i));
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void historico() {
		//historico = new HashMap<String, Integer>();
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
		historico = historico;
	}
	public static ArrayList<String> getRanking() {
		return ranking;
	}
	public static void setRanking(ArrayList<String> ranking) {
		GestionPuntos.ranking = ranking;
	}

}
