package tdasimplementados.colaconprioridad;

import java.util.Comparator;
import excepciones.colaconprioridad.EmptyPriorityQueueException;
import excepciones.diccionario.InvalidKeyException;
import tdas.tdadiccionario.IEntry;
import tdas.tdapriorityqueue.IPriorityQueue;
import tdasimplementados.diccionario.Entrada;

/**
 * Clase que  se encarga de definir una colección de elementos que soporta:
 *  	Inserción de elementos arbitraria
 *   	Eliminación de elementos en orden de prioridad.
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
 * Constructor de la cola con prioridad.
 * @param maxelement Determina el tamaño del arreglo
 * @param comp Compara
 */
	public ColaConPrioridad(int maxelement, Comparator<K> comp) {
		

		element = (Entrada<K, V>[]) new Entrada[maxelement];
															
		this.comp = comp; 
		size = 0; 
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0; 
	}

	@Override
	public IEntry<K, V> min() throws EmptyPriorityQueueException {
		if (isEmpty())
			throw new EmptyPriorityQueueException("Cola vacía");
		return element[1];
		
	}

	@Override
	public IEntry<K, V> insert(K key, V value) throws InvalidKeyException {
		Entrada<K, V> entrada = new Entrada<K, V>(key, value); 
		element[++size] = entrada;
	
		int i = size; // seteo indice i de la posicion corriente
		boolean seguir = true; 
		while (i > 1 && seguir) {
			Entrada<K, V> elemActual = element[i]; 
			Entrada<K, V> elemPadre = element[i / 2]; 
			if (comp.compare(elemActual.getKey(), elemPadre.getKey()) < 0) {
				Entrada<K, V> aux = element[i]; 
				element[i] = element[i / 2];
				element[i / 2] = aux;
				i /= 2; 
			} else 
				seguir = false; 
		} 
		return entrada;
	}

	@Override
	public IEntry<K, V> removeMin() throws EmptyPriorityQueueException {
		int min = 1, hi, hd;
		IEntry<K, V> entrada = min(); 

		if (size == 1) {
			element[1] = null;
			size = 0;
			return entrada;
		} else {

			element[1] = element[size];
			element[size] = null;
			size--;


			int i = 1; // seteo indice i 
			boolean seguir = true; 

			while (seguir) {
				hi = i * 2;
				hd = i * 2 + 1;
				boolean tieneHijoIzquierdo = hi <= size();
				boolean tieneHijoDerecho = hd <= size();
				if (!tieneHijoIzquierdo)
					seguir = false; 
				else {
					if (tieneHijoDerecho) {
						if (comp.compare(element[hi].getKey(), element[hd].getKey()) < 0)
							min = hi;
						else
							min = hd;
					} else
						min = hi;
				} 

				if (comp.compare(element[i].getKey(), element[min].getKey()) > 0) {
					Entrada<K, V> aux = element[i]; 
					element[i] = element[min];
					element[min] = aux;
					i = min; 
				} else
					seguir = false; 
			} 
			return entrada;
		}
	}
}