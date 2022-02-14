package dam.prog.actividadUF7_1.ej4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

import dam.prog.actividadUF7_1.ej4.pojo.Producto;

public class Ej4 {
	private static Scanner sc;
	private static TreeSet<Producto> prod;
	
	public static void main(String[] args) {
		prod = new TreeSet<Producto>();
		
		useTUI();
		System.out.println("Ejecución terminada");
	}
	
	private static void useTUI() {
		sc = new Scanner(System.in);
		boolean running = true;
		int r;
		String s;
		Producto p;
		ArrayList<Producto> prods;
		
		while (running) {
			System.out.println("Operación a realizar?\n1 - Añadir producto\n2 - Modificar precio\n3 - Eliminar producto\n4 - Mostrar lista\n5 - Terminar");
			r = getIntInRange("-> ", 1, 5);
			
			switch (r) {
				case 1:
					p = getProducto();
					prod.add(p);
					break;
				case 2:
					if (prod.size() == 0) {
						System.out.println("No hay productos introducidos.");
						break;
					}
					System.out.println("Introduce el nombre del producto(s): ");
					s = sc.nextLine();
					prods = findByName(s);
					if (prods.size() == 0) {
						System.out.printf("No hay ningún producto con el nombre \"%s\"\n", s);
					}
					else {
						for (Producto q : prods) {
							System.out.println("Introduce el nuevo precio de " + q);
							q.setPrecio(getNatural(" - Nuevo precio: "));
						}
					}
					break;
				case 3:
					if (prod.size() == 0) {
						System.out.println("No hay productos introducidos.");
						break;
					}
					System.out.println("Introduce el nombre del producto(s): ");
					s = sc.nextLine();
					prods = findByName(s);
					if (prods.size() == 0) {
						System.out.printf("No hay ningún producto con el nombre \"%s\"\n", s);
					}
					else {
						for (Producto q : prods) {
							System.out.println("Se va a eliminar " + q);
							System.out.print("Eliminar? [si/*, no]: ");
							if (! "no".equals(sc.nextLine().toLowerCase())) {
								prod.remove(q);
							}
						}
					}
					break;
				case 4:
					System.out.println("Productos:");
					for (Producto q : prod) {
						System.out.println(q);
					}
					break;
				case 5:
					running = false;
					break;
	
				default:
					System.out.println("Ups, no te entiendo");
					break;
			}
			System.out.println();
		}
		sc.close();
	}
	
	private static ArrayList<Producto> findByName(String s) {
		ArrayList<Producto> prods = new ArrayList<Producto>();
		for (Producto p : prod) {
			if (p.getNombre().equals(s)) {
				prods.add(p);
			}
		}
		return prods;
	}

	private static Producto getProducto() {
		System.out.println("Introduce los datos del nuevo producto:");
		System.out.print(" - Nombre: ");
		String nombre = sc.nextLine();
		int calidad = getNatural(" - Calidad: ");
		
		return new Producto(nombre, calidad);
	}

	/**
	 * @param question - Question to show using System.out.print
	 * @return Integer given by Scanner
	 */
	private static int getInt(String question) {
		while (true) {
			try {
				System.out.print(question);
				return Integer.parseInt(sc.nextLine());
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
