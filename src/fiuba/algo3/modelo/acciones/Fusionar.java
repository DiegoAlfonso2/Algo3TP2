package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.excepciones.EquipoIncorrectoException;
import fiuba.algo3.modelo.excepciones.FusionInvalidaException;
import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.modelo.transformers.Megatransformer;
import fiuba.algo3.modelo.transformers.Menasor;
import fiuba.algo3.modelo.transformers.Superion;

/**
 * Created by Julian Garate on 6/21/16.
 */
public class Fusionar implements Accion {

    private Coordenada primeraC;
    private Coordenada segundaC;
    private Coordenada terceraC;

    public Fusionar(Coordenada pos1, Coordenada pos2, Coordenada pos3) {

        primeraC = pos1;
        segundaC = pos2;
        terceraC = pos3;
    }

    @Override
    public void ejecutarSobre(Partida partida, Tablero tablero) throws FusionInvalidaException {

        if (!partida.puedeJugar (primeraC) ||
                !partida.puedeJugar (segundaC) ||
                !partida.puedeJugar (terceraC)
                ) throw new EquipoIncorrectoException ("Los Algoformers tienen que ser del mismo equipo.");

        if (!(primeraC.esConsecutiva (segundaC) && primeraC.esConsecutiva (terceraC)) ||
                !(segundaC.esConsecutiva (primeraC) && segundaC.esConsecutiva (terceraC)) ||
                !(terceraC.esConsecutiva (primeraC) && terceraC.esConsecutiva (segundaC))
                ) throw new FusionInvalidaException (" Los AlgoFormers tienen que estar consecutivos.");


        Megatransformer megat;
        AlgoFormer algo1, algo2, algo3;
        try {
            algo1 = tablero.algoFormerEnCasillero (primeraC);
            algo2 = tablero.algoFormerEnCasillero (segundaC);
            algo3 = tablero.algoFormerEnCasillero (terceraC);
        } catch (CasilleroVacioException cve) {
            throw new FusionInvalidaException (
                    "No hay un AlgoFormer en esos casilleros. ");
        }

        if ( !algo1.esfusionable () || !algo2.esfusionable () || !algo3.esfusionable ())
            throw new FusionInvalidaException (" Los Algoformers no estan listos para fusionarse.");

        if (algo1.equipoAutobots ())
            megat = new Superion (algo1, algo2, algo3);
        else
            megat = new Menasor (algo1, algo2, algo3);

        tablero.sacarAlgoformer (algo1,primeraC);
        tablero.sacarAlgoformer (algo2,segundaC);
        tablero.sacarAlgoformer (algo3,terceraC);

        tablero.ponerAlgoformer (megat,primeraC);

    }
}
