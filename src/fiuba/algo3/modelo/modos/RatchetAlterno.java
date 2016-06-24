package fiuba.algo3.modelo.modos;

public class RatchetAlterno extends UnidadAerea {
	
	private final static int RATCHET_AEREO_PUNTOS_ATAQUE = 35;
	private final static int RATCHET_AEREO_DIST_ATAQUE = 2;
	private final static int RATCHET_AEREO_VELOCIDAD = 8;
	private final static String RATCHET_AEREO_AVATAR =
			"F22 raptor";
	
	public RatchetAlterno() {
		super(RATCHET_AEREO_PUNTOS_ATAQUE, 
				RATCHET_AEREO_DIST_ATAQUE, 
				RATCHET_AEREO_VELOCIDAD);
	}
	
	@Override
	public String avatarModo() {
		return RATCHET_AEREO_AVATAR;
	}

}

