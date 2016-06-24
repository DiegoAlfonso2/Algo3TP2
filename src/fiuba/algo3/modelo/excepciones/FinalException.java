package fiuba.algo3.modelo.excepciones;

public class FinalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FinalException() {
		super();
	}

	public FinalException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FinalException(String arg0) {
		super(arg0);
	}

	public FinalException(Throwable arg0) {
		super(arg0);
	}
	
}