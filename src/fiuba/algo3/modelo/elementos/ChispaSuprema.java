package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.Contenido;

/**
 * Created by Julian Garate on 6/3/16.
 */
public class ChispaSuprema implements Contenido{

    private String nombre = "Chispa Suprema";

    public String getNombre() {
        return this.nombre;
    }

	@Override
	public Bonus definirBonus() {
		return null;
	}

	@Override
	public ChispaSuprema definirChispa() {
		return this;
	}
}
