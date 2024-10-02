package ejercicio_6;

public class ColaGenerica<ELEMENT> {
	private ELEMENT[] contenedor;
	private int tail;
	private int head;
	private int count;
	
	public ColaGenerica() {
		this(5);
	}
	
	public ColaGenerica(int longitud) {
		this.contenedor = (ELEMENT[]) new Object[longitud];
		this.tail = 0;
		this.head = 0;
		this.count = 0;
	}
	
	public boolean isEmpty() {
		return this.count <= 0;
	}
	
	public boolean isFull() {
		return this.count >= this.contenedor.length;
	}
	
	public int size() {
		return this.count;
	}
	
	public int next(int posicion) {
		if (++posicion >= this.contenedor.length) {
			posicion = 0;
		}
		return posicion;
	}
	
	public boolean add(ELEMENT elemento) {
		if (this.size() >= this.contenedor.length) {
			throw new IllegalStateException("Cola llena");
		}
		this.contenedor[this.tail] = elemento;
		this.tail = next(this.tail);
		++this.count;
		return true;
	}
	
	public boolean offer(ELEMENT elemento) {
		if (this.size() >= this.contenedor.length) {
			return false;
		}
		this.contenedor[this.tail] = elemento;
		this.tail = next(this.tail);
		++this.count;
		return true;
	}
	
	public ELEMENT remove() {
		if (this.size() <= 0) {
			throw new IllegalStateException("Cola vacia");
		}
		ELEMENT elemento = this.contenedor[this.head];
		this.head = next(this.head);
		--this.count;
		return elemento;
	}
	
	public ELEMENT poll() {
		if (this.size() <= 0) {
			return null;
		}
		ELEMENT elemento = this.contenedor[this.head];
		this.head = next(this.head);
		--this.count;
		return elemento;
	}
	
	public ELEMENT peek() {
		if (this.size() <= 0) {
			return null;
		}
		return this.contenedor[this.head];
	}
	
	public ELEMENT element() {
		if (this.size() <= 0) {
			throw new IllegalStateException("Cola vacia");
		}
		return this.contenedor[this.head];
	}
}
