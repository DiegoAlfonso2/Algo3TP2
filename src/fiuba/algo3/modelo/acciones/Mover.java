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
    	if (movimiento == null || movimiento.size() < 2) {
    		throw new MovimientoInvalidoException(
    				"No estan indicados los casilleros que se van a atravesar");
    	}
    	try {
			Coordenada origen = movimiento.remove(0);
			Coordenada destino = movimiento.get(movimiento.size() - 1);
			AlgoFormer personaje;
			try {
				personaje = tablero.algoFormerEnCasillero(origen);
			} catch (CasilleroVacioException cve) {
				throw new MovimientoInvalidoException(
						"No hay un AlgoFormer en ese casillero");
			}
	    	if (!partida.puedeJugar(personaje)) {
	    		throw new EquipoIncorrectoException();
	    	}
			List<Consecuencia> consecuencias = new ArrayList<Consecuencia>();
			EstadoVital estado = personaje.getEstadoVital();
			Coordenada coordenadaAnterior = origen;
			for (Coordenada coordenada : movimiento) {
				System.out.println("Atravesando " + coordenada.toString());
				if (!coordenadaAnterior.esConsecutiva(coordenada)) {
					throw new MovimientoInvalidoException(
							"No se puede saltar entre casilleros no contiguos");
				}
				if (!estado.esValido()) {
					throw new MovimientoInvalidoException(
							"El movimiento excede la capacidad del AlgoFormer");
				}
				consecuencias.addAll(tablero.atravesarCasillero(coordenada, personaje, estado));
				coordenadaAnterior = coordenada;
			}
			System.out.println("Ptos de vida: " + estado.getPuntosDeVidaRestantes());
			System.out.println("Esta vivo: " + estado.estaVivo());
			System.out.println("Destino: " + destino);
			if (estado.estaVivo()) {
				System.out.println("Poniendo Algoformer");
				tablero.ponerAlgoformer(personaje, destino);
				System.out.println(tablero.algoFormerEnCasillero(destino));
			}
			tablero.sacarAlgoformer(personaje, origen);
			for (Consecuencia consecuencia : consecuencias) {
				consecuencia.serAfrontadaPor(personaje);
			}
    	} catch (PosicionInvalidaException pie) {
    		throw new MovimientoInvalidoException();
    	}
	}
}
