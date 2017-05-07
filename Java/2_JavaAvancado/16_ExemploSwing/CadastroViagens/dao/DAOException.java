package curso.java.viagem.dao;

/**
 * Exceção de acesso a dados
 */
public class DAOException extends Exception {

	/**
	 * @see Exception#Exception()
	 */
	public DAOException() {
	}

	/**
	 * @see Exception#Exception(String, Throwable)
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see Exception#Exception(String)
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * @see Exception#Exception(Throwable)
	 * @param cause
	 */
	public DAOException(Throwable cause) {
		super(cause);
	}
}
