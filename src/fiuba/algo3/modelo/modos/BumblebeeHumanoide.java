package fiuba.algo3.modelo.modos;

public class BumblebeeHumanoide extends Humanoide {
	
	private final static int BUMBLEBEE_HUMANOIDE_PUNTOS_ATAQUE = 40;
	private final static int BUMBLEBEE_HUMANOIDE_DIST_ATAQUE = 1;
	private final static int BUMBLEBEE_HUMANOIDE_VELOCIDAD = 2;
	private final static String BUMBLEBEE_HUMANOIDE_AVATAR =
			"Bumblebee Humanoide";
	
	public BumblebeeHumanoide() {
		super(BUMBLEBEE_HUMANOIDE_PUNTOS_ATAQUE,
				BUMBLEBEE_HUMANOIDE_DIST_ATAQUE,
				BUMBLEBEE_HUMANOIDE_VELOCIDAD);
	}

	@Override
	public String avatarModo() {
		return BUMBLEBEE_HUMANOIDE_AVATAR;
	}

}

