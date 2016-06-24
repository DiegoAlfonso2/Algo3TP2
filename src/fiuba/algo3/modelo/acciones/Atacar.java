package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.EquipoIncorrectoException;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Atacar implements Accion {

	private Coordenada coordAtacante;
	private Coordenada coordDefensor;
	
    public Atacar (Coordenada coordAtacante, Coordenada defensor) {
    	this.coordAtacante = coordAtacante;
    	this.coordDefensor = defensor;
    }

    @Override
	public void ejecutarSobre(Partida partida, Tablero tablero) {
    	AlgoFormer atacante = tablero.algoFormerEnCasillero(coordAtacante);
    	if (!partida.puedeJugar(atacante)){
    		throw new EquipoIncorrectoException();
    	}
    	tablero.efectuarAtaque(this.coordAtacante, this.coordDefensor);
    }
    
}
