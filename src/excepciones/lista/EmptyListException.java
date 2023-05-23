package excepciones.lista;
/**
 * Esta clase que extiende de Exception define una excepción para lanzar cuando el cliente utiliza la lista cuando se encuentra vacía
 * @author Lucas Solmoni y Victoria Legakis
 *
 */
public class EmptyListException extends Exception {
	public EmptyListException(String msj) {
		super(msj);
	}
}
