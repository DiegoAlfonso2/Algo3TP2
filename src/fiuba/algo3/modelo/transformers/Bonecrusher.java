package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.elementos.Modificadores;
import fiuba.algo3.modelo.modos.BonecrusherAlterno;
import fiuba.algo3.modelo.modos.BonecrusherHumanoide;

public class Bonecrusher extends Decepticon{
	
	private static final String BONECRUSHER_NOMBRE = "Bonecrusher";
	private static final int BONECRUSHER_PUNTOS_DE_VIDA = 200;

    public Bonecrusher() {
    	super(BONECRUSHER_NOMBRE, 
    			BONECRUSHER_PUNTOS_DE_VIDA, 
    			new BonecrusherHumanoide(),
    			new BonecrusherAlterno());
    }
}