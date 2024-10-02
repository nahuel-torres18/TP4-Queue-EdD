package ejercicio_4;

import java.util.Scanner;

import ejercicio_1.Helper;
import java.util.Random;

public class Principal {
	
	public static void menu(ColaGenerica<Visitante> colaGeneral, Scanner input, int longitud) {
		ColaGenerica<Visitante> colaCalesita = new ColaGenerica<Visitante>(longitud);
		ColaGenerica<Visitante> colaMontañaRusa = new ColaGenerica<Visitante>(longitud);
		boolean verdad = true;
		while (verdad) {
			System.out.println("---MENU---");
			System.out.println("1. Ingresar visitantes");
			System.out.println("2. Transferir visitantes");
			System.out.println("3. Mostrar a que juegos ingreso cada visitante");
			System.out.println("4. Finalizar");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					ingresarVisitantes(colaGeneral, input);
					break;
				case 2:
					transferirVisitantes(colaGeneral, colaCalesita, colaMontañaRusa, longitud);
					break;
				case 3:
					mostrarVisitantes(colaCalesita, colaMontañaRusa, longitud);
					break;
				case 4:
					System.out.println("Cantidad de visitantes haciendo cola para la calesita: " + colaCalesita.size());
					System.out.println("Cantidad de visitantes haciendo cola para la montaña rusa: " + colaMontañaRusa.size());
					System.out.println("---FIN DEL PROGRAMA---");
					verdad = false;
					break;
				default:
					System.out.println("Opcion fuera de rango");
					break;
			}
		}
	}
	
	public static void ingresarVisitantes(ColaGenerica<Visitante> colaGeneral, Scanner input) {
		while (!colaGeneral.isFull()) {
			colaGeneral.add(new Visitante(Helper.validarEntero(input, "Ingrese su ID: "),
							Helper.leerCadena(input, "Ingrese su apellido y nombre: "),
							Helper.validarEntero(input, "Ingrese su edad: ")));	
		}
	}
	
	public static void transferirVisitantes(ColaGenerica<Visitante> colaGeneral, ColaGenerica<Visitante> colaCalesita, ColaGenerica<Visitante> colaMontañaRusa,int longitud) {
		int contador = 0;
		System.out.println("Visitantes que van ingresando a los juegos");
		while (!colaGeneral.isEmpty() && contador < 5) {
			Visitante visitante = colaGeneral.remove();
			if (visitante.getEdad() >= 4 && visitante.getEdad() <= 12) {
				colaCalesita.add(visitante);
				contador++;
			} else if (visitante.getEdad() > 12) {
				colaMontañaRusa.add(visitante);
				contador++;
			}
			System.out.println(visitante);
		}
	}
	
	public static void mostrarVisitantes(ColaGenerica<Visitante> colaCalesita, ColaGenerica<Visitante> colaMontañaRusa, int longitud) {
		ColaGenerica<Visitante> colaAuxiliar1 = new ColaGenerica<Visitante>(longitud);
		ColaGenerica<Visitante> colaAuxiliar2 = new ColaGenerica<Visitante>(longitud);
		Visitante visitante;
		System.out.println("Visitantes haciendo cola para la calesita");
		while (!colaCalesita.isEmpty()) {
			visitante = colaCalesita.remove();
			colaAuxiliar1.add(visitante);
			System.out.println(visitante);
		}
		System.out.println("Visitantes haciendo cola para la montaña rusa");
		while (!colaMontañaRusa.isEmpty()) {
			visitante = colaMontañaRusa.remove();
			colaAuxiliar2.add(visitante);
			System.out.println(visitante);
		}
		while (!colaAuxiliar1.isEmpty()) {
			colaCalesita.add(colaAuxiliar1.remove());
		}
		while (!colaAuxiliar2.isEmpty()) {
			colaMontañaRusa.add(colaAuxiliar2.remove());
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		int longitud = random.nextInt(10);
		ColaGenerica<Visitante> colaGeneral = new ColaGenerica<Visitante>(longitud);
		menu(colaGeneral, input, longitud);
	}
}
