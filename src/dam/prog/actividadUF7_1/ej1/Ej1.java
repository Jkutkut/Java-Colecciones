package dam.prog.actividadUF7_1.ej1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej1 {
	
	private static final int FILES = 3;
	
	private static ArrayList<Integer> arr;
	
	public static void main(String[] args) {
		arr = new ArrayList<Integer>();
		
		for (int i = 1; i <= FILES; i++) {
			appendFile("fichero" + i);
		}
		
		storeInFile("ficheroResultante");
	}

	private static void storeInFile(String fileName) {
		String str = "";
		for (Integer nb : arr) {
			str += nb + "\n";
		}
		
		try {
			Files.write(Paths.get("src/dam/prog/actividadUF7/ej1/" + fileName), str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void appendFile(String fileName) {
		File f = new File("src/dam/prog/actividadUF7/ej1/" + fileName);
		Scanner sc;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		while (sc.hasNext())
		{
			try {
				appendNumber(Integer.parseInt(sc.nextLine()));
			}
			catch (Exception e) {
				e.printStackTrace();
				sc.close();
				return;
			}
		}
		sc.close();
	}

	private static void appendNumber(int nb) {
		boolean done = false;
		for (int i = 0; i < arr.size() && !done; i++) {
			if (arr.get(i) >= nb) {
				arr.add(i, nb);
				done = true;
			}
		}
	}
}
