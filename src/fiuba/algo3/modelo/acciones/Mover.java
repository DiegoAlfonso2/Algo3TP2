package fiuba.algo3.modelo.acciones;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.excepciones.EquipoIncorrectoException;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.excepciones.PosicionInvalidaException;
import fiuba.algo3.modelo.transformers.AlgoFormer;


public class Mover implements Accion {

	private List<Coordenada> movimiento;
	
    public Mover(List<Coordenada> movimiento) {
    	this.movimiento = movimiento;
    }


    @Override
    // TODO Este metodo pide un refactor
	public void ejecutarSobre(Partida partida, Tablero tablero) {
    	if (!partida.puedeJugar(movimiento.get(0))){
    		throw new EquipoIncorrectoException();
    	}
    	if (movimiento == null || movimiento.size() < 2) {
    		throw new MovimientoInvalidoException();
    	}
    	try {
			Coordenada origen = movimiento.remove(0);
			Coordenada destino = movimiento.remove(movimiento.size() - 1);
			AlgoFormer personaje;
			try {
				personaje = tablero.algoFormerEnCasillero(origen);
			} catch (CasilleroVacioException cve) {
				throw new MovimientoInvalidoException();
			}
			personaje.resetearMovimientosPosibles();
			List<Consecuencia> consecuencias = new ArrayList<Consecuencia>();
			// TODO Pedirselo al Algoformer
			EstadoVital estado = new EstadoVital(personaje.getPuntosDeVida(), personaje.getVelocidad());
			Coordenada coordenadaAnterior = origen;
			for (Coordenada coordenada : movimiento) {
				if (!coordenadaAnterior.esConsecutiva(coordenada)) {
					throw new MovimientoInvalidoException();
				}
				consecuencias.addAll(tablero.atravesarCasillero(coordenada, personaje, estado));
				coordenadaAnterior = coordenada;
			}
			if (!coordenadaAnterior.esConsecutiva(destino)) {
				throw new MovimientoInvalidoException();
			}
			consecuencias.addAll(tablero.atravesarCasillero(destino, personaje, estado));
			if (!estado.esValido()) {
				throw new MovimientoInvalidoException();
			}
			tablero.ponerAlgoformer(personaje, destino);
			tablero.sacarAlgoformer(personaje, origen);
			for (Consecuencia consecuencia : consecuencias) {
				consecuencia.serAfrontadaPor(personaje);
			}
    	} catch (PosicionInvalidaException pie) {
    		throw new MovimientoInvalidoException();
    	}
	}
}
