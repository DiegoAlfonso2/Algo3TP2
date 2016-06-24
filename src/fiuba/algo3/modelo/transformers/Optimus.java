package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.modos.OptimusAlterno;
import fiuba.algo3.modelo.modos.OptimusHumanoide;

public class Optimus extends Autobot {
	
	private static final String OPTIMUS_NOMBRE = "Optimus";
	private static final int OPTIMUS_PUNTOS_DE_VIDA = 500;

    public Optimus() {
        super(OPTIMUS_NOMBRE,
        		OPTIMUS_PUNTOS_DE_VIDA,
        		new OptimusHumanoide(),
        		new OptimusAlterno());
    }
	
}
