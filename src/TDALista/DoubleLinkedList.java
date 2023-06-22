package TDALista;

import java.util.Iterator;
import excepciones.BoundaryViolationException;
import excepciones.EmptyListException;
import excepciones.InvalidPositionException;

/**
 *Clase que define una lista doblemente enlazada con elementos de tipo genérico e implementa la interfaz PositionList
 * @author Lucas Solmoni y Victoria Legakis
 *
 * @param <E> Tipo de los elementos de la clase
 */
public class DoubleLinkedList<E> implements PositionList<E> {
	
	protected int size;
	protected DNodo<E> head;
	protected DNodo<E> rabo;
/**
 * Constructor de la lista doblemente enlazada
 */
	public DoubleLinkedList() {
		head = new DNodo<>(null);
		rabo = new DNodo<>(null);
		head.setAnterior(null);
		head.setSiguiente(rabo);
		rabo.setAnterior(head);
		rabo.setSiguiente(null);
		size = 0;

	}

	@Override
	public Position<E> first() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Lista vacia");
		return head.getSiguiente();
	}

	@Override
	public Position<E> last() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Lista vacia");
		return rabo.getAnterior();
	}

	@Override
	public Position<E> next(Position<E> sig) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> nodo = checkPosition(sig);
		if (nodo.getSiguiente() == rabo) {
			throw new BoundaryViolationException("La posicion corresponde al utlimo elemento de la lista.");
		}
		return nodo.getSiguiente();
	}

	@Override
	public Position<E> prev(Position<E> sig) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> nodo = checkPosition(sig);
		if (nodo.getAnterior() == head) {
			throw new BoundaryViolationException("La posicion corresponde al utlimo elemento de la lista.");
		}
		return nodo.getAnterior();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
/**
 * Chequea si la posición es correcta en la lista
 * @param p Posición a chequear
 * @return Un nodo 
 * @throws InvalidPositionException si la posición es invalida
 */
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
		try {
			if (p == null)
				throw new InvalidPositionException("Posicion nula.");
			if ((p == head) || (p == rabo))
				throw new InvalidPositionException("Posicion invalida.");
			if (p.element() == null)
				throw new InvalidPositionException("Posicion eliminada previamente.");
			DNodo<E> n = (DNodo<E>) p;
			if ((n.getAnterior() == null) || (n.getSiguiente() == null))
				throw new InvalidPositionException("La posicion no tiene anterior o siguiente");
			return n;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("Posicion no es de tipo Nodo E");
		}
	}

	@Override
	public E set(Position<E> p, E elm) throws InvalidPositionException {
		DNodo<E> ax = checkPosition(p);
		if (isEmpty()) {
			throw new InvalidPositionException("Lista vacia.");
		}
		E e = ax.element();
		ax.setElement(elm);
		return e;
	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> nodo = checkPosition(p);
		nodo.getAnterior().setSiguiente(nodo.getSiguiente());
		nodo.getSiguiente().setAnterior(nodo.getAnterior());

		size--;
		E toReturn = nodo.element();
		nodo.setElement(null);
		nodo.setAnterior(null);
		nodo.setSiguiente(null);
		return toReturn;

	}

	@Override
	public void addBefore(Position<E> p, E item) throws InvalidPositionException {
		DNodo<E> nodo = checkPosition(p); // el caso cuando es la head ya esta en checkposition
		if (isEmpty()) {
			throw new InvalidPositionException("Lista vacia.");
		}
		DNodo<E> ax = new DNodo<>(item, nodo.getAnterior(), nodo);
		nodo.getAnterior().setSiguiente(ax);
		nodo.setAnterior(ax);
		size++;
	}

	@Override
	public void addAfter(Position<E> p, E item) throws InvalidPositionException {
		DNodo<E> nodo = checkPosition(p); // el caso cuando es la head ya esta en checkposition
		if (isEmpty()) {
			throw new InvalidPositionException("Lista vacia.");
		}
		DNodo<E> ax = new DNodo<E>(item, nodo, nodo.getSiguiente());
		nodo.setSiguiente(ax);
		ax.getSiguiente().setAnterior(ax);
		size++;
	}

	@Override
	public void addLast(E e) {
		if (isEmpty())
			addFirst(e);
		else {
			try {
				DNodo<E> ult = (DNodo<E>) last();
				DNodo<E> ax = new DNodo(e, ult, rabo);
				ult.setSiguiente(ax);
				rabo.setAnterior(ax);
				size++;
			} catch (EmptyListException e1) {
				e1.printStackTrace();
			}

		}
	}

	@Override
	public void addFirst(E e) {
		DNodo<E> ax;
		ax = new DNodo<>(e, head, head.getSiguiente());
		head.getSiguiente().setAnterior(ax);
		head.setSiguiente(ax);
		size++;
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> toReturn = new DoubleLinkedList<>();
		DNodo<E> nodo = head.getSiguiente();
		while (nodo != rabo) {
			toReturn.addLast(nodo);
			nodo = nodo.getSiguiente();
		}
		return toReturn;

	}

	@Override
	public Iterator<E> iterator() {
		ElementIterator ax = new ElementIterator<>(this);
		return ax;
	}
  /**
   * Clase interna de la ListaDoblementeEnlazada, que implementa la interfaz IPosition y posee un tipo genérico E como parámetro
   * @author Lucas Solmoni y Victoria Legakis
   *
   * @param <E>-Tipo de los elementos
   */
	private class DNodo<E> implements Position<E> {
		private E element;
		private DNodo<E> siguiente;
		private DNodo<E> anterior;

		public DNodo(E element, DNodo<E> anterior, DNodo<E> siguiente) {
			this.element = element;
			this.anterior = anterior;
			this.siguiente = siguiente;
		}
        /**
         * Crea un DNodo a partir de un elemento 
         * @param element que contiene el DNodo
         */
		public DNodo(E element) {
			this(element, null, null);
		}
       /**
        * Crea un DNodo vacío
        */
		public DNodo() {
			this(null, null, null);
		}

		@Override
		public E element() {
			return element;
		}
        /**
         * Establece el elemento del nodo
         * @param element que va a contener el DNodo
         */
		public void setElement(E element) {
			this.element = element;
		}
      /**
       * Devuelve el nodo siguiente
       * @return el nodo siguiente
       */
		public DNodo<E> getSiguiente() {
			return siguiente;
		}
        /**
         * Establece el nodo siguiente
         * @param siguiente-Es un nodo que lo estableceremos como el nodo siguiente
         */
		public void setSiguiente(DNodo<E> siguiente) {
			this.siguiente = siguiente;
		}
        /**
         * Devuelve el nodo anterior
         * @return el nodo anterior
         */
		public DNodo<E> getAnterior() {
			return anterior;
		}
        /**
         * Establece el nodo anterior
         * @param anterior-Es un nodo que lo estableceremos como el nodo anterior
         */
		public void setAnterior(DNodo<E> anterior) {
			this.anterior = anterior;
		}
	}
}
