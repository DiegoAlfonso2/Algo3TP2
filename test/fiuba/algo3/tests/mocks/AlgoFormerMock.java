package fiuba.algo3.tests.mocks;

import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.modos.Modo;
import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.modelo.transformers.Autobot;
import fiuba.algo3.modelo.transformers.Decepticon;

public class AlgoFormerMock extends AlgoFormer {

	public AlgoFormerMock(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		super(nombre, puntosDeVida, modoHumanoide, modoAlterno);
	}

	@Override
	public boolean perteneceA(JugadorAutobots jugador) {
		return false;
	}

	@Override
	public boolean perteneceA(JugadorDecepticons jugador) {
		return false;
	}

	@Override
	public void atacar(AlgoFormer objetivo, int distanciaAObjetivo) {

	}

	@Override
	protected void recibirAtaque(Autobot atacante, int ataque) {

	}

	@Override
	protected void recibirAtaque(Decepticon atacante, int ataque) {

	}

}
