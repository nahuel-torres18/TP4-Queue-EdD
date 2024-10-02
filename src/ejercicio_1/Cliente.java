package ejercicio_1;

public class Cliente {
	private int codigoCliente;
	private String apellidoYNombreCliente;
	private String emailCliente;
	
	public Cliente() {
		
	}
	
	public Cliente(int codigoCliente, String apellidoYNombreCliente, String emailCliente) {
		this.codigoCliente = codigoCliente;
		this.apellidoYNombreCliente = apellidoYNombreCliente;
		this.emailCliente = emailCliente;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getApellidoYNombreCliente() {
		return apellidoYNombreCliente;
	}

	public void setApellidoYNombreCliente(String apellidoYNombreCliente) {
		this.apellidoYNombreCliente = apellidoYNombreCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ", apellidoYNombreCliente=" + apellidoYNombreCliente
				+ ", emailCliente=" + emailCliente + "]";
	}
}
