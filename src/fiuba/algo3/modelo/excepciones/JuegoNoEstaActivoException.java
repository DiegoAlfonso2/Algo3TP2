package fiuba.algo3.modelo;

public class JuegoNoEstaActivoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JuegoNoEstaActivoException() {
		super();
	}

	public JuegoNoEstaActivoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public JuegoNoEstaActivoException(String arg0) {
		super(arg0);
	}

	public JuegoNoEstaActivoException(Throwable arg0) {
		super(arg0);
	}

}
