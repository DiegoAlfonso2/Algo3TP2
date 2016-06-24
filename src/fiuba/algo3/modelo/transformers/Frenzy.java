package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.modos.FrenzyAlterno;
import fiuba.algo3.modelo.modos.FrenzyHumanoide;

public class Frenzy extends Decepticon{
	
	private static final String FRENZY_NOMBRE = "Frenzy";
	private static final int FRENZY_PUNTOS_DE_VIDA = 400;

    public Frenzy() {
    	super(FRENZY_NOMBRE,
    			FRENZY_PUNTOS_DE_VIDA,
    			new FrenzyHumanoide(),
    			new FrenzyAlterno());
    }	
}