package dam.prog.actividadUF7_3.ej1;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class Ej1 {
	
	private static final int SOLICITAR = 10;
	
	public static void main(String[] args) {
		HashMap<String, Integer> tablaPalabras = new HashMap<String, Integer>();
		
		rellenaTabla(tablaPalabras);
		
		System.out.println("\n\nLa tabla ordenada por color Alfabéticamente:");
		muestraOrdenadoKey(tablaPalabras);
		System.out.println("\n\nLa tabla ordenada por longitud:");
		muestraOrdenadoValue(tablaPalabras);
	}

	private static void rellenaTabla(HashMap<String, Integer> tablaPalabras) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc;
		try {
			sc = new Scanner(new File("src/dam/prog/actividadUF7_3/ej1/datos.txt"));
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		String current;
		System.out.println("Introduce los colores");
		while (tablaPalabras.size() < SOLICITAR) {
			System.out.print("Introduce la palabra " + (tablaPalabras.size() + 1) + ": ");
			current = sc.nextLine();
			System.out.println(current);
			if (tablaPalabras.containsKey(current)) {
				System.out.printf("La palabra %s ya está introducida\n", current);
			}
			else {
				tablaPalabras.put(current, current.length());
			}
		}
		sc.close();
	}
	
	private static void muestraOrdenadoKey(HashMap<String, Integer> tablaPalabras) {
		TreeSet<String> ordenada = new TreeSet<String>();
		
		ordenada.addAll(tablaPalabras.keySet());
		for (String str : ordenada) {
			System.out.printf("%s con %d letras\n", str, tablaPalabras.get(str));
		}
	}
	
	private static void muestraOrdenadoValue(HashMap<String, Integer> tablaPalabras) {
		Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1 - arg0;
			}
		};
		TreeMap<Integer, TreeSet<String>> tabla = new TreeMap<Integer, TreeSet<String>>(cmp);
		
		int l;
		for (String k : tablaPalabras.keySet()) {
			l = tablaPalabras.get(k);
			if (!tabla.containsKey(l)) {
				tabla.put(l, new TreeSet<String>());
			}
			tabla.get(l).add(k);
		}
		
		for (Integer q : tabla.keySet()) {
			for (String s : tabla.get(q)) {
				System.out.printf("%s con %d letras\n", s, q);
			}
		}
	}
}
