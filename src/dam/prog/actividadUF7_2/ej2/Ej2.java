package dam.prog.actividadUF7_2.ej2;

import java.util.HashMap;
import java.util.Random;

public class Ej2 {
	
	private static final int NUMEROS_A_GENERAR = 100;
	
	private static final int RANGO_MIN = 1;
	private static final int RANGO_MAX = 100;
	
	private static final int[] APARICIONES = {5, 2};
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> tablaAlea = new HashMap<Integer, Integer>();
		
		analizaGeneracionAleatorios(tablaAlea);
		
		imprimeNumerosFaltantes(tablaAlea);
		
		for (int i = 0; i < APARICIONES.length; i++) {
			imprimeApariciones(tablaAlea, APARICIONES[i]);
		}
		
		imprimeOrdenados(tablaAlea);
	}

	private static void analizaGeneracionAleatorios(HashMap<Integer, Integer> tablaAlea) {
		Random rng = new Random();
		int r;
		for (int i = 0; i < NUMEROS_A_GENERAR; i++) {
			r = rng.nextInt(RANGO_MAX - RANGO_MIN + 1) + RANGO_MIN;
			if (tablaAlea.containsKey(r)) {
				tablaAlea.put(r, tablaAlea.get(r) + 1);
			}
			else {
				tablaAlea.put(r, 1);
			}
		}
	}
	
	private static void imprimeNumerosFaltantes(HashMap<Integer, Integer> tablaAlea) {
		// Hay tan poca probabilidad de que todos estén introducidos que no he implementado el caso
		System.out.println("Los números no introducidos son:");
		for (int i = RANGO_MIN; i <= RANGO_MAX; i++) {
			if (!tablaAlea.containsKey(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");
	}
	
	private static void imprimeApariciones(HashMap<Integer, Integer> tablaAlea, int aparicion) {
		boolean found = false;
		System.out.println("Buscando números que se hayan generado " + aparicion + " veces.");
		for (int i = RANGO_MIN; i <= RANGO_MAX; i++) {
			if (tablaAlea.containsKey(i) && tablaAlea.get(i) == aparicion) {
				System.out.print(i + " ");
				found = true;
			}
		}
		if (!found) {
			System.out.print("No se han encontrado números que aparezcan " + aparicion + " veces.");
		}
		System.out.println("\n");
	}
	
	private static void imprimeOrdenados(HashMap<Integer, Integer> tablaAlea) {
		for (int i = RANGO_MIN; i < RANGO_MAX; i++) {
			if (tablaAlea.containsKey(i)) {
				System.out.printf("Número %2d: %2d aparici%s\n", i, tablaAlea.get(i), (tablaAlea.get(i) > 1) ? "ones" : "ón");
			}
		}
		
	}
}
