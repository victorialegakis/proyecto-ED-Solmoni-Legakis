package excepciones;
/**
 * Esta clase que extiende de Exception ,define una excepción para lanzar cuando el cliente termina afuera del limite de la estructura de datos
 * @author Lucas Solmoni y Victoria Legakis
 *
 */
public class BoundaryViolationException extends Exception {
	public BoundaryViolationException(String msj) {
		super(msj);
	}
}
