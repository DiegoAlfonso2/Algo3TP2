package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.EquipoIncorrectoException;

public class Atacar implements Accion {

	private Coordenada atacante;
	private Coordenada defensor;
	
    public Atacar (Coordenada atacante, Coordenada defensor) {
    	this.atacante = atacante;
    	this.defensor = defensor;
    }

    @Override
	public void ejecutarSobre(Partida partida, Tablero tablero) {
    	if (!partida.puedeJugar(this.atacante)){
    		throw new EquipoIncorrectoException();
    	}
    	tablero.efectuarAtaque(this.atacante, this.defensor);
    }
    
}
