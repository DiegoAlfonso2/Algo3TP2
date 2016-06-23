package fiuba.algo3.modelo.excepciones;

/**
 * Created by Julian Garate on 6/21/16.
 */
public class FusionInvalidaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FusionInvalidaException() {
        super();
    }

    public FusionInvalidaException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public FusionInvalidaException(String arg0) {
        super(arg0);
    }

    public FusionInvalidaException(Throwable arg0) {
        super(arg0);
    }
}
