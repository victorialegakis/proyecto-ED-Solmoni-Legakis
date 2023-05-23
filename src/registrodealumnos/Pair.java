package registrodealumnos;

import tdas.tdadiccionario.IEntry;

/**
 * Clase que modela un par de clave y valor.
 * @author Lucas Solmoni y Victoria Legakis
 *
 * @param <K> key
 * @param <V> value
 */

public class Pair<K, V> implements IEntry<K, V> {
	private K clave;
	private V valor;
	
	/**
	 * Constructor de la clase par que recibe una clave y un valor.
	 */
	public Pair(K clave, V valor) {
		this.clave = clave;
		this.valor = valor;
	}

	@Override
	public K getKey() {
		return clave;
	}

	@Override
	public V getValue() {
		return valor;
	}
	 /**
	  * Establece la clave.
	  * @param clave
	  */
	public void setClave(K clave) {
		this.clave = clave;
	}
	/**
	 * Establece el valor.
	 * @param valor
	 */
	public void setValor(V valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "( " + clave + "," + valor + ")";
	}

}
