package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.Contenido;

public abstract class Bonus implements Contenido {

	private String nombre;
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public Bonus definirBonus() {
		return this;
	}

	@Override
	public ChispaSuprema definirChispa() {
		return null;
	}

}
