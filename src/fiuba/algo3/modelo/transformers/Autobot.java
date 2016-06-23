package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.modos.Modo;

public abstract class Autobot extends AlgoFormer {

	protected Autobot(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		super(nombre, puntosDeVida, modoHumanoide, modoAlterno);
	}


	public boolean perteneceA(Jugador jugador) {
		return jugador.lePertenece(this);
	}

	public boolean equipoAutobots() {
		return true;
	}
	
	public boolean equipoDecepticons() {
		return false;
	}
}
