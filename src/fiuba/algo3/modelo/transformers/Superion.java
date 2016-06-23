package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.modos.Modo;
import fiuba.algo3.modelo.modos.SuperionUnico;

/**
 * Created by Julian Garate on 6/21/16.
 */
public class Superion extends Megatransformer{


        private static final String SUPERION_NOMBRE = "Superion";

        public Superion(AlgoFormer algo1, AlgoFormer algo2,AlgoFormer algo3) {

            super(SUPERION_NOMBRE,
                    algo1.getPuntosDeVida () + algo2.getPuntosDeVida () + algo3.getPuntosDeVida ()
                    ,
                    new SuperionUnico(),
                    new SuperionUnico ());
        }

    @Override
    public boolean equipoAutobots() {
        return true;
    }

    @Override
    public boolean equipoDecepticons() {
        return false;
    }
}
