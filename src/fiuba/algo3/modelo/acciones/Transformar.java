package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
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
		AlgoFormer accionado = tablero.algoFormerEnCasillero(posicionAlgoFormerATransformar);
		accionado.transformar();
	}
}
