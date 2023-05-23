package tdasimplementados.colaconprioridad;

import java.util.Comparator;
import excepciones.colaconprioridad.EmptyPriorityQueueException;
import excepciones.diccionario.InvalidKeyException;
import tdas.tdadiccionario.IEntry;
import tdas.tdapriorityqueue.IPriorityQueue;

/**
 * Clase que  se encarga de definir una colección de elementos que soporta:
 *  – Inserción de elementos arbitraria
 *   – Eliminación de elementos en orden de prioridad (elelemento con 1era prioridad puede ser eliminado en cualquier momento
 * @author Lucas Solmoni y Victoria Legakis
 *
 * @param <K> Tipo de las prioridades
 * @param <V> Tipo de los valores
 */

public class ColaConPrioridad<K, V> implements IPriorityQueue<K, V> {
	// Atributos de instancia
	protected Entrada<K, V>[] element;
	protected Comparator<K> comp;
	protected int size;

/**
 * Constructor de la cola con prioridad
 * @param maxelement- Determina el tamaño del arreglo
 * @param comp- Compara
 */
	public ColaConPrioridad(int maxelement, Comparator<K> comp) {
		// Ojo: ¡¡Mirar bien cómo se hace la creación del arreglo!!
		// Creo un arreglo de maxelement entradas

		element = (Entrada<K, V>[]) new Entrada[maxelement];// aca en el pdf esta (Entrada<K,V> []) pero para mi no hace
															// falta
		this.comp = comp; // Me guardo el comparador del cliente
		size = 0; // Digo que el árbol está vacío porque no tiene entradas
	}

	@Override
	public int size() {
		return size; // Size es la cantidad de entradas del árbol
	}

	@Override
	public boolean isEmpty() {
		return size == 0; // El árbol está vacío cuando no tiene entradas
	}

	@Override
	public IEntry<K, V> min() throws EmptyPriorityQueueException {
		if (isEmpty())
			throw new EmptyPriorityQueueException("Cola vacía");
		return element[1];
		// Recuerde que la componente 0 del arreglo no se usa
	}

	@Override
	public IEntry<K, V> insert(K key, V value) throws InvalidKeyException {
		Entrada<K, V> entrada = new Entrada<K, V>(key, value); // Creo una entrada nueva
		element[++size] = entrada; // Incremento size y pongo la entrada nueva al final del arreglo
		// Burbujeo para arriba.
		int i = size; // seteo indice i de la posicion corriente en arreglo que es la última
		boolean seguir = true; // Bandera para saber cuándo encontré la ubicación de entrada
		while (i > 1 && seguir) {
			Entrada<K, V> elemActual = element[i]; // obtengo entrada i-ésima
			Entrada<K, V> elemPadre = element[i / 2]; // obtengo el padre de la entrada i-ésima
			if (comp.compare(elemActual.getKey(), elemPadre.getKey()) < 0) {
				Entrada<K, V> aux = element[i]; // Intercambio entradas si están desordenadas
				element[i] = element[i / 2];
				element[i / 2] = aux;
				i /= 2; // Reinicializo i con el índice de su padre
			} else // Si no pude intercambiar => la entrada ya estaba ordenada
				seguir = false; // Aviso que terminé
		} // fin while
		return entrada;
	}

	@Override
	public IEntry<K, V> removeMin() throws EmptyPriorityQueueException {
		int m = 1, hi, hd; // En m voy a computar la posición del mínimo de los hijos de i:
		IEntry<K, V> entrada = min(); // Salvo valor a retornar.

		if (size == 1) {
			element[1] = null;
			size = 0;
			return entrada;
		} else {
			// Paso la última entrada a la raíz y la borro del final del arreglo y
			// decremento size:

			element[1] = element[size];
			element[size] = null;
			size--;

			// Burbujeo la nueva raíz hacia abajo buscando su ubicación correcta:

			int i = 1; // i es mi ubicación corriente (Me ubico en la raíz)
			boolean seguir = true; // Bandera para saber cuándo terminar

			while (seguir) {
				// Calculo la posición de los hijos izquierdo y derecho de i; y veo si existen
				// realmente:
				hi = i * 2;
				hd = i * 2 + 1;
				boolean tieneHijoIzquierdo = hi <= size();
				boolean tieneHijoDerecho = hd <= size();
				if (!tieneHijoIzquierdo)
					seguir = false; // Si no hay hijo izquierdo, llegué a una hoja
				else {
					// En m voy a computar la posición del mínimo de los hijos de i:*/
					if (tieneHijoDerecho) {
						// Calculo cuál es el menor de los hijos usando el comparador de prioridades:
						if (comp.compare(element[hi].getKey(), element[hd].getKey()) < 0)
							m = hi;
						else
							m = hd;
					} else
						m = hi;
					// Si hay hijo izquierdo y no hay hijo derecho, el mínimo es el izq.
				} // Fin else
					// Me fijo si hay que intercambiar el actual con el menor de sus hijos:

				if (comp.compare(element[i].getKey(), element[m].getKey()) > 0) {
					Entrada<K, V> aux = element[i]; // Intercambio la entrada i con la m
					element[i] = element[m];
					element[m] = aux;
					i = m; // Reinicializo i para en la siguiente iteración actualizar a partir de posición
							// m.
				} else
					seguir = false; // Si la comparación de entrada i con la m dio bien, termino.
			} // Fin while
			return entrada;
		} // Fin método removeMin
	}
/**
 * Clase que implementa la interface IEntry y define el comportamiento de una entrada con dos datos
 * @author Lucas Solmoni y Victoria Legakis
 * @param <K>- Tipo de las claves
 * @param <V>-Tipo de los valores
 */
	private class Entrada<K, V> implements IEntry<K, V> // Clase anidada
	{
		// Atributos de instancia
		private K clave;
		private V valor;

	/**
	 * Constructor de la entrada
	 * @param clave que va a contener la entrada
	 * @param valor que va a contener la entrada
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

		@Override
		public String toString() {
			return "(" + clave + ", " + valor + ")";
		}
	}

}