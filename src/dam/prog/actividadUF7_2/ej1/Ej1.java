package dam.prog.actividadUF7_2.ej1;

import java.util.ArrayList;

public class Ej1 {
	public static void main(String[] args) {
		ArrayList<String> listaMarcasCoches = new ArrayList<String>();
		
		System.out.println("El tamaño de la lista es " + listaMarcasCoches.size());

		System.out.println("Añadiendo elementos");
		listaMarcasCoches.add("Audi");
		listaMarcasCoches.add("Porche");
		listaMarcasCoches.add("Aston Martin");
		listaMarcasCoches.add("Ferrari");
		listaMarcasCoches.add("Jaguar");
		listaMarcasCoches.add("Mercedes");
		
		System.out.println("El tamaño de la lista es " + listaMarcasCoches.size());
		
		System.out.println("Los elementos de la lista son:");
		for (String s : listaMarcasCoches)
			System.out.println(s);
		
		System.out.println("Borrando Jaguar y el elemento en la mitad de la lista");
		listaMarcasCoches.remove("Jaguar");
		listaMarcasCoches.remove(listaMarcasCoches.size() / 2);
		
		System.out.println("El tamaño de la lista es " + listaMarcasCoches.size());
		
		System.out.println("Los elementos de la lista son:");
		for (String s : listaMarcasCoches)
			System.out.println(s);
	}
}
