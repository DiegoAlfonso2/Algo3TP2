package fiuba.algo3.modelo;

import fiuba.algo3.modelo.transformers.AlgoFormer;

/**
 * Created by Julian Garate on 6/1/16.
 */
public class Transformar implements Accion {

	private Coordenada posicionAlgoFormerATransformar;
	
    public Transformar(Coordenada posicionAlgoFormerATransformar) {
    	this.posicionAlgoFormerATransformar = posicionAlgoFormerATransformar;
    }

	@Override
	public void ejecutarSobre(Partida partida, Tablero tablero) {
		// TODO Validar el turno
		AlgoFormer accionado = tablero.algoFormerEnCasillero(posicionAlgoFormerATransformar);
		accionado.cambiarModo();
	}
}
