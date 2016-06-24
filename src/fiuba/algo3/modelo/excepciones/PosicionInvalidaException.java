package fiuba.algo3.modelo.excepciones;

public class PosicionInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PosicionInvalidaException() {
		super();
	}

	public PosicionInvalidaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PosicionInvalidaException(String arg0) {
		super(arg0);
	}

	public PosicionInvalidaException(Throwable arg0) {
		super(arg0);
	}

}
