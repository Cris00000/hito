package POO_Java_Colecciones;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Principal {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("---- HERENCIAS EN JAVA ----");
		System.out.println("Java NO permite multiherencia para evitar la ambigüedad de código y conflictos de nombres y hacer el lenguaje más simple.");
		System.out.println("La única forma de hacer algo así es implementando interfaces.");
		System.out.println("(Pulsa enter para continuar)");
		lector.nextLine();
		System.out.println("En este caso he creado una clase Perro que hereda de una clase Mascota.");
		System.out.println("(Pulsa enter para continuar)");
		lector.nextLine();
		try {
			System.out.println("Creando objetos Mascota y Perro...");
			Mascota mascota = new Mascota("Pipo", 8);
			Perro perro1 = new Perro("Toby", 10, "Chihuahua");
			System.out.println("(Pulsa enter para continuar)");
			lector.nextLine();
			System.out.println("¡Objetos creados! Podemos ver que mascota tiene un nombre y una edad...");
			System.out.println(mascota.toString());
			System.out.println("... y que perro hereda sus variables además de la suya propia que es raza");
			System.out.println(perro1.toString());
			System.out.println("(Pulsa enter para continuar)");
			lector.nextLine();
		} catch (Exception e) {
			System.out.println("Oops, se ha producido un error :(");
		}
		System.out.println("---- SOBRECARGA Y SOBREESCRITURA ----");
		System.out.println("La sobrecarga se produce cuando existen dos métodos con el mismo nombre pero con variables de entrada diferentes.");
		System.out.println("La sobreescritura se produce cuando existen dos métodos con las mismas variables de entrada pero cuyo contenido es diferente.");
		System.out.println("(Pulsa enter para continuar)");
		lector.nextLine();
		try {
			Mascota mascota = new Mascota("Pipo", 8);
			Perro perro1 = new Perro("Toby", 10, "Chihuahua");
			Perro perro2 = new Perro("Toby", 10);
			System.out.println("--- Ejemplo de sobrecarga ---");
			System.out.println("La clase Perro tiene dos constructores. En uno tiene como variables de entrada las variables heredadas de Mascota y la variable raza.");
			System.out.println(perro1.toString());
			System.out.println("El otro constructor tiene como variables de entrada solo las heredadas de Mascota. La variable raza está asignada a un valor por defecto dentro del constructor");
			System.out.println(perro2.toString());
			System.out.println("(Pulsa enter para continuar)");
			lector.nextLine();
			System.out.println("--- Ejemplo de sobreescritura ---");
			System.out.println("La clase Mascota tiene el método hablar()");
			System.out.println(mascota.hablar());
			System.out.println("La clase Perro también tiene el método hablar(), pero su contenido es diferente");
			System.out.println(perro1.hablar());
			System.out.println("(Pulsa enter para continuar)");
			lector.nextLine();
		} catch (Exception e) {
			System.out.println("Oops, se ha producido un error :(");
		}
		
		System.out.println("---- DIFERENCIAS ENTRE PILA, LISTA Y COLA ----");
		System.out.println("Para este ejemplo va a crearse una lista, una pila y una cola de tipo String");
		try {
			Stack<String> pilaEjemplo = new Stack<String>();
			ArrayList<String> listaEjemplo = new ArrayList<String>();
			Queue<String> colaEjemplo = new LinkedList<String>();
			// Añadiendo cosas a la pila
			pilaEjemplo.push("a");
			pilaEjemplo.push("b");
			pilaEjemplo.push("c");
			pilaEjemplo.push("d");
			// Añadiendo cosas a la lista
			listaEjemplo.add("a");
			listaEjemplo.add("b");
			listaEjemplo.add("c");
			listaEjemplo.add("d");
			// Añadiendo cosas a la cola
			colaEjemplo.add("a");
			colaEjemplo.add("b");
			colaEjemplo.add("c");
			colaEjemplo.add("d");
			//------------------------------
			
			System.out.println("Pila: "+pilaEjemplo);
			System.out.println("Lista: "+listaEjemplo);
			System.out.println("Cola: "+colaEjemplo);
			System.out.println("(Pulsa enter para continuar)");
			lector.nextLine();
			System.out.println("Para ver la diferencia, vamos a eliminar un elemento de cada colección");
			pilaEjemplo.pop();
			listaEjemplo.remove(0);
			colaEjemplo.remove();
			System.out.println("De la pila se ha borrado el último elemento");
			System.out.println("Pila: "+pilaEjemplo);
			System.out.println("En la lista hay que especificar la posición en la que está el elemento que vaya a borrarse");
			System.out.println("Lista: "+listaEjemplo);
			System.out.println("De la cola se ha borrado el primer elemento");
			System.out.println("Cola: "+colaEjemplo);
			System.out.println("(Pulsa enter para continuar)");
			lector.nextLine();
		}catch (Exception e) {
			System.out.println("Oops, se ha producido un error :(");
		}
		lector.close();
		System.out.println("Fin del ejercicio");
	}

}
