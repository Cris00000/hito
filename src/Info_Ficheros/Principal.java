package Info_Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		File fichero = new File("preguntas.csv");
		Scanner lector = new Scanner(fichero);
		Scanner lector2 = new Scanner(System.in);
		String respuesta = "";
		double nota = 0;
		
		System.out.println("E X A M E N");
		System.out.println("-----------");
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			Scanner lectorLinea = new Scanner(linea);
			lectorLinea.useDelimiter(";");
			
			String pregunta = lectorLinea.next();
			String opcionA = lectorLinea.next();
			String opcionB = lectorLinea.next();
			String opcionC = lectorLinea.next();
			String opcionD = lectorLinea.next();
			String respuestaCorrecta = lectorLinea.next();
			
			System.out.println(pregunta);
			System.out.println(opcionA);
			System.out.println(opcionB);
			System.out.println(opcionC);
			System.out.println(opcionD);
			respuesta=lector2.nextLine();
			
			if (respuesta.equals(respuestaCorrecta)) {
				nota+=1;
			} else {
				nota-=0.5;
			}
		}
		
		System.out.println("Tu nota es: " + nota);
		if(nota<5) {
			System.out.println("Has suspendido :(");
		} else {
			System.out.println("¡¡¡HAS APROBADO!!! :D");
		}
		
		lector.close();
		
		lector2.close();
	}

}
