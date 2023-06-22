package excepciones;
/**
 * Esta clase que extiende de Exception ,define una excepción para lanzar cuando el cliente ingresa una posición incorrecta
 * @author Lucas Solmoni y Victoria Legakis
 *
 */
public class InvalidPositionException extends Exception {
	public InvalidPositionException(String msj) {
		super(msj);
	}

}
