package excepciones;
/**
 * Esta clase que extiende de Exception define una excepción para lanzar cuando el cliente ingresa una clave incorrecta
 * @author Lucas Solmoni y Victoria Legakis
 *
 */
public class InvalidKeyException extends Exception {
	public InvalidKeyException(String msj) {
		super(msj);
	}
}
