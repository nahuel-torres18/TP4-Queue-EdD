package ejercicio_1;

public class ColaGenerica<ELEMENT> {
	private int head;
	private int tail;
	private int cuenta;
	private ELEMENT[] contenedor;
	
	public ColaGenerica() {
		this(5);
	}
	
	public ColaGenerica(int dimension) {
		this.contenedor = (ELEMENT[]) new Object[dimension];
		this.head = 0;
		this.tail = 0;
		this.cuenta = 0;
	}
	
	public int next(int posicion) {
		if (++posicion >= this.contenedor.length) {
			posicion = 0;
		}
		return posicion;
	}
	
	public boolean add(ELEMENT elemento) {
		if (isFull()) {
			throw new IllegalStateException("Cola llena");
		}
		this.contenedor[this.tail] = elemento;
		this.tail = this.next(this.tail);
		++this.cuenta;
		return true;
	}
	
	public boolean offer(ELEMENT elemento) {
		if (this.size() >= this.contenedor.length) {
			return false;
		}
		this.contenedor[this.tail] = elemento;
		this.tail = this.next(this.tail);
		++this.cuenta;
		return true;
	}
	
	public ELEMENT remove() {
		if (isEmpty()) {
			throw new IllegalStateException("Cola vacia");
		}
		ELEMENT elemento = this.contenedor[this.head];
		this.head = this.next(this.head);
		--this.cuenta;
		return elemento;
	}
	
	public ELEMENT pool() {
		if (this.size() <= 0) {
			return null;
		}
		ELEMENT elemento = this.contenedor[this.head];
		this.head = next(this.head);
		--this.cuenta;
		return elemento;
	}
	
	public ELEMENT element() {
		if (isEmpty()) {
			throw new IllegalStateException("Cola vacia");
		}
		return this.contenedor[this.head];
	}
	
	public ELEMENT peek() {
		if (this.size() <= 0) {
			return null;
		}
		return this.contenedor[this.head];
	}
	
	public boolean isEmpty() {
		return this.cuenta <= 0;
	}
	
	public boolean isFull() {
		return this.cuenta >= this.contenedor.length;
	}
	
	public int size() {
		return this.cuenta;
	}
}
