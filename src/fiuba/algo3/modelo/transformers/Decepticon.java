package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Jugador;

public abstract class Decepticon extends AlgoFormer {

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
