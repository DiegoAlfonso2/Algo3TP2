package fiuba.algo3.modelo.excepciones;

public class AtaqueInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AtaqueInvalidoException() {
		super();
	}

	public AtaqueInvalidoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AtaqueInvalidoException(String arg0) {
		super(arg0);
	}

	public AtaqueInvalidoException(Throwable arg0) {
		super(arg0);
	}
	
}
