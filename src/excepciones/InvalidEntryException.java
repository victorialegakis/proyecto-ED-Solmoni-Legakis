package excepciones;
/**
 * Esta clase que extiende de Exception ,define una excepción para lanzar cuando el cliente ingresa una entrada incorrecta
 * @author Lucas Solmoni y Victoria Legakis
 *
 */
public class InvalidEntryException extends Exception {
	public InvalidEntryException(String msj) {
		super(msj);
	}
}
