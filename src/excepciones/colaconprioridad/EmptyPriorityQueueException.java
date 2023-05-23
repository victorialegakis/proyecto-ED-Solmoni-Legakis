package excepciones.colaconprioridad;
/**
 * Esta clase que extiende de Exception, define una excepción para lanzar cuando el cliente usa la cola cuando esta vacía
 * @author Lucas Solmoni y Victoria Legakis
 *
 */
public class EmptyPriorityQueueException extends Exception {
	public EmptyPriorityQueueException(String msj) {
		super(msj);
	}
}
