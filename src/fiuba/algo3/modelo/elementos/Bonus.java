package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public abstract class Bonus implements Contenido {

	private boolean activado = false;
	
	public abstract String getNombre();
	
	@Override
	public void interactuarCon(AlgoFormer personaje) {
		personaje.absorber(this);
	}

	public abstract int modificarAtaque(int ataqueParcial);

	public abstract int modificarDefensa(int ataqueRecibido);
	
	public abstract int modificarVelocidad(int velocidadParcial);
	
	public void activar() {
		activado = true;
	}
	
	public boolean estaActivo() {
		return activado;
	}
	
	public abstract void descontarTurno();
	
}
