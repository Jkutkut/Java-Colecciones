package dam.prog.actividadUF7_2.ej3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class Ej3 {
private static final int NUMEROS_A_GENERAR = 100;
	
	private static final int RANGO_MIN = 1;
	private static final int RANGO_MAX = 100;
	
	public static void main(String[] args) {
		ArrayList<Integer> tablaAlea = new ArrayList<Integer>();
		
		generaTabla(tablaAlea);
		mostrarTabla(tablaAlea, NUMEROS_A_GENERAR / 10);
		@SuppressWarnings("unchecked")
		ArrayList<Integer> tablaOrdenada = (ArrayList<Integer>) tablaAlea.clone();
		tablaOrdenada.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1 - arg0;
			}
		});
		mostrarTabla(tablaOrdenada, NUMEROS_A_GENERAR / 10);
		
		// Usa el arrayList ordenado para hacer búsqueda binaria de la tabla dada como 1º parámetro.
		// Esto permite realizar la mísma búsqueda con un solo algoritmo.
		// Otra opción era almacenar todos los encontrados en un arraylist y ordenarlos para la segunda búsqueda.
		System.out.println("Los no repetidos son:");
		mostrarNoRepetidos(tablaAlea, tablaOrdenada);
		System.out.println("\nLos no repetidos en orden descendente son:");
		mostrarNoRepetidos(tablaOrdenada, tablaOrdenada);
	}

	private static void generaTabla(ArrayList<Integer> tablaAlea) {
		Random r = new Random();
		for (int i = 0; i < NUMEROS_A_GENERAR; i++) {
			tablaAlea.add(r.nextInt(RANGO_MAX - RANGO_MIN) + RANGO_MIN);
		}
	}

	private static void mostrarTabla(ArrayList<Integer> tablaAlea, int rowSize) {
		System.out.println("Elementos generados");
		for (int j, i = 0; i < tablaAlea.size(); i += rowSize) {
			for (j = 0; j < rowSize && i + j < tablaAlea.size(); j++) {
				System.out.print(String.format("%3d", tablaAlea.get(i + j)));
			}
			System.out.println();
		}
		System.out.println();	
	}
	
	private static void mostrarNoRepetidos(ArrayList<Integer> tabla, ArrayList<Integer> tablaOrdenada) {
		int i, valor;
		for (i = 0; i < tabla.size(); i++) {
			valor = tabla.get(i);
			if (findArrOrdenado(valor, tablaOrdenada) == 1) {
				System.out.printf("%3d ", valor);
			}
		}
		
	}

	private static int findArrOrdenado(int valor, ArrayList<Integer> tablaOrdenada) {
		int iniP = binarySearch(tablaOrdenada, 0, tablaOrdenada.size() - 1, valor);
		if (iniP == -1) { // No debería ejecutarse nunca
			throw new RuntimeException("No he encontrado el valor " + valor);
		}
		int count = 1;
		
		// Cuenta los elementos de la lista ordenada con el mismo valor.
		// Tienen que estar a la derecha o izquierda de la posición encontrada iniP
		for (int i = 1; i + iniP < tablaOrdenada.size() && tablaOrdenada.get(iniP + i) == valor; i++)
			count++;
		for (int i = 1; iniP - i >= 0 && tablaOrdenada.get(iniP - i) == valor; i++)
			count++;
		
		return count;
	}
	
	private static int binarySearch(ArrayList<Integer> arr, int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) == x)
                return mid;
            if (arr.get(mid) < x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}
