package registrodealumnos;

import tdasimplementados.colaconprioridad.*;
import tdasimplementados.lista.*;
import tdasimplementados.diccionario.*;
import tdas.tdadiccionario.*;
import tdas.tdalista.*;
import excepciones.lista.*;
import excepciones.diccionario.*;
import excepciones.colaconprioridad.*;
import tdas.tdapriorityqueue.*;

/**
 * @author Lucas Solmoni & Victoria Legakis
 *
 *         Esta clase brinda las funcionalidades principales del programa.
 *
 * @param <K,V> genericos. Tipo de elementos del atributo listaPares.
 */

public class Programa {

	// atributos de instancia.
	private String nombreMateria;
	private IPositionList<Pair<Integer, Integer>> listaPares;

	/**
	 * Constructor: establece el nombre de la materia y establece una lista de
	 * pares.
	 *
	 * @param nombreMateria nombre de la materia ingresada.
	 */

	public Programa(String nombreMateria) {
		this.nombreMateria = nombreMateria;
		listaPares = new ListaDoblementeEnlazada<Pair<Integer, Integer>>();
	}

	// funcionalidad 1 - sigue en gui
	public String getNombreMateria() {
		return nombreMateria;
	}

	// funcionalidad 2
	public void ingresarAlumno(int key, int value) {
		// checkClave(key);
		Pair<Integer, Integer> ing = new Pair<Integer, Integer>(key, value);
		if (listaPares.isEmpty())
			listaPares.addFirst(ing);
		else {
			try {
				IPosition<Pair<Integer, Integer>> ini = listaPares.first();
				IPosition<Pair<Integer, Integer>> fin = listaPares.last();
				boolean encontre = false;
				while (ini != null && !encontre) {
					if (ini.element().getKey().equals(ing.getKey())) {
						encontre = true;
						ini.element().setValor(ing.getValue());
					} else
						ini = (ini != fin) ? listaPares.next(ini) : null;
				}
				if (encontre == false)
					listaPares.addLast(ing);

			} catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	/**
	 * 
	 * @param key es el LU del alumno
	 * @return la nota del alumno
	 * @throws InvalidKeyException si la lista se encuentra vacía
	 * @throws EmptyListException
	 */

	/*
	 * el if-else yo lo pondria xq sabemos xq se pueden producir los errores
	 * entonces verificamos q los valores q me pasaron como parametro esten
	 * correctos pero al querer tirar una excepcion y capturar el mismo tipo de
	 * excepcion ocurre un error
	 * 
	 * Capaz q iria xq vos estas usando una clase q sabes lo q hace pero no sabemos
	 * como se implementa y no sabes tampoco sus metodos privados en teoria
	 */

	// funcionalidad 3
	public int consultarNota(int key) {
		// checkClave(key); // comprobamos que el alumno que nos pasaron no este
		// eleminado del registro
		try {
			boolean encontre = false;
			Pair<Integer, Integer> ax;
			int nota = 0;
			IPosition<Pair<Integer, Integer>> ini = listaPares.first();
			IPosition<Pair<Integer, Integer>> fin = listaPares.last();
			while (ini != null && !encontre) {
				ax = ini.element();
				if (ax.getKey().equals(key)) {
					nota = ax.getValue();
					encontre = true;
				} else
					ini = (ini != fin) ? listaPares.next(ini) : null;
			}
			return nota;
		} catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	// private void checkClave(int key) throws InvalidKeyException {
	// if(key==0) throw new InvalidKeyException("Clave nula");
	// }

	// funcionalidad 4
	public void eliminarAlumno(int key) {
		// if(listaPares.isEmpty()==false) {
		// checkClave(key);
		try {
			IPosition<Pair<Integer, Integer>> ini = listaPares.first();
			IPosition<Pair<Integer, Integer>> fin = listaPares.last();
			boolean encontre = false;
			while (ini != null && !encontre) {
				if (ini.element().getKey().equals(key)) {
					listaPares.remove(ini);
					encontre = true;
				} else {
					if (ini != fin) {
						ini = listaPares.next(ini);
					} else
						ini = null;
				}
			}
		} catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			System.out.println(e.getMessage());
		}

	}
	// }

	// funcionalidad 5 - sigue en gui
	public Iterable<IPosition<Pair<Integer, Integer>>> visualizarAlumnos() {
		// if (listaPares.size()== 0) {
		// throw new EmptyListException("Lista vacía");
		// }
		return listaPares.positions();
	}

	// funcionalidad 6
	public double calcularPromedio() {
		int cantidadEntradas = listaPares.size();
		double sumatoriaNotas = 0;
		if (cantidadEntradas == 0) {
			return -1;
		}
		for (IPosition<Pair<Integer, Integer>> pair : listaPares.positions()) {
			double valor = (double) pair.element().getValue();
			sumatoriaNotas = sumatoriaNotas + valor;
		}
		return sumatoriaNotas / cantidadEntradas;

	}

	// funcionalidad 7
	public Integer minNota() {
		try {
			int cantidadEntradas = listaPares.size();
			if (cantidadEntradas == 0) {
				return -1;
			}
			IPriorityQueue<Integer, Integer> cp = new ColaConPrioridad<Integer, Integer>(50, new Comparador<Integer>());
			for (Pair<Integer, Integer> p : listaPares) { // tiene tiempo 2n y orden n
				cp.insert(p.getValue(), p.getKey());
			}
			return cp.min().getKey();
		} catch (InvalidKeyException | EmptyPriorityQueueException e) {
			System.out.println(e.getMessage());
			return -1;
		}

	}

	// funcionalidad 8
	public Iterable<Pair<Integer, Integer>> alumnosDeMayorAMenor() {

		IPositionList<Pair<Integer, Integer>> lista2 = new ListaDoblementeEnlazada<Pair<Integer, Integer>>();
		IPriorityQueue<Integer, Integer> cp = new ColaConPrioridad<Integer, Integer>(50, new Comparador<Integer>());

		for (IPosition<Pair<Integer, Integer>> p : listaPares.positions()) {
			try {
				cp.insert(p.element().getValue(), p.element().getKey());
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		while (!cp.isEmpty()) {

			IEntry<Integer, Integer> e = null;
			try {
				e = cp.removeMin();
			} catch (EmptyPriorityQueueException exc) {
				// TODO Auto-generated catch block
				exc.printStackTrace();
			}
			Pair<Integer, Integer> pair = new Pair<Integer, Integer>(e.getValue(), e.getKey());

			lista2.addFirst(pair);
		}
		return lista2;

	}

	// funcionalidad 9

	public IPositionList<Pair<Integer, Integer>> notaDet(Integer num) {
		IPositionList<Pair<Integer, Integer>> lista2 = new ListaDoblementeEnlazada<Pair<Integer, Integer>>();
		Iterable<IEntry<Integer, Integer>> ret = null;
		Integer ax = num;
		// if (ax >= 0 && ax <= 10) {
		IDictionary<Integer, Integer> dic = new DiccionarioHashAbierto<Integer, Integer>();
		try {
			for (Pair<Integer, Integer> p : listaPares) {
				dic.insert(p.getValue(), p.getKey());
			}
			ret = dic.findAll(num);

		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		for (IEntry<Integer, Integer> pair : ret) {
			Pair<Integer, Integer> pair2 = new Pair<Integer, Integer>(pair.getValue(), pair.getKey());
			lista2.addFirst(pair2);
		}

		return lista2;
	}

	// funcionalidad 10
	public Iterable<Pair<Integer, Integer>> aprobados() {
		// if (listaPares.size()== 0) {
		// throw new EmptyListException("Lista vacía");
		// }
		IPositionList<Pair<Integer, Integer>> aprobados = new ListaDoblementeEnlazada<>();
		for (IPosition<Pair<Integer, Integer>> pair : listaPares.positions()) {
			int valor = pair.element().getValue();
			if (valor >= 6) {
				aprobados.addLast(pair.element());
			}
		}
		return aprobados;
	}

	public Iterable<Pair<Integer, Integer>> desaprobados() {
		// if (listaPares.size()== 0) {
		// throw new EmptyListException("Lista vacía");
		// }
		IPositionList<Pair<Integer, Integer>> desaprobados = new ListaDoblementeEnlazada<>();
		for (IPosition<Pair<Integer, Integer>> pair : listaPares.positions()) {
			int valor = (Integer) pair.element().getValue();
			if (valor < 6) {
				desaprobados.addLast(pair.element());
			}
		}
		return desaprobados;

	}

	public boolean chequearLUExistente(int lu) {
		// TODO Auto-generated method stub
		int ax = lu;
		if (listaPares.size() == 0) {
			return false;
		}
		IDictionary<Integer, Integer> dic = new DiccionarioHashAbierto<Integer, Integer>();
		try {
			for (Pair<Integer, Integer> p : listaPares) {

				dic.insert(p.getKey(), p.getValue());

			}
			IEntry<Integer, Integer> pair = dic.find(lu);
			if (pair == null) {
				return false;
			}
			return true;
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}
