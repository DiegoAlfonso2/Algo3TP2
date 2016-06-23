package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.modos.Modo;

/**
 * Created by Julian Garate on 6/21/16.
 */
public abstract class Megatransformer extends AlgoFormer {



    protected Megatransformer(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
        super (nombre, puntosDeVida, modoHumanoide, modoAlterno);
    }


    public boolean perteneceA(Jugador jugador) {
        return jugador.lePertenece(this);
    }


}
