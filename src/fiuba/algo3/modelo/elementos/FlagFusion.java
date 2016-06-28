package fiuba.algo3.modelo.elementos;


/**
 * Created by Julian Garate on 6/22/16.
 */
public class FlagFusion extends ModificadorAgotable {


    private final static String NOMBRE = "Flash";
    private final static int DURACION_TURNOS = 3;

    public FlagFusion() {
        super(DURACION_TURNOS);
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }

    @Override
    public int modificarAtaque(int ataqueParcial) {
        return ataqueParcial;
    }

    @Override
    public int modificarDefensa(int ataqueRecibido) {
        return ataqueRecibido;
    }

    @Override
    public int modificarVelocidad(int velocidadParcial) {
        return velocidadParcial;
    }

    @Override
    public boolean algoformerDisponible() { return !estaActivo ();   }


}
