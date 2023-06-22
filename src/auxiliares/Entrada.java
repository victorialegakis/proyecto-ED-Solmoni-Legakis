package auxiliares;


/**
 * Clase que implementa la interface Entry y define el comportamiento de una entrada con dos datos de tipo genérico
 * @author Lucas Solmoni y Victoria Legakis

 * @param <K>  Tipo de las claves
 * @param <V> Tipo de los valores
 */
public class Entrada<K, V> implements Entry<K, V> {
	private K clave;
	private V valor;
/**
 * Constructor de la clase Entrada que tiene dos parámetros de tipo genérico
 * @param clave Determina la clave de la entrada
 * @param valor Determina el valor de la entrada
 */
	public Entrada(K clave, V valor) {
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
 * Método para establecer la clave de la entrada
 * @param clave que estableceremos para la entarda
 */
	public void setClave(K clave) {
		this.clave = clave;
	}
   /**
    * Método para establecer la clave de la entrada
    * @param valor que estableceremos para la entrada
    */
	public void setValor(V valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "( " + clave + "," + valor + ")";
	}

}
