package tdasimplementados.colaconprioridad;
/**
 * Clase que se encarga de comparar elementos 
 * @author Cátedra de Estructuras de Datos, Departamento de Cs. e Ing. de la Computación, UNS.
 *
 * @param <E>  Tipo de los elementos a comparar
 */
public class Comparador<E> implements java.util.Comparator<E> {

	@Override
	public int compare(E o1, E o2) {

		return ((Comparable<E>) o1).compareTo(o2);
	}

}
