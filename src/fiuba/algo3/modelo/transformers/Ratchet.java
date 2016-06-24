package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.modos.RatchetAlterno;
import fiuba.algo3.modelo.modos.RatchetHumanoide;

public class Ratchet extends Autobot {

	private static final String RATCHET_NOMBRE = "Ratchet";
	private static final int RATCHET_PUNTOS_DE_VIDA = 150;
	
    public Ratchet() {
        super(RATCHET_NOMBRE,
        		RATCHET_PUNTOS_DE_VIDA,
        		new RatchetHumanoide(),
        		new RatchetAlterno());
    }
	
}