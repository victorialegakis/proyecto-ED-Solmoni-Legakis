package tdas.tdadiccionario;

import excepciones.diccionario.InvalidEntryException;
import excepciones.diccionario.InvalidKeyException;

/**
 * Interface Dictionary
 * @author Cátedra de Estructuras de Datos, Departamento de Cs. e Ing. de la Computación, UNS.
 * 
 */

public interface IDictionary<K, V> {
	/**
	 * Consulta el numero de entradas del diccionario.
	 *
	 * @return Numero de entradas del diccionario.
	 */
	public int size();

	/**
	 * Consulta si el diccionario esta vacio.
	 *
	 * @return Verdadero si el diccionario esta vacio, falso en caso contrario.
	 */
	public boolean isEmpty();

	/**
	 * Busca una entrada con clave igual a una clave dada y la devuelve, si no
	 * existe retorna nulo.
	 *
	 * @param key Clave a buscar.
	 * @return Entrada encontrada.
	 * @throws InvalidKeyException si la clave pasada por par�metro es inv�lida.
	 */
	public IEntry<K, V> find(K key) throws InvalidKeyException;

	/**
	 * Retorna una colecci�n iterable que contiene todas las entradas con clave
	 * igual a una clave dada.
	 *
	 * @param key Clave de las entradas a buscar.
	 * @return Colecci�n iterable de las entradas encontradas.
	 * @throws InvalidKeyException si la clave pasada por par�metro es inv�lida.
	 */
	public Iterable<IEntry<K, V>> findAll(K key) throws InvalidKeyException;

	/**
	 * Inserta una entrada con una clave y un valor dado en el diccionario y retorna
	 * la entrada creada.
	 *
	 * @param key Clave de la entrada a crear.
	 * @return value Valor de la entrada a crear.
	 * @throws InvalidKeyException si la clave pasada por par�metro es inv�lida.
	 */
	public IEntry<K, V> insert(K key, V value) throws InvalidKeyException;

	/**
	 * Remueve una entrada dada en el diccionario y devuelve la entrada removida.
	 *
	 * @param e Entrada a remover.
	 * @return Entrada removida.
	 * @throws InvalidEntryException si la entrada no esta en el diccionario o es
	 *                               invalida.
	 */
	public IEntry<K, V> remove(IEntry<K, V> e) throws InvalidEntryException;

	/**
	 * Retorna una coleccion iterable con todas las entradas en el diccionario.
	 *
	 * @return Coleccion iterable de todas las entradas.
	 */
	public Iterable<IEntry<K, V>> entries();

}