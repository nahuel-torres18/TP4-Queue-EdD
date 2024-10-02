package ejercicio_0;

public class Cola {
	private int[] contenedor;
	private int head;
	private int tail;
	private static final int dimension = 10;
	
	public Cola() {
		this(dimension);
	}
	
	public Cola(int dimension) {
		this.contenedor = new int[dimension];
		this.head = 0;
		this.tail = 0;
	}
}
