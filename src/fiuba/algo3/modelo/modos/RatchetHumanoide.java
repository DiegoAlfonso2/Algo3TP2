package fiuba.algo3.modelo.modos;

public class RatchetHumanoide extends Humanoide {

	private final static int RATCHET_HUMANOIDE_PUNTOS_ATAQUE = 5;
	private final static int RATCHET_HUMANOIDE_DIST_ATAQUE = 5;
	private final static int RATCHET_HUMANOIDE_VELOCIDAD = 1;
	private final static String RATCHET_HUMANOIDE_AVATAR =
			"Ratchet Humanoide";
	
	public RatchetHumanoide() {
		super(RATCHET_HUMANOIDE_PUNTOS_ATAQUE,
				RATCHET_HUMANOIDE_DIST_ATAQUE,
				RATCHET_HUMANOIDE_VELOCIDAD);
	}
	
	@Override
	public String avatarModo() {
		return RATCHET_HUMANOIDE_AVATAR;
	}

}

