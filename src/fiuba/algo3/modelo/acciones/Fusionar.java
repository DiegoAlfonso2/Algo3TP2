package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.elementos.FlagFusion;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.excepciones.EquipoIncorrectoException;
import fiuba.algo3.modelo.excepciones.FusionInvalidaException;
import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.modelo.transformers.Menasor;
import fiuba.algo3.modelo.transformers.Optimus;
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
    public void ejecutarSobre(Partida partida, Tablero tablero) {

        if ((!primeraC.esConsecutiva (segundaC) || !primeraC.esConsecutiva (terceraC)) &&
                (!segundaC.esConsecutiva (primeraC) || !segundaC.esConsecutiva (terceraC)) &&
                (!terceraC.esConsecutiva (primeraC) || !terceraC.esConsecutiva (segundaC))
                ) throw new FusionInvalidaException (" Los AlgoFormers tienen que estar consecutivos.");

        AlgoFormer algo1, algo2, algo3, megat;
        try {
            algo1 = tablero.algoFormerEnCasillero (primeraC);
            algo2 = tablero.algoFormerEnCasillero (segundaC);
            algo3 = tablero.algoFormerEnCasillero (terceraC);

        } catch (CasilleroVacioException cve) {
            throw new CasilleroVacioException (
                    "Uno o mas, de los casilleros esta vacio. ");
        }

        if (    !partida.obtenerJugadorActivo().lePertenece(algo1) ||
                !partida.obtenerJugadorActivo().lePertenece(algo2) ||
                !partida.obtenerJugadorActivo().lePertenece(algo3)
                ) throw new EquipoIncorrectoException ("Los Algoformers tienen que ser del mismo equipo.");


        megat=partida.obtenerJugadorActivo ().obtenerAlgoformers ().get (3);

        tablero.sacarAlgoformer (algo1,primeraC);
        tablero.sacarAlgoformer (algo2,segundaC);
        tablero.sacarAlgoformer (algo3,terceraC);

        new FlagFusion ().interactuarCon (megat);
        tablero.ponerAlgoformer (megat,primeraC);

    }
}
