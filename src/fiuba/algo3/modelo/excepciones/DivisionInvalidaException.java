package fiuba.algo3.modelo.excepciones;

/**
 * Created by Julian Garate on 7/1/16.
 */
public class DivisionInvalidaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DivisionInvalidaException() {
        super ();
    }

    public DivisionInvalidaException(String arg0, Throwable arg1) {
        super (arg0, arg1);
    }

    public DivisionInvalidaException(String arg0) {
        super (arg0);
    }

    public DivisionInvalidaException(Throwable arg0) {
        super (arg0);
    }
}
