package ejercicio_3;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void cargarCola(ColaGenerica<TrabajoImpresion> colaTrabajosImpresion, Scanner input) {
		colaTrabajosImpresion.add(new TrabajoImpresion(Helper.validarEntero(input, "Ingrese el codigo del trabajo: "),
										  Helper.leerCadena(input, "Ingrese el nombre del trabajo: "),
										  Helper.validarEntero(input, "Ingrese la cantidad de paginas: ")));
	}
	
	public static void mostrarElementos(ColaGenerica<TrabajoImpresion> colaTrabajosImpresion, int longitud) {
		ColaGenerica<TrabajoImpresion> colaAuxiliar = new ColaGenerica<TrabajoImpresion>(longitud);
		while (!colaTrabajosImpresion.isEmpty()) {
			TrabajoImpresion trabajoImpresion = colaTrabajosImpresion.remove();
			System.out.println(trabajoImpresion);
			colaAuxiliar.add(trabajoImpresion);
		}
		while (!colaAuxiliar.isEmpty()) {
			colaTrabajosImpresion.add(colaAuxiliar.remove());
		}
	}
	
	public static void mostrarCantidadTrabajos(ColaGenerica<TrabajoImpresion> colaTrabajosImpresion, Scanner input) {
		int cantidadPaginas = Helper.validarEntero(input, "Ingrese una cantidad de hojas: ");
		int contador = 0;
		while (!colaTrabajosImpresion.isEmpty()) {
			TrabajoImpresion auxiliar = colaTrabajosImpresion.remove();
			if (auxiliar.getCantPagTrabajo() >= cantidadPaginas) {
				contador++;
			}
		}
		System.out.println("La cantidad de trabajos con paginas mayores o iguales a " + cantidadPaginas + " que se imprimieron son: " + contador);
	}
	
	public static void menu(ColaGenerica<TrabajoImpresion> colaTrabajosImpresion, Scanner input, int longitud) {
		boolean verdad = true;
		while (verdad) {
			System.out.println("---MENU---");
			System.out.println("1. Insertar elemento");
			System.out.println("2. Eliminar elemento");
			System.out.println("3. Mostrar elementos");
			System.out.println("4. Finalizar el programa");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					if (!colaTrabajosImpresion.isFull()) {
						cargarCola(colaTrabajosImpresion, input);
					} else {
						System.out.println("---COLA LLENA---");
					}
					break;
				case 2:
					if (!colaTrabajosImpresion.isEmpty()) {
						System.out.println("SE ELIMINO EL OBJETO: " + colaTrabajosImpresion.remove());
					} else {
						System.out.println("COLA VACIA");
					}
					break;
				case 3:
					mostrarElementos(colaTrabajosImpresion, opcion);
					break;
				case 4:
					mostrarCantidadTrabajos(colaTrabajosImpresion, input);
					verdad = false;
					break;
				default:
					System.out.println("OPCION FUERA DE RANGO");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int longitud = Helper.validarEntero(input, "Ingrese la longitud de Queue: ");
		ColaGenerica<TrabajoImpresion> colaTrabajosImpresion = new ColaGenerica<TrabajoImpresion>(longitud);
		menu(colaTrabajosImpresion, input, longitud);
	}
}
