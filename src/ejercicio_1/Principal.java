package ejercicio_1;

import java.util.Scanner;

public class Principal {
	
	public static void menu(Scanner input, ColaGenerica<Cliente> colaCliente) {
		boolean verdadero = true;
		while (verdadero) {
			System.out.println("1. Cargar clientes en la cola");
			System.out.println("2. Mostrar los datos de los clientes");
			System.out.println("3. Mostrar cantidad de clientes segun su apellido");
			System.out.println("4. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
			case 1:
				cargarCliente(colaCliente, input);
				break;
			case 2:
				mostrarClientes(colaCliente);
				break;
			case 3:
				cantidadClientesSegunApellid(colaCliente, input);
				break;
			case 4:
				verdadero = false;
				System.out.println("---FIN DEL PROGRAMA---");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}
	}
	
	public static void cargarCliente(ColaGenerica<Cliente> colaClientes, Scanner input) {
		while (!colaClientes.isFull()) {
			colaClientes.add(new Cliente(Helper.validarEntero(input, "Ingrese el codigo de cliente: "), 
											Helper.leerCadena(input, "Ingrese el apellido y nombre del cliente: "),
											Helper.leerCadena(input, "Ingrese el email del cliente: ")));
		}
	}
	
	public static void mostrarClientes(ColaGenerica<Cliente> colaCliente) {
		ColaGenerica<Cliente> colaAuxiliar = new ColaGenerica<Cliente>();
		while (!colaCliente.isEmpty()) {
			Cliente cliente = colaCliente.remove();
			colaAuxiliar.add(cliente);
			System.out.println(cliente);
		}
		while (!colaAuxiliar.isEmpty()) {
			colaCliente.add(colaAuxiliar.remove());
		}
	}
	
	public static void cantidadClientesSegunApellid(ColaGenerica<Cliente> colaClientes, Scanner input) {
		ColaGenerica<Cliente> colaAuxiliar = new ColaGenerica<Cliente>();
		int contador = 0;
		String apellido = Helper.leerCadena(input, "Ingrese el apellido que busca: ");
		while (!colaClientes.isEmpty()) {
			Cliente cliente = colaClientes.remove();
			if (cliente.getApellidoYNombreCliente().contains(apellido)) {
				contador++;
			}
			colaAuxiliar.add(cliente);
		}
		while (!colaAuxiliar.isEmpty()) {
			colaClientes.add(colaAuxiliar.remove());
		}
		System.out.println("Cantidad de personas con el mismo apellido: " + contador);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ColaGenerica<Cliente> colaCliente = new ColaGenerica<Cliente>();
		menu(input, colaCliente);
	}
}
