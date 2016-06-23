package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.elementos.FlagFusion;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.excepciones.EquipoIncorrectoException;
import fiuba.algo3.modelo.excepciones.FusionInvalidaException;
import fiuba.algo3.modelo.transformers.AlgoFormer;

/**
 * Created by Julian Garate on 6/22/16.
 */
public class EmpezarFusion implements Accion {

    private Coordenada primeraC;
    private Coordenada segundaC;
    private Coordenada terceraC;

    public EmpezarFusion(Coordenada pos1, Coordenada pos2, Coordenada pos3) {

        primeraC = pos1;
        segundaC = pos2;
        terceraC = pos3;

    }

    @Override
    public void ejecutarSobre(Partida partida, Tablero tablero) {

    try {
        AlgoFormer algo1 = tablero.algoFormerEnCasillero (primeraC);
        AlgoFormer algo2 = tablero.algoFormerEnCasillero (segundaC);
        AlgoFormer algo3 = tablero.algoFormerEnCasillero (terceraC);
    } catch (CasilleroVacioException cve) {
        throw new FusionInvalidaException (
                "No hay un AlgoFormer en esos casilleros. ");
    }

    if (    !partida.obtenerJugadorActivo().lePertenece(tablero.algoFormerEnCasillero (primeraC)) ||
            !partida.obtenerJugadorActivo().lePertenece(tablero.algoFormerEnCasillero (segundaC)) ||
            !partida.obtenerJugadorActivo().lePertenece(tablero.algoFormerEnCasillero (terceraC))
            ) throw new EquipoIncorrectoException ("Los Algoformers tienen que ser del mismo equipo.");

    if ((!primeraC.esConsecutiva (segundaC) || !primeraC.esConsecutiva (terceraC)) &&
            (!segundaC.esConsecutiva (primeraC) || !segundaC.esConsecutiva (terceraC)) &&
            (!terceraC.esConsecutiva (primeraC) || !terceraC.esConsecutiva (segundaC))
            ) throw new FusionInvalidaException (" Los AlgoFormers tienen que estar consecutivos.");

    try {
        AlgoFormer algo1 = tablero.algoFormerEnCasillero (primeraC);
        AlgoFormer algo2 = tablero.algoFormerEnCasillero (segundaC);
        AlgoFormer algo3 = tablero.algoFormerEnCasillero (terceraC);
    } catch (CasilleroVacioException cve) {
        throw new FusionInvalidaException (
                "No hay un AlgoFormer en esos casilleros. ");
    }

        // TODO deberia ser una consecuencia?

    tablero.algoFormerEnCasillero (primeraC). absorber (new FlagFusion ());
    tablero.algoFormerEnCasillero (segundaC). absorber (new FlagFusion ());
    tablero.algoFormerEnCasillero (terceraC). absorber (new FlagFusion ());

    }
}
