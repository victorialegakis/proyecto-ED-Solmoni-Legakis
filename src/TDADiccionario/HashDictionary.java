package TDADiccionario;

import java.util.Iterator;

import TDALista.*;
import auxiliares.Entry;
import auxiliares.Entrada;
import excepciones.InvalidEntryException;
import excepciones.InvalidKeyException;
import excepciones.InvalidPositionException;

/**
 *
 * Clase que almacena pares (clave,valor) y puede almacenar claves repetidas
 * @author Lucas Solmoni y Victoria Legakis
 *
 * @param <K> Tipo de las claves
 * @param <V> Tipo de los valores
 */
public class HashDictionary<K, V> implements Dictionary<K, V> {

	protected PositionList<Entry<K, V>> element[];
	protected int n;
	protected int N;
	protected static final float carga = 0.5F;

	
	/**
	 * Constructor para el diccionario implementado con una tabla de Hash abierta
	 */
	public HashDictionary() {
		N = 11;
		n = 0;
		element = new PositionList[N];
		for (int i = 0; i < N; i++) {
			element[i] = new DoubleLinkedList<Entry<K, V>>();
		}
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}
/**
 * Transforma la clave en un número, el cual identifica la posición(casilla o cubeta) donde la tabla hash localiza el valor deseado ,para luego devolverlp
 * @param k Clave
 * @return Un número 
 * @throws InvalidKeyException-Sucede cuando el cliente ingresa una clave incorrecta
 */
	private int hash(K k) throws InvalidKeyException {
		if (k == null) {
			throw new InvalidKeyException("key nula");
		}
		return Math.abs(k.hashCode() % N);
	}

	
	/**
	 * Agranda el tamaño de la tabla hash
	 */
	private void reHash() {
		Iterable<Entry<K, V>> entradas = entries();
		N = nextPrimo(N*2);
		n = 0;
		element = (PositionList<Entry<K, V>>[]) new DoubleLinkedList[N];
		for (int i = 0; i < N; i++)
			element[i] = new DoubleLinkedList<Entry<K, V>>();
		for (Entry<K, V> e : entradas)
			try {
				this.insert(e.getKey(), e.getValue());
			} catch (InvalidKeyException E) {
				System.out.println(E.getMessage());
			}
	}
/**
 * Método que se encarga de encontrar el siguiente número primo
 * @param primo Número al que le queremos encontrar su siguiente número primo
 * @return El siguiente número primo del numero ingresado por parámetro
 */
	private int nextPrimo(int primo) {
		boolean encontre = false;
		boolean notprimo;
		int aux = primo;
		while (!encontre) {
			aux++;
			notprimo = false;
			for (int i = 2; i < aux && !notprimo; i++) {
				if (aux % i == 0)
					notprimo = true;
				else if (i == aux - 1 && aux % i != 0)
					encontre = true;
			}
		}
		return aux;
	}

	@Override
	public Entry<K, V> find(K key) throws InvalidKeyException {
		int pos = hash(key);
		PositionList<Entry<K, V>> rec = element[pos];
		Iterator<Entry<K, V>> it = rec.iterator();
		boolean corta = false;
		Entry<K, V> ret = null;
		Entry<K, V> ax = null;
		while (it.hasNext() && !corta) {
			ax = it.next();
			if (ax.getKey().equals(key)) {
				ret = ax;
				corta = true;
			}
		}
		return ret;


	}

	@Override
	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
		PositionList<Entry<K, V>> toret = new DoubleLinkedList<Entry<K, V>>();
		int nkey = hash(key);
		for (Entry<K, V> i : element[nkey]) {
			if (key.equals(i.getKey())) {
				toret.addLast(i);
			}
		}
		return toret;
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		int nkey = hash(key);
		Entry<K, V> aux = new Entrada<K, V>(key, value);
		element[nkey].addLast(aux);
		n++;
		if (n / N > carga) {
			reHash();
		}
		return aux;
	}

	@Override
	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {
		if (e == null)
			throw new InvalidEntryException("Entrada invalida");
		Entry<K, V> toret = null;
		boolean encontre = false;
		try {
			int nkey = hash(e.getKey());
			for (Position<Entry<K, V>> i : element[nkey].positions()) {
				if (i.element().equals(e) && !encontre) {
					try {
						toret = i.element();
						element[nkey].remove(i);
						encontre = true;
						n--;

					} catch (InvalidPositionException e1) {

						e1.printStackTrace();
					}
				}
			}
			if (!encontre)
				throw new InvalidEntryException("No se encontro la entrada");
			return toret;
		} catch (InvalidKeyException e1) {
			e1.getMessage();
			return null;
		}

	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K, V>> toret = new DoubleLinkedList<Entry<K, V>>();
		for (int i = 0; i < N; i++) {
			for (Entry<K, V> k : element[i]) {
				toret.addLast(k);
			}
		}
		return toret;
	}

}