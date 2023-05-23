package tdasimplementados.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

import excepciones.lista.BoundaryViolationException;
import excepciones.lista.EmptyListException;
import excepciones.lista.InvalidPositionException;
import tdas.tdalista.IPosition;
import tdas.tdalista.IPositionList;

/**
 *  Clase  que define las características del elemento que recorre por una colección
 *  
 * @author Lucas Solmoni y Victoria Legakis 
 * 
 * @param <E> Tipo de los elementos 
 */
public class ElementIterator<E> implements Iterator<E> {
	// Atributos de instancia
	protected IPositionList<E> list;// lista a iterar
	protected IPosition<E> cursor;// Posicion del elemento corriente

	/**
	 * Constructor para el iterador de elementos
	 *
	 * @param l-Es una colección que implementa la interfaz PositionList y la
	 *          vamos a utilizar para inicializar nuestra lista
	 */
	public ElementIterator(IPositionList<E> l) {
		list = l; // guardo la referencia de la lista a iterar
		if (list.isEmpty())
			cursor = null;
		else
			try {
				// Sino la posición corriente es la primera de la lista
				cursor = list.first();
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
	}

	@Override
	public boolean hasNext() {
		// Hay siguiente si el cursor no está más allá de la última posición
		return cursor != null;
	}

	@Override
	public E next() throws NoSuchElementException {
		if (cursor == null) // Si el cursor es null, el cliente no testeó que hasNext fuera true
			throw new NoSuchElementException("Error: No hay siguiente");
		E elem = cursor.element(); // Salvo el elemento corriente
		try {
			// Avanzo a la siguiente posición
			cursor = (cursor == list.last()) ? null : list.next(cursor);

		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
		} catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
		} catch (BoundaryViolationException e) {
			System.out.println(e.getMessage());
		}
		return elem;
	}
}
