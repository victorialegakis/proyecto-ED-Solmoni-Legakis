package auxiliares;

/**
 * Interface Entry
 * @author Lucas Solmoni & Victoria Legakis
 *
 * @param <K> key 
 * @param <V> value
 */

public interface Entry<K, V> {

	/**
	 * Devuelve la clave almacenada en la entrada
	 *
	 * @return key of the entry
	 */
	public K getKey();

	/**
	 * Devuelve el valor almacenado en la entrada
	 *
	 * @return value of the entry
	 */
	public V getValue();

}
