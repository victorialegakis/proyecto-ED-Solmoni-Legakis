


package tdasimplementados.diccionario;

import java.util.Iterator;

import excepciones.diccionario.InvalidEntryException;
import excepciones.diccionario.InvalidKeyException;
import excepciones.lista.InvalidPositionException;
import tdas.tdadiccionario.IDictionary;
import tdas.tdadiccionario.IEntry;
import tdas.tdalista.IPosition;
import tdas.tdalista.IPositionList;
import tdasimplementados.lista.*;
/**
 * Clase que almacena pares (clave,valor) y puede almacenar claves repetidas
 * @author Lucas Solmoni y Victoria Legakis
 *
 * @param <K> Tipo de las claves
 * @param <V> Tipo de los valores
 */
public class DiccionarioHashAbierto<K, V> implements IDictionary<K, V> {

	protected IPositionList<IEntry<K, V>> element[];
	protected int n;
	protected int N;
	protected static final float carga = 0.5F;

	@SuppressWarnings("unchecked")
	/**
	 * Constructor para el diccionario implementado con una tabla de Hash abierta
	 */
	public DiccionarioHashAbierto() {
		N = 11;
		n = 0;
		element = new IPositionList[N];
		for (int i = 0; i < N; i++) {
			element[i] = new ListaDoblementeEnlazada<IEntry<K, V>>();
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
 * @param k- Clave
 * @return-Un número 
 * @throws InvalidKeyException-Sucede cuando el cliente ingresa una clave incorrecta
 */
	private int hash(K k) throws InvalidKeyException {
		if (k == null) {
			throw new InvalidKeyException("key nula");
		}
		return Math.abs(k.hashCode() % N);
	}

	@SuppressWarnings("unchecked")
	/**
	 * Agranda el tamaño de la tabla hash
	 */
	private void reHash() {
		Iterable<IEntry<K, V>> entradas = entries();
		N = nextPrimo(N);
		n = 0;
		element = (IPositionList<IEntry<K, V>>[]) new ListaDoblementeEnlazada[N];
		for (int i = 0; i < N; i++)
			element[i] = new ListaDoblementeEnlazada<IEntry<K, V>>();
		for (IEntry<K, V> e : entradas)
			try {
				this.insert(e.getKey(), e.getValue());
			} catch (InvalidKeyException E) {
				System.out.println(E.getMessage());
			}
	}
/**
 * Método que se encarga de encontrar el siguiente número primo
 * @param primo-Número al que le queremos encontrar su siguiente número primo
 * @return-El siguiente número primo del numero ingresado por parámetro
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
	public IEntry<K, V> find(K key) throws InvalidKeyException {
		int pos = hash(key);
		IPositionList<IEntry<K, V>> rec = element[pos];
		Iterator<IEntry<K, V>> it = rec.iterator();
		boolean corta = false;
		IEntry<K, V> ret = null;
		IEntry<K, V> ax = null;
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
	public Iterable<IEntry<K, V>> findAll(K key) throws InvalidKeyException {
		IPositionList<IEntry<K, V>> toret = new ListaDoblementeEnlazada<IEntry<K, V>>();
		int nkey = hash(key);
		for (IEntry<K, V> i : element[nkey]) {
			if (key.equals(i.getKey())) {
				toret.addLast(i);
			}
		}
		return toret;
	}

	@Override
	public IEntry<K, V> insert(K key, V value) throws InvalidKeyException {
		int nkey = hash(key);
		IEntry<K, V> aux = new Entrada<K, V>(key, value);
		element[nkey].addLast(aux);
		n++;
		if (n / N > carga) {
			reHash();
		}
		return aux;
	}

	@Override
	public IEntry<K, V> remove(IEntry<K, V> e) throws InvalidEntryException {
		if (e == null)
			throw new InvalidEntryException("entrada invalida");
		IEntry<K, V> toret = null;
		boolean encontre = false;
		try {
			int nkey = hash(e.getKey());
			for (IPosition<IEntry<K, V>> i : element[nkey].positions()) {
				if (i.element().equals(e) && !encontre) {
					try {
						toret = i.element();
						element[nkey].remove(i);
						encontre = true;
						n--;

					} catch (InvalidPositionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			if (!encontre)
				throw new InvalidEntryException("no se encontro la entrada");
			return toret;
		} catch (InvalidKeyException e1) {
			e1.getMessage();
			return null;
		}

	}

	@Override
	public Iterable<IEntry<K, V>> entries() {
		IPositionList<IEntry<K, V>> toret = new ListaDoblementeEnlazada<IEntry<K, V>>();
		for (int i = 0; i < N; i++) {
			for (IEntry<K, V> k : element[i]) {
				toret.addLast(k);
			}
		}
		return toret;
	}

}