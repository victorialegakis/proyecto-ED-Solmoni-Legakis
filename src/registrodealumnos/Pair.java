package registrodealumnos;

import tdas.tdadiccionario.IEntry;


public class Pair<K, V> implements IEntry<K, V> {
	private K clave;
	private V valor;

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

	public void setClave(K clave) {
		this.clave = clave;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "( " + clave + "," + valor + ")";
	}

}
