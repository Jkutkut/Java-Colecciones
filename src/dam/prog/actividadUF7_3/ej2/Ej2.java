package dam.prog.actividadUF7_3.ej2;

import java.util.ArrayList;
import java.util.Scanner;

import dam.prog.actividadUF7_3.ej2.pojo.Cancion;
import dam.prog.actividadUF7_3.ej2.pojo.InvalidDataException;

public class Ej2 {

	private static ArrayList<Cancion> playlist;
	private static Scanner sc;
	
	private static String menu;
	private static String[] menuOptions = {
			"Añadir canción",
			"Eliminar canción",
			"Mostrar canciones",
			"Reproducir canción por posición",
			"Reproducir toda la lista",
			"Indicar tiempo total playlist",
			"Salir de la playlist"
	};
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		playlist = new ArrayList<Cancion>();

		runTUI();
	}

	private static void runTUI() {
		boolean running = true;
		menu = strJoin(menuOptions, "\n", "- %d ");
		int selected;
		while (running) {
			selected = getIntInRange(
				"Selecione una opción:\n" + menu + "\n-> ",
				1, menuOptions.length
			);
			switch (selected) {
			case 1:
				
//				break;
			case 2:
				
//				break;
			case 3:
				
//				break;
			case 4:
				
//				break;
			case 5:
				
//				break;
			case 6:
				System.out.println("Not implemented");
				break;
			case 7:
				running = false;
				break;
			default:
				throw new InvalidDataException("Ups, esto no tendría que pasar.");
			}
		}
	}

	
	private static String strJoin(String[] arr, String sep, String prefix) {
		String str = "";
		if (prefix == null)
			prefix = "";
		if (arr.length == 0) {
			return "";
		}
		
		str += String.format(prefix + arr[0], 1);
		for (int i = 1; i < arr.length; i++) {
			str += String.format(sep + prefix + arr[i], (i + 1));
		}
		return str;
	}

	// GETTERS
	/**
	 * @param question - Question to show using System.out
	 * @param minLen - min length of String
	 * @param maxLen - max length of String
	 * @return Response given by the scanner meeting the criteria.
	 */
	public static String getString(String question, int minLen, int maxLen) {
		String str;
		while (true) {
			System.out.print(question);
			str = sc.nextLine();
			
			if (str.length() < minLen) {
				System.out.println("La longitud mínima es de " + minLen + " caracteres\n");
			}
			else if (str.length() > maxLen) {
				System.out.println("La longitud máxima es de " + maxLen + " caracteres.\n");
			}
			else {
				return str;
			}
		}
	}
	
	public static String getString(String question) {
		System.out.print(question);
		return sc.nextLine();
	}

	/**
	 * @param question - Question to show using System.out.print
	 * @return Integer given by Scanner
	 */
	public static int getInt(String question) {
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
	public static int getNatural(String question) {
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
