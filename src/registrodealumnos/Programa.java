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
 * Esta clase brinda las funcionalidades principales del programa.
 * @author Lucas Solmoni & Victoria Legakis
 *
 * @param <K>,<V> genericos. Tipo de elementos del atributo listaPares.
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

	/**
	 * Permite acceder al nombre de la materia
	 * @return nombre de la materia.
	 */
	public String getNombreMateria() {
		return nombreMateria;
	}

	/**
	 * Permite ingresar un alumno al registro.
	 * @param key L.U del alumno
	 * @param value nota del alumno
	 */
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
	 * Permite consultar una determinada nota por L.U.
	 * @param key es el LU del alumno
	 * @return la nota del alumno
	 * 
	 */

	public int consultarNota(int key) {
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

	/**
	 * Permite eliminar un alumno del registro.
	 * @param key clave del alumno.
	 */
	public void eliminarAlumno(int key) {
		
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

	/**
	 * Permite visualizar los alumnos en la interfaz gráfica.
	 * @return lista de posiciones de alumnos.
	 */
	public Iterable<IPosition<Pair<Integer, Integer>>> visualizarAlumnos() {
		return listaPares.positions();
	}

	/**
	 * Permite calcular el promedio de notas del registro.
	 * @return promedio.
	 */
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

	/**
	 * Permite calcular la mínima nota del registro.
	 * @return nota mínima del registro.
	 */
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

	/**
	 * Permite ordenar la lista de mayor a menor según las notas de los alumnos.
	 * @return lista ordenada de mayor a menor.
	 */
	public Iterable<Pair<Integer, Integer>> alumnosDeMayorAMenor() {

		IPositionList<Pair<Integer, Integer>> lista2 = new ListaDoblementeEnlazada<Pair<Integer, Integer>>();
		IPriorityQueue<Integer, Integer> cp = new ColaConPrioridad<Integer, Integer>(50, new Comparador<Integer>());

		for (IPosition<Pair<Integer, Integer>> p : listaPares.positions()) {
			try {
				cp.insert(p.element().getValue(), p.element().getKey());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}

		}

		while (!cp.isEmpty()) {

			IEntry<Integer, Integer> e = null;
			try {
				e = cp.removeMin();
			} catch (EmptyPriorityQueueException exc) {
				exc.printStackTrace();
			}
			Pair<Integer, Integer> pair = new Pair<Integer, Integer>(e.getValue(), e.getKey());

			lista2.addFirst(pair);
		}
		return lista2;

	}

	/**
	 * Permite ver todos los alumnos que tienen una nota determinada.
	 * @param num representa la nota sobre la cuál se quiere filtrar
	 * @return lista de alumnos con la nota elegida.
	 */

	public IPositionList<Pair<Integer, Integer>> notaDet(Integer num) {
		IPositionList<Pair<Integer, Integer>> lista2 = new ListaDoblementeEnlazada<Pair<Integer, Integer>>();
		Iterable<IEntry<Integer, Integer>> ret = null;
		
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

	/**
	 * Permite ver los alumnos aprobados de la lista.
	 * @return lista de alumnos aprobados.
	 */
	public Iterable<Pair<Integer, Integer>> aprobados() {
		IPositionList<Pair<Integer, Integer>> aprobados = new ListaDoblementeEnlazada<>();
		for (IPosition<Pair<Integer, Integer>> pair : listaPares.positions()) {
			int valor = pair.element().getValue();
			if (valor >= 6) {
				aprobados.addLast(pair.element());
			}
		}
		return aprobados;
	}
	/**
	 * Permite ver los alumnos desaprobados de la lista.
	 * @return lista de alumnos desaprobados.
	 */
	public Iterable<Pair<Integer, Integer>> desaprobados() {
		IPositionList<Pair<Integer, Integer>> desaprobados = new ListaDoblementeEnlazada<>();
		for (IPosition<Pair<Integer, Integer>> pair : listaPares.positions()) {
			int valor = (Integer) pair.element().getValue();
			if (valor < 6) {
				desaprobados.addLast(pair.element());
			}
		}
		return desaprobados;

	}
	
	/**
	 * Chequea si el LU pasado por parámetro existe en el registro. 
	 * @param lu entero que representa un legajo
	 * @return boolean que representa la existencia del LU.
	 */

	public boolean chequearLUExistente(int lu) {
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
			e.printStackTrace();
			return false;
		}

	}
}
