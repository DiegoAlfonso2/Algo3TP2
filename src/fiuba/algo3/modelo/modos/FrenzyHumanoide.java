package fiuba.algo3.modelo.modos;

public class FrenzyHumanoide extends Humanoide {

	private final static int FRENZY_HUMANOIDE_PUNTOS_ATAQUE = 10;
	private final static int FRENZY_HUMANOIDE_DIST_ATAQUE = 5;
	private final static int FRENZY_HUMANOIDE_VELOCIDAD = 2;
	private final static String FRENZY_HUMANOIDE_AVATAR =
			"Frenzy Humanoide";
	
	public FrenzyHumanoide() {
		super(FRENZY_HUMANOIDE_PUNTOS_ATAQUE,
				FRENZY_HUMANOIDE_DIST_ATAQUE,
				FRENZY_HUMANOIDE_VELOCIDAD);
	}
	
	@Override
	public String avatarModo() {
		return FRENZY_HUMANOIDE_AVATAR;
	}

}

