package ejercicio_2;

public class ColaCircular<ELEMENT> {
	private ELEMENT[] contenedor;
	private int head;
	private int tail;
	
	public ColaCircular() {
		this(5);
	}
	
	public ColaCircular(int longitud) {
		this.contenedor = (ELEMENT[]) new Object[longitud];
		this.head = 0;
		this.tail = 0;
	}
	
	public int next(int posicion) {
		++posicion;
		if (posicion >= this.contenedor.length) {
			posicion = 0;
		}
		return posicion;
	}
	
	public boolean add(ELEMENT elemento) {
		if (isFull()) {
			throw new IllegalStateException("Cola llena");
		}
		this.contenedor[this.tail] = elemento;
		this.tail = this.next(tail);
		return true;
	}
	
	public boolean offer(ELEMENT elemento) {
		if (isFull()) {
			return false;
		}
		this.contenedor[this.tail] = elemento;
		this.tail = next(this.tail);
		return true;
	}
	
	public ELEMENT remove() {
		if (isEmpty()) {
			throw new IllegalStateException("Cola vacia");
		}
		ELEMENT elemento = this.contenedor[this.head];
		this.head = this.next(head);
		return elemento;
	}
	
	public ELEMENT pool() {
		if (isEmpty()) {
			return null;
		}
		ELEMENT elemento = this.contenedor[this.head];
		this.head = next(this.head);
		return elemento;
	}
	
	public ELEMENT element() {
		if (isEmpty()) {
			throw new IllegalStateException("Cola vacia");
		}
		return this.contenedor[this.head];
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Cola vacia");
		}
		return this.contenedor[this.head];
	}
	
	public boolean isFull() {
		return next(this.tail) == this.head;
	}
	
	public boolean isEmpty() {
		return this.head == this.tail;
	}
	
	public int size() {
		return this.tail;
	}
	
}
