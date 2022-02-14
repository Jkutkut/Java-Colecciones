package dam.prog.actividadUF7_2.ej4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class Ej4 {
	
	private static final int MIN_LEN = 9;
	private static final int MAX_LEN = 30;
	
	public static void main(String[] args) {
		String[] words = "Hola caracola qué tal estás?".split(" ");
		ArrayList<String> lst = new ArrayList<String>();
		
		Random r = new Random();
		
		int s = r.nextInt(MAX_LEN - MIN_LEN) + MIN_LEN;
		for (int i = 0; i < s; i++) {
			lst.add(words[r.nextInt(words.length)]);
		}
		
		System.out.println("Elementos ArrayList:");
		System.out.println(lst.toString());
		
		System.out.println("\nContadores:");
		TreeMap<String, Integer> count = countWords(lst);
		System.out.println(count.toString());
		
		// Apartado B
		ArrayList<String> repeticionPar = getEvenRepeat(count);
		System.out.println("\nPalabras que se repiten de manera par:");
		System.out.println(repeticionPar);
		
		// Apartado C
		Collection<Integer> serie = count.values();
		System.out.println("\nLa serie es:");
		System.out.println(serie);
		ArrayList<Integer> moda = getModa(serie);
		System.out.println("\nLa moda es: " + ((moda.size() == 0) ? "ninguna" : moda.toString()));
	}

	private static TreeMap<String, Integer> countWords(ArrayList<String> lst) {
		TreeMap<String, Integer> count = new TreeMap<String, Integer>();
		String current;
		for (int i = 0; i < lst.size(); i++) {
			current = lst.get(i);
			if (count.containsKey(current))
				count.put(current, count.get(current) + 1);
			else
				count.put(current, 1);
		}
		return count;
	}
	
	private static ArrayList<String> getEvenRepeat(TreeMap<String, Integer> count) {
		ArrayList<String> repeat = new ArrayList<String>();
		for (String str : count.keySet()) {
			if (count.get(str) % 2 == 0)
				repeat.add(str);
		}
		return repeat;
	}

	private static ArrayList<Integer> getModa(Collection<Integer> serie) {
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		
		int max = 0;
		for (int value : serie) {
			if (count.containsKey(value)) {
				count.put(value, count.get(value) + 1);
			}
			else {
				count.put(value, 1);
			}
			if (max < count.get(value)) {
				max = count.get(value);
			}
		}
		
		ArrayList<Integer> moda = new ArrayList<Integer>();
		if (max > 1) {
			for (int key : count.keySet()) {
				if (count.get(key) == max) {
					moda.add(key);
				}
			}
		}
		
		return moda;
	}
}
