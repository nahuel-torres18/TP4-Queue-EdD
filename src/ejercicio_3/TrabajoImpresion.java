package ejercicio_3;

public class TrabajoImpresion {
	private int codTrabajo;
	private String nombTrabajo;
	private int cantPagTrabajo;
	
	public TrabajoImpresion() {
		
	}
	
	public TrabajoImpresion(int codTRabajo, String nombTrabajo, int cantPagTrabajo) {
		this.codTrabajo = codTRabajo;
		this.nombTrabajo = nombTrabajo;
		this.cantPagTrabajo = cantPagTrabajo;
	}

	public int getCodTrabajo() {
		return codTrabajo;
	}

	public void setCodTrabajo(int codTrabajo) {
		this.codTrabajo = codTrabajo;
	}

	public String getNombTrabajo() {
		return nombTrabajo;
	}

	public void setNombTrabajo(String nombTrabajo) {
		this.nombTrabajo = nombTrabajo;
	}

	public int getCantPagTrabajo() {
		return cantPagTrabajo;
	}

	public void setCantPagTrabajo(int cantPagTrabajo) {
		this.cantPagTrabajo = cantPagTrabajo;
	}

	@Override
	public String toString() {
		return "TrabajoImpresion [codTrabajo=" + codTrabajo + ", nombTrabajo=" + nombTrabajo + ", cantPagTrabajo="
				+ cantPagTrabajo + "]";
	}
}
