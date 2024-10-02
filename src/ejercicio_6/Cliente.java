package ejercicio_6;

public class Cliente {
	private int dniCliente;
	private String apellidoYNombreCliente;
	private int edadCliente;
	
	public Cliente() {
		
	}
	
	public Cliente(int dniCliente, String apellidoYNombreCliente, int edadCliente) {
		this.dniCliente = dniCliente;
		this.apellidoYNombreCliente = apellidoYNombreCliente;
		this.edadCliente = edadCliente;
	}

	public int getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getApellidoYNombreCliente() {
		return apellidoYNombreCliente;
	}

	public void setApellidoYNombreCliente(String apellidoYNombreCliente) {
		this.apellidoYNombreCliente = apellidoYNombreCliente;
	}

	public int getEdadCliente() {
		return edadCliente;
	}

	public void setEdadCliente(int edadCliente) {
		this.edadCliente = edadCliente;
	}

	@Override
	public String toString() {
		return "Cliente [dniCliente=" + dniCliente + ", apellidoYNombreCliente=" + apellidoYNombreCliente
				+ ", edadCliente=" + edadCliente + "]";
	}
}