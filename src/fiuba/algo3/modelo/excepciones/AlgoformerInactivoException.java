package fiuba.algo3.modelo.excepciones;

public class AlgoformerInactivoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlgoformerInactivoException() {
		super();
	}

	public AlgoformerInactivoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AlgoformerInactivoException(String arg0) {
		super(arg0);
	}

	public AlgoformerInactivoException(Throwable arg0) {
		super(arg0);
	}
	
}
