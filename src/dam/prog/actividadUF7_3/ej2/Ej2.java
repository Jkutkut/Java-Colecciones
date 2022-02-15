package dam.prog.actividadUF7_3.ej2;

import java.io.File;
import java.io.FileNotFoundException;
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
		try {
			sc = new Scanner(new File("src/dam/prog/actividadUF7_3/ej2/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
//		sc = new Scanner(System.in);
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
			System.out.println();
			switch (selected) {
			case 1:
				addSong();
				System.out.printf("Canción añadida. Canciones en playlist: %d\n", playlist.size());
				break;
			case 2:
				removeSong();
				break;
			case 3:
				showPlaylist();
				break;
			case 4:
				playSong(getIntInRange("Posición de la canción: ", 1, playlist.size()));
				break;
			case 5:
				playAll();
				break;
			case 6:
				showTotalDuration();
				break;
			case 7:
				running = false;
				break;
			default:
				throw new InvalidDataException("Ups, esto no tendría que pasar.");
			}
		}
	}

	private static void addSong() {
		String title, creator;
		int duration;

		System.out.println("Introduce los datos de la canción:");
		title = getString("- Título: ");
		creator = getString("- Artista/grupo: ");
		duration = getIntInRange("- Duración (s): ", Cancion.MIN_DURATION, Cancion.MAX_DURATION);
		System.out.println();
		playlist.add(new Cancion(title, creator, duration));
	}

	private static void removeSong() {
		String title, creator;
		
		System.out.println("Introduce los datos de la canción:");
		title = getString("- Título: ");
		creator = getString("- Artista/grupo: ");
		
		boolean found = false;
		Cancion c;
		for (int i = 0; i < playlist.size() && !found; i++) {
			c = playlist.get(i);
			if (c.getTitle().equalsIgnoreCase(title) &&
				c.getCreator().equalsIgnoreCase(creator)) {
				found = true;
				playlist.remove(i);
			}
		}
		if (found) {
			System.out.println("Canción eliminada");
		}
		else {
			System.out.println("Canción no encontrada. Seguro que lo has escrito bien?");
		}
		System.out.println();
	}

	private static void showPlaylist() {
		for (int i = 0; i < playlist.size(); i++) {
			System.out.printf("%d %s\n", i + 1, playlist.get(i));
		}
		System.out.println();
	}

	private static void playSong(int index) {
		if (index < 1 || index > playlist.size()) {
			System.out.println("Ese índice no es válido.");
			return;
		}
		System.out.printf("\nSe está reproduciendo %s\n\n", playlist.get(index - 1));
	}

	private static void playAll() {
		if (playlist.size() == 0) {
			System.out.println("No hay canciones que reproducir");
			return;
		}
		System.out.println("Reproduciendo todas las canciones");
		for (int i = 0; i < playlist.size(); i++) {
			System.out.printf("Se está reproduciendo %s\n", playlist.get(i));
		}
		System.out.println();
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

	private static void showTotalDuration() {
		int total = 0;
		for (int i = 0; i < playlist.size(); i++)
			total += playlist.get(i).getDuration();	
		System.out.printf("Duración total de la canción: %ss\n\n", total);
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
			str = getString(question);
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
		String str = sc.nextLine();
		System.out.println(str); // TODO DEBUG
		return str;
	}

	/**
	 * @param question - Question to show using System.out.print
	 * @return Integer given by Scanner
	 */
	public static int getInt(String question) {
		String n;
		while (true) {
			try {
				System.out.print(question);
				n = sc.nextLine();
				System.out.println(n);
				return Integer.parseInt(n);
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
