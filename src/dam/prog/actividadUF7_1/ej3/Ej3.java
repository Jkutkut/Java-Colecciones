package dam.prog.actividadUF7_1.ej3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Ej3 {
	
	private static HashMap<Integer, String> jugadoresHM;
	private static TreeMap<Integer, String> jugadoresTM;
	
	public static void main(String[] args) {
		jugadoresHM = new HashMap<Integer, String>();
		jugadoresTM = new TreeMap<Integer, String>();
		
		rellenaMapas();
		
		simulaSalidaCampo();
		
		simulaFalta();
		
		simulaFinalPartido();
		
		if (jugadoresHM.size() == 0) {
			System.out.println("Fin partido HashSet");
		}
		if (jugadoresTM.size() == 0) {
			System.out.println("Fin partido TreeSet");
		}
	}

	private static void rellenaMapas() {
		String[] jugadores = {
			"Casillas",		"Pique",		"Puyol",
			"Iniesta",		"Villa",		"Villa3",
			"Xavi",			"Capdevila",	"Ramos",
			"Pedrito",		"Busquets",		"Garcia"
		};
		
		for (int i = 0; i < jugadores.length; i++) {
			jugadoresHM.put(i, jugadores[i]);
			jugadoresTM.put(i, jugadores[i]);
		}
	}
	
	private static void simulaSalidaCampo() {
		System.out.println("Simulando salida al campo con HashMap");
		for (Integer clave : jugadoresHM.keySet()) {
			System.out.printf("Con el número %2d ... %s\n", clave, jugadoresHM.get(clave));
		}
		System.out.println("\nSimulando salida al campo con TreeMap");
		for (Integer clave : jugadoresTM.keySet()) {
			System.out.printf("Con el número %2d ... %s\n", clave, jugadoresTM.get(clave));
		}
		System.out.println();
	}
	
	private static void simulaFalta() {
		System.out.println("Simulador de faltas");
		Scanner sc = new Scanner(System.in);
		boolean faltaLaFalta = true;
		int dorsal;
		while (faltaLaFalta) {
			System.out.print("Introduce el número del jugador: ");
			try {
				dorsal = Integer.parseInt(sc.nextLine());
			}
			catch (Exception e) {
				System.out.println("Introduce en número correcto pls :D");
				continue;
			}
			
			if (jugadoresHM.containsKey(dorsal)) {
				System.out.printf(
						"El jugador %s con el dorsal %d ha sido expulsado del campo HashSet.\n",
						jugadoresHM.get(dorsal), dorsal
				);
				jugadoresHM.remove(dorsal);
//				faltaLaFalta = false;
//			}
//			if (jugadoresTM.containsKey(dorsal)) {	
				System.out.printf(
						"El jugador %s con el dorsal %d ha sido expulsado del campo TreeSet.\n",
						jugadoresTM.get(dorsal), dorsal
				);
				jugadoresTM.remove(dorsal);
				
				faltaLaFalta = false;
			}
			else {
				System.out.println("No hay ningún jugador con ese dorsal");
			}
			
		}
		System.out.println();
		sc.close();
	}
	
	private static void simulaFinalPartido() {
		System.out.println("Simulando fin partido");
		jugadoresHM.clear();
		jugadoresTM.clear();
	}
}
