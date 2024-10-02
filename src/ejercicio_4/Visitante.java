package ejercicio_4;

public class Visitante {
	private int idVisitante;
	private String apellidoYNombreVisitante;
	private int edad;
	
	public Visitante() {
		
	}
	
	public Visitante(int idVisitante, String apellidoYNombreVisitante, int edad) {
		this.idVisitante = idVisitante;
		this.apellidoYNombreVisitante = apellidoYNombreVisitante;
		this.edad = edad;
	}

	public int getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}

	public String getApellidoYNombreVisitante() {
		return apellidoYNombreVisitante;
	}

	public void setApellidoYNombreVisitante(String apellidoYNombreVisitante) {
		this.apellidoYNombreVisitante = apellidoYNombreVisitante;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Visitante [idVisitante=" + idVisitante + ", apellidoYNombreVisitante=" + apellidoYNombreVisitante
				+ ", edad=" + edad + "]";
	}
}
