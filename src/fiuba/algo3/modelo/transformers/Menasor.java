package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.modos.MenasorUnico;

/**
 * Created by Julian Garate on 6/21/16.
 */
public class Menasor extends Megatransformer{

    private static final String MENASOR_NOMBRE = "Menasor";

    public Menasor(AlgoFormer algo1, AlgoFormer algo2,AlgoFormer algo3) {

        super(MENASOR_NOMBRE,
                algo1.getPuntosDeVida () + algo2.getPuntosDeVida () + algo3.getPuntosDeVida ()
                ,
                new MenasorUnico (),
                new MenasorUnico ());
    }

    @Override
    public boolean equipoAutobots() {
        return false;
    }

    @Override
    public boolean equipoDecepticons() {
        return true;
    }
}