package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.modos.SuperionUnico;

/**
 * Created by Julian Garate on 6/21/16.
 */
public class Superion extends Autobot {


        private static final String SUPERION_NOMBRE = "Superion";

        public Superion(AlgoFormer algo1, AlgoFormer algo2,AlgoFormer algo3) {

            super(SUPERION_NOMBRE,
                    algo1.getPuntosDeVida () + algo2.getPuntosDeVida () + algo3.getPuntosDeVida ()
                    ,
                    new SuperionUnico(),
                    new SuperionUnico ());
        }

}
