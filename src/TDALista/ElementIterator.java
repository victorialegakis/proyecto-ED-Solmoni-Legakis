package TDALista;

import java.util.Iterator;

import java.util.NoSuchElementException;

import excepciones.BoundaryViolationException;
import excepciones.EmptyListException;
import excepciones.InvalidPositionException;


/**
 *  Clase que define las características del elemento que recorre por una colección
 *  
 * @author Lucas Solmoni y Victoria Legakis 
 * 
 * @param <E> Tipo de los elementos 
 */
public class ElementIterator<E> implements Iterator<E> {
	
	protected PositionList<E> list;
	protected Position<E> cursor;

	/**
	 * Constructor para el iterador de elementos
	 *
	 * @param l Es una colección que implementa la interfaz PositionList y la
	 *          vamos a utilizar para inicializar nuestra lista
	 */
	public ElementIterator(PositionList<E> l) {
		list = l; 
		if (list.isEmpty())
			cursor = null;
		else
			try {
				
				cursor = list.first();
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
	}

	@Override
	public boolean hasNext() {
		
		return cursor != null;
	}

	@Override
	public E next() throws NoSuchElementException {
		if (cursor == null) 
			throw new NoSuchElementException("Error: No hay siguiente");
		E elem = cursor.element(); 
		try {
			
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
