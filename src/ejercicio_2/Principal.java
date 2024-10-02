package ejercicio_2;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void menu(ColaCircular<Integer> colaNumeros, Scanner input, int longitud) {
		boolean verdad = true;
		while (verdad) {
			System.out.println("---MENU---");
			System.out.println("1. Insertar elemento");
			System.out.println("2. Eliminar elemento");
			System.out.println("3. Mostrar elementos");
			System.out.println("4. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					if (!colaNumeros.isFull()) {
						colaNumeros.add(Helper.validarEntero(input, "Ingrese un numero: "));
					} else {
						System.out.println("Cola llena");
					}
					break;
				case 2:
					if (!colaNumeros.isEmpty()) {
						int numero = colaNumeros.remove();
						System.out.println("Se elimino con exito el numero: " + numero);
					} else {
						System.out.println("Cola vacia");
					}
					break;
				case 3:
					mostrar(colaNumeros, longitud);
					break;
				case 4:
					System.out.println("---FIN DEL PROGRAMA---");
					verdad = false;
					break;
				default:
					System.out.println("Opcion fuera de rango");
					break;
			}
		}
	}
	
	public static void mostrar(ColaCircular<Integer> colaNumeros, int longitud) {
		ColaCircular<Integer> colaAuxiliar = new ColaCircular<Integer>(longitud);
		while (!colaNumeros.isEmpty()) {
			int numero = colaNumeros.remove();
			colaAuxiliar.add(numero);
			System.out.println(numero);
		}
		while (!colaAuxiliar.isEmpty()) {
			colaNumeros.add(colaAuxiliar.remove());
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int longitud = Helper.validarEntero(input, "Ingrese el tamaño de la Cola: ");
		ColaCircular<Integer> colaNumeros = new ColaCircular<Integer>(longitud);
		menu(colaNumeros, input, longitud);
	}
}
