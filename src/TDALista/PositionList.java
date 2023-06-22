package TDALista;

import java.util.Iterator;
import excepciones.BoundaryViolationException;
import excepciones.EmptyListException;
import excepciones.InvalidPositionException;


/**
 * Interface PositionList
 * @author Cátedra de Estructuras de Datos, Departamento de Cs. e Ing. de la Computación, UNS.
 */

public interface PositionList<E> extends Iterable<E> {
	/**
	 * Consulta la cantidad de elementos de la lista
	 *
	 * @return cantidad de elementos que tiene la lista.
	 */
	public int size();

	/**
	 * Consulta si la lista esta vacia.
	 *
	 * @return Verdadero si la lista está vacía, falso en caso contrario.
	 */
	public boolean isEmpty();

	/**
	 * Se encarga de devolver la posicion del primer elemento de la lista.
	 *
	 * @return Posición del primer elemento de la lista.
	 * @throws EmptyListException si la lista está vacáa.
	 */
	public Position<E> first() throws EmptyListException;

	/**
	 * Devuelve la posición del último elemento de la lista.
	 *
	 * @return Posición del último elemento de la lista.
	 * @throws EmptyListException si la lista está vacáa.
	 *
	 */
	public Position<E> last() throws EmptyListException;

	/**
	 * Devuelve la posición del elemento siguiente a la posición pasada por
	 * parámetro.
	 *
	 * @param p Posición a obtener su elemento siguiente.
	 * @return Posición del elemento siguiente a la posición pasada por parámetro.
	 * @throws InvalidPositionException   si el posición pasada por parámetro es
	 *                                    inválida o la lista está vacía
	 * @throws BoundaryViolationException si la posición pasada por parámetro
	 *                                    corresponde al último elemento de la
	 *                                    lista.
	 */
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;

	/**
	 * Devuelve la posición del elemento anterior a la posición pasada por
	 * parámetro.
	 *
	 * @param p posición a obtener su elemento anterior.
	 * @return posición del elemento anterior a la posición pasada por parámetro.
	 * @throws InvalidPositionException   si la posición pasada por parámetro es
	 *                                    inválida o la lista estávacía
	 * @throws BoundaryViolationException si la posición pasada por parámetro
	 *                                    corresponde al primer elemento de la
	 *                                    lista.
	 */
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;

	/**
	 * Inserta un elemento al principio de la lista.
	 *
	 * @param element Elemento a insertar al principio de la lista.
	 */
	public void addFirst(E element);

	/**
	 * Inserta un elemento al final de la lista.
	 *
	 * @param element Elemento a insertar al final de la lista.
	 */
	public void addLast(E element);

	/**
	 * Inserta un elemento luego de la posición pasada por parámetro.
	 *
	 * @param p       posición en cuya posición siguiente se insertar� el elemento
	 *                pasado por parámetro.
	 * @param element Elemento a insertar luego de la posición pasada como
	 *                parámetro.
	 * @throws InvalidPositionException si la posición es inválida o la lista
	 *                                  estávacía
	 */
	public void addAfter(Position<E> p, E element) throws InvalidPositionException;

	/**
	 * Inserta un elemento antes de la posición pasada como parámetro.
	 *
	 * @param p       Posición en cuya posición anterior se insertará el elemento
	 *                pasado por parámetro.
	 * @param element Elemento a insertar antes de la posición pasada como
	 *                parámetro.
	 * @throws InvalidPositionException si la posición es inválida o la lista
	 *                                  estávacía
	 */
	public void addBefore(Position<E> p, E element) throws InvalidPositionException;

	/**
	 * Remueve el elemento que se encuentra en la posición pasada por parámetro.
	 *
	 * @param p Posición del elemento a eliminar.
	 * @return element Elemento removido.
	 * @throws InvalidPositionException si la posición es inválida o la lista está
	 *                                  vacía.
	 */
	public E remove(Position<E> p) throws InvalidPositionException;

	/**
	 *
	 * Establece el elemento en la posición pasados por parámetro. Reemplaza el
	 * elemento que se encontraba anteriormente en esa posición y devuelve el
	 * elemento anterior.
	 *
	 * @param p       posición a establecer el elemento pasado por parámetro.
	 * @param element Elemento a establecer en la posición pasada por parámetro.
	 * @return Elemento anterior.
	 * @throws InvalidPositionException si la posición es inválida o la lista está
	 *                                  vacía
	 */
	public E set(Position<E> p, E element) throws InvalidPositionException;

	/**
	 * Devuelve un un iterador de todos los elementos de la lista.
	 *
	 * @return Un iterador de todos los elementos de la lista.
	 */
	@Override
	public Iterator<E> iterator();

	/**
	 * Devuelve una colección iterable de posiciones.
	 *
	 * @return Una colección iterable de posiciones.
	 */
	public Iterable<Position<E>> positions();
}
