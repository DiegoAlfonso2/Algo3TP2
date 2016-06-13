package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.modos.BumblebeeAlterno;
import fiuba.algo3.modelo.modos.BumblebeeHumanoide;

public class Bumblebee extends Autobot {
	
	private static final String BUMBLEBEE_NOMBRE = "Bumblebee";
	private static final int BUMBLEBEE_PUNTOS_DE_VIDA = 350;

    public Bumblebee() {
    	super(BUMBLEBEE_NOMBRE, 
    			BUMBLEBEE_PUNTOS_DE_VIDA,
    			new BumblebeeHumanoide(),
    			new BumblebeeAlterno());
    }
		
}