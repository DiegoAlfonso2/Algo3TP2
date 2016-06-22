package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.modelo.modos.Modo;

public abstract class Autobot extends AlgoFormer {

	protected Autobot(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		super(nombre, puntosDeVida, modoHumanoide, modoAlterno);
	}

	@Override
	public boolean perteneceA(JugadorAutobots jugador) {
		return true;
	}
	
	@Override
	public boolean perteneceA(JugadorDecepticons jugador) {
		return false;
	}	

	@Override
	public void atacar(AlgoFormer objetivo, int distanciaAObjetivo) {
		if (!ataquePosible(distanciaAObjetivo)) {
			throw new AtaqueInvalidoException();
		}
		objetivo.recibirAtaque(this, getAtaqueModificado());
	}
	
	@Override
	protected void recibirAtaque(Autobot atacante, int ataque) {
		throw new AtaqueInvalidoException("No se puede atacar un AlgoFormer del mismo equipo");
	}
	
	@Override
	protected void recibirAtaque(Decepticon atacante, int ataque) {
		recibirDanio(ataque);
	}
}
