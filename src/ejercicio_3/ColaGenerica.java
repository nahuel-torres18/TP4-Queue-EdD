package ejercicio_3;

public class ColaGenerica<ELEMENT> {
	private int contador;
	private int head;
	private int tail;
	private ELEMENT[] contenedor;
	
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
		this.tail = this.next(this.tail);
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
		this.head = this.next(this.head);
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
	
	public ELEMENT element() {
		if (this.size() <= 0) {
			throw new IllegalStateException("Cola vacia");
		}
		return this.contenedor[this.head];
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			return null;
		}
		return this.contenedor[this.head];
	}
	
	public int size() {
		return this.contador;
	}
}
