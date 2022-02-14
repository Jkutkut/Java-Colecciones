package dam.prog.actividadUF7_1.ej2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import dam.prog.actividadUF7_1.ej2.pojo.Producto;

public class Ej2 {
	
	private static ArrayList<Producto> prodArrList;
	private static HashSet<Producto> prodHashSet;
	private static TreeSet<Producto> prodTreeSet;
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		prodArrList = new ArrayList<Producto>();
		prodHashSet = new HashSet<Producto>();
		prodTreeSet = new TreeSet<Producto>();

		useTUI();
		System.out.println("Ejecución terminada");
	}

	private static void useTUI() {
		sc = new Scanner(System.in);
		boolean running = true;
		int r;
		String s;
		Producto prod;
		
		while (running) {
			System.out.println("Operación a realizar?\n1 - Añadir producto\n2 - Eliminar producto\n3 - Mostrar lista\n4 - Terminar");
			r = getIntInRange("-> ", 1, 4);
			
			switch (r) {
			case 1:
				prod = getProducto();
				prodArrList.add(prod);
				prodHashSet.add(prod);
				prodTreeSet.add(prod);
				break;
			case 2:
				if (prodArrList.size() == 0 && prodHashSet.size() == 0 && prodTreeSet.size() == 0) {
					System.out.println("No hay productos introducidos");
					break;
				}
				System.out.print("Qué producto quieres modificar?\n - Nombre producto: ");
				s = sc.nextLine().trim();
				r = getNatural(" - Cantidad: ");
				prod = new Producto(s, r);
				while (prodArrList.contains(prod))
					prodArrList.remove(prod); // Ya que guarda duplicados, eliminamos todos los que tenga estas características.
				prodHashSet.remove(prod);
				prodTreeSet.remove(prod);
				break;
			case 3:
				System.out.println("ArrayList:");
				for (Producto p : prodArrList)
					System.out.println(p);
				System.out.println("\n\nHashSet:");
				for (Producto p : prodHashSet)
					System.out.println(p);
				System.out.println("\n\nTreeSet:");
				for (Producto p : prodTreeSet)
					System.out.println(p);
				break;
			case 4:
				running = false;
				break;
			default:
				// No ocurrirá nunca.
				// Lo mantengo por si en algún momento implemento más opciones
				System.out.println("Ups, no te entiendo");
				break;
			}
			System.out.println("\n");
		}
		sc.close();
	}
	
	private static Producto getProducto() {
		System.out.println("Introduce los datos del nuevo producto:");
		System.out.print(" - Nombre: ");
		String nombre = sc.nextLine().trim();
		int cantidad = getNatural(" - Cantidad: ");
		
		return new Producto(nombre, cantidad);
	}

	/**
	 * @param question - Question to show using System.out.print
	 * @return Integer given by Scanner
	 */
	private static int getInt(String question) {
		while (true) {
			try {
				System.out.print(question);
				return Integer.parseInt(sc.nextLine().trim());
			}
			catch (NumberFormatException e) {
				System.out.println("El valor no es un número entero válido.\n");
			}
		}
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @return Integer greater or equal to 0
	 */
	private static int getNatural(String question) {
		int n = 0;
		boolean isNotNatural = true;
		while (isNotNatural) {
			n = getInt(question);
			
			if (n >= 0) {
				isNotNatural = false;
			}
			else {
				System.out.println("El número tiene que ser un natural -> [0, inf)\n");
			}
		}
		return n;
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @param min - min value of the desired int
	 * @param max - max value of the desired int
	 * @return Integer inside the interval [min, max]
	 */
	public static int getIntInRange(String question, int min, int max) {
		if (min > max) {
			int swap = min;
			min = max;
			max = swap;
		}
		
		int n = 0;
		boolean isNotValid = true;
		while (isNotValid) {
			n = getInt(question);
			
			if (n >= min && n <= max) {
				isNotValid = false;
			}
			else {
				System.out.printf(
					"El número tiene que ser un natural en el rango [%d, %d]\n\n",
					min, max
				);
			}
		}
		return n;
	}

}
