package ejercicio_5;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void cargarCola(ColaGenerica<Integer> colaNumeros, Scanner input) {
		while (!colaNumeros.isFull()) {
			colaNumeros.add(Helper.validarEntero(input, "Ingrese un numero: "));
		}
	}
	
	//Este método vaciara las colas de numeros 1 y 2 para unirlas. No se las podra volver a mostrar.
	public static void unionColas(ColaGenerica<Integer> colaNumeros1, ColaGenerica<Integer> colaNumeros2, ColaGenerica<Integer> unionColas) {
		while (!colaNumeros1.isEmpty() || !colaNumeros2.isEmpty()) {
			if (!colaNumeros1.isEmpty()) {
				unionColas.add(colaNumeros1.remove());
			}
			if (!colaNumeros2.isEmpty()) {
				unionColas.add(colaNumeros2.remove());
			}
		}
	}
	
	public static void sumarNumeros(ColaGenerica<Integer> unionColas) {
		int suma = 0;
		while (!unionColas.isEmpty()) {
			suma += unionColas.remove();
		}
		System.out.println("Suma de los elementos de la tercer cola: "+suma);
	}
	
	public static void mostrarUnion(ColaGenerica<Integer> unionColas, int longitud) {
		ColaGenerica<Integer> colaAuxiliar = new ColaGenerica<Integer>(longitud);
		while (!unionColas.isEmpty()) {
			Integer numero = unionColas.remove();
			colaAuxiliar.add(numero);
			System.out.print(numero + " ");
		}
		System.out.println();
		while (!colaAuxiliar.isEmpty()) {
			unionColas.add(colaAuxiliar.remove());
		}
	}
	
	public static void mostrar(ColaGenerica<Integer> colaNumeros) {
		ColaGenerica<Integer> colaAuxiliar = new ColaGenerica<Integer>();
		while (!colaNumeros.isEmpty()) {
			Integer numero = colaNumeros.remove();
			colaAuxiliar.add(numero);
			System.out.print(numero + " ");
		}
		System.out.println();
		while (!colaAuxiliar.isEmpty()) {
			colaNumeros.add(colaAuxiliar.remove());
		}
	}
	
	public static void operaciones(ColaGenerica<Integer> colaNumeros1, ColaGenerica<Integer> colaNumeros2, Scanner input) {
		cargarCola(colaNumeros1, input);
		cargarCola(colaNumeros2, input);
		System.out.println("Numeros de la cola 1");
		mostrar(colaNumeros1);
		System.out.println("Numeros de la cola 2");
		mostrar(colaNumeros2);
		
		int longitud = colaNumeros1.size()+colaNumeros2.size();
		ColaGenerica<Integer> unionColas = new ColaGenerica<Integer>(longitud);
		unionColas(colaNumeros1, colaNumeros2, unionColas);
		System.out.println("Cola union de numeros");
		mostrarUnion(unionColas, longitud);
		sumarNumeros(unionColas);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ColaGenerica<Integer> colaNumeros1 = new ColaGenerica<>();
		ColaGenerica<Integer> colaNumeros2 = new ColaGenerica<>();
		operaciones(colaNumeros1, colaNumeros2, input);
	}
}
