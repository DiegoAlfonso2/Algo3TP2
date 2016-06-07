package fiuba.algo3.modelo.excepciones;

public class SuperficieOcupadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SuperficieOcupadaException() {
		super();
	}

	public SuperficieOcupadaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SuperficieOcupadaException(String arg0) {
		super(arg0);
	}

	public SuperficieOcupadaException(Throwable arg0) {
		super(arg0);
	}

}
