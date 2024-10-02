package ejercicio_4;

public class ColaGenerica<ELEMENT> {
	private ELEMENT[] contenedor;
	private int contador;
	private int tail;
	private int head;
	
	public ColaGenerica() {
		this(5);
	}
	
	public ColaGenerica(int longitud) {
		this.contenedor = (ELEMENT[]) new Object[longitud];
		this.contador = 0;
		this.head = 0;
		this.tail = 0;
	}
	
	public boolean isEmpty() {
		return this.contador <= 0;
	}
	
	public boolean isFull() {
		return this.contador >= this.contenedor.length;
	}
	
	public int next(int posicion) {
		++posicion;
		if (posicion > this.contenedor.length) {
			posicion = 0;
		}
		return posicion;
	}
	
	public boolean add(ELEMENT elemento) {
		if (isFull()) {
			throw new IllegalStateException("Cola llena");
		}
		this.contenedor[this.tail] = elemento;
		this.tail = next(this.tail);
		++this.contador;
		return true;
	}
	
	public boolean offer(ELEMENT elemento) {
		if (this.size() >= this.contenedor.length) {
			return false;
		}
		this.contenedor[this.tail] = elemento;
		this.tail = next(this.tail);
		++this.contador;
		return true;
	}
	
	public ELEMENT remove() {
		if (isEmpty()) {
			throw new IllegalStateException("Cola vacia");
		}
		ELEMENT elemento = this.contenedor[this.head];
		this.head = next(this.head);
		--this.contador;
		return elemento;
	}
	
	public ELEMENT poll() {
		if (this.size() <= 0) {
			return null;
		}
		ELEMENT elemento = this.contenedor[this.head];
		this.head = next(this.head);
		--this.contador;
		return elemento;
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Cola vacia");
		}
		return this.contenedor[this.head];
	}
	
	public ELEMENT element() {
		if (this.size() <= 0) {
			throw new IllegalStateException("Cola vacia");
		}
		return this.contenedor[this.head];
	}
	
	public int size() {
		return this.contador;
	}
}
