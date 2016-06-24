package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.modos.MegatronAlterno;
import fiuba.algo3.modelo.modos.MegatronHumanoide;

public class Megatron extends Decepticon {
	
	private static final String MEGATRON_NOMBRE = "Megatron";
	private static final int MEGATRON_PUNTOS_DE_VIDA = 550;
	
	public Megatron() {
        super(MEGATRON_NOMBRE,
        		MEGATRON_PUNTOS_DE_VIDA,
        		new MegatronHumanoide(),
        		new MegatronAlterno());
    }
		
}