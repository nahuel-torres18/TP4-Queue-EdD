package ejercicio_6;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void agregarClientes(ColaGenerica<Cliente> colaClientes, Scanner input) {
		while (!colaClientes.isFull()) {
			colaClientes.add(new Cliente(Helper.validarEntero(input, "Ingrese el DNI: "),
							 Helper.leerCadena(input, "Ingrese el apellido y nombre: "),
							 Helper.validarEntero(input, "Ingrese la edad: ")));
		}
	}
	
	public static void mostrarClientes(ColaGenerica<Cliente> colaClientes, int longitud) {
		ColaGenerica<Cliente> colaAuxiliar = new ColaGenerica<Cliente>(longitud);
		while (!colaClientes.isEmpty()) {
			Cliente cliente = colaClientes.remove();
			colaAuxiliar.add(cliente);
			System.out.println(cliente);
		}
		while (!colaAuxiliar.isEmpty()) {
			colaClientes.add(colaAuxiliar.remove());
		}
	}
	
	public static void tramiteARealizar(ColaGenerica<Cliente> colaCliente, ColaGenerica<Cliente> colaCajas, ColaGenerica<Cliente> colaCuentas, Scanner input) {
		while (!colaCliente.isEmpty()) {
			System.out.println("---MENU DE OPCIONES---");
			System.out.println("1. Cuentas");
			System.out.println("2. Cajas");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					colaCuentas.add(colaCliente.remove());
					break;
				case 2:
					colaCajas.add(colaCliente.remove());
					break;
				default:
					System.out.println("Opcion fuera de rango");
					break;
			}
		}
		System.out.println("---LA COLA CLIENTES A SIDO VACIADA TOTALMENTE---");
	}
	
	public static void clientesAtendidos(ColaGenerica<Cliente> colaCajas, ColaGenerica<Cliente> colaCuentas, int cantidad) {
		System.out.println("Cantidad de clientes atendidos en el sector 'CAJAS': " + colaCajas.size());
		System.out.println("Cantidad de clientes atendidos en el sector 'CUENTAS': " + colaCuentas.size());
		ColaGenerica<Cliente> colaAuxiliar = new ColaGenerica<Cliente>(cantidad);
		System.out.println("CLIENTES MENORES DE 40 AÑOS");
		while (!colaCajas.isEmpty()) {
			Cliente cliente = colaCajas.remove();
			if (cliente.getEdadCliente() < 40) {
				System.out.println(cliente);
				colaAuxiliar.add(cliente);
			} else {
				colaAuxiliar.add(cliente);
			}
		}
		while (!colaAuxiliar.isEmpty()) {
			colaCajas.add(colaAuxiliar.remove());
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int cantidad = Helper.validarEntero(input, "Ingrese la cantidad de clientes a atender: ");
		ColaGenerica<Cliente> colaClientes = new ColaGenerica<Cliente>(cantidad);
		ColaGenerica<Cliente> colaCajas = new ColaGenerica<Cliente>(cantidad);
		ColaGenerica<Cliente> colaCuentas = new ColaGenerica<Cliente>(cantidad);
		agregarClientes(colaClientes, input);
		mostrarClientes(colaClientes, cantidad);
		tramiteARealizar(colaClientes, colaCajas, colaCuentas, input);
		clientesAtendidos(colaCajas, colaCuentas, cantidad);
	}
}