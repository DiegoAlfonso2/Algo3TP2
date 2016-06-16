package fiuba.algo3.modelo.excepciones;

public class EquipoIncorrectoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EquipoIncorrectoException() {
		super();
	}

	public EquipoIncorrectoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EquipoIncorrectoException(String arg0) {
		super(arg0);
	}

	public EquipoIncorrectoException(Throwable arg0) {
		super(arg0);
	}
		
}
