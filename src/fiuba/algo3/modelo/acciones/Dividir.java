package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.transformers.AlgoFormer;

/**
 * Created by Julian Garate on 6/25/16.
 */
public class Dividir implements Accion {

    private Coordenada inputC;
    private Coordenada primeraC;
    private Coordenada segundaC;
    private Coordenada terceraC;

    public Dividir(Coordenada pos0, Coordenada pos1, Coordenada pos2, Coordenada pos3) {

        inputC = pos0;
        primeraC = pos1;
        segundaC = pos2;
        terceraC = pos3;

    }


    @Override
    public void ejecutarSobre(Partida partida, Tablero tablero) {

        if (    (!primeraC.esConsecutiva (segundaC) || !primeraC.esConsecutiva (terceraC)) &&
                (!segundaC.esConsecutiva (primeraC) || !segundaC.esConsecutiva (terceraC)) &&
                (!terceraC.esConsecutiva (primeraC) || !terceraC.esConsecutiva (segundaC))
                ) throw new FusionInvalidaException (" Los casilleros tienen que estar consecutivos.");

        if (    !tablero.casilleroVacio (primeraC) ||
                !tablero.casilleroVacio (segundaC) ||
                !tablero.casilleroVacio (terceraC)
                ) throw new CasilleroOcupadoException ("Los casilleros tienen que estar libres.");

        AlgoFormer megat;

        try {megat = tablero.algoFormerEnCasillero (inputC);}
        catch (CasilleroVacioException cve) {
            throw new CasilleroVacioException (
                    "El casillero seleccionado esta vacio. ");
        }

        if (!partida.obtenerJugadorActivo().lePertenece(megat))
            throw new EquipoIncorrectoException ("El algoformer seleccionado no le pertenece.");


    }

}
