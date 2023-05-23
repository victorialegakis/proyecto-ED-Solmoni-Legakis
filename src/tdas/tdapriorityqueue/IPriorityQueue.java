package tdas.tdapriorityqueue;

import excepciones.colaconprioridad.EmptyPriorityQueueException;
import excepciones.diccionario.InvalidKeyException;
import tdas.tdadiccionario.IEntry;

/**
 * Interface PriorityQueue
 * 
 *  @author Cátedra de Estructuras de Datos, Departamento de Cs. e Ing. de la Computación, UNS.
 */

public interface IPriorityQueue<K, V> {

	/**
	 * Consulta la cantidad de elementos de la cola.
	 * 
	 * @return Cantidad de elementos de la cola.
	 */
	public int size();

	/**
	 * Consulta si la cola esta vacia.
	 * 
	 * @return Verdadero si la cola est� vacia, falso en caso contrario.
	 */
	public boolean isEmpty();

	/**
	 * Devuelve la entrada con menor prioridad de la cola.
	 * 
	 * @return Entrada con menor prioridad.
	 * @throws EmptyPriorityQueueException si la cola est� vacia.
	 */
	public IEntry<K, V> min() throws EmptyPriorityQueueException;

	/**
	 * Inserta un par clave-valor y devuelve la entrada creada.
	 * 
	 * @param key   Clave de la entrada a insertar.
	 * @param value Valor de la entrada a insertar.
	 * @return Entrada creada.
	 * @throws InvalidKeyException si la clave es inv�lida.
	 */
	public IEntry<K, V> insert(K key, V value) throws InvalidKeyException;

	/**
	 * Remueve y devuelve la entrada con menor prioridad de la cola.
	 * 
	 * @return Entrada con menor prioridad.
	 * @throws EmptyPriorityQueueException si la cola est� vacia.
	 */
	public IEntry<K, V> removeMin() throws EmptyPriorityQueueException;
}