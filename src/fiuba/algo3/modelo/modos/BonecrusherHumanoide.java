package fiuba.algo3.modelo.modos;

public class BonecrusherHumanoide extends Humanoide {

	private final static int BONECRUSHER_HUMANOIDE_PUNTOS_ATAQUE = 30;
	private final static int BONECRUSHER_HUMANOIDE_DIST_ATAQUE = 3;
	private final static int BONECRUSHER_HUMANOIDE_VELOCIDAD = 8;
	private final static String BONECRUSHER_HUMANOIDE_AVATAR =
			"Bonecrusher Humanoide";
	
	public BonecrusherHumanoide() {
		super(BONECRUSHER_HUMANOIDE_PUNTOS_ATAQUE,
				BONECRUSHER_HUMANOIDE_DIST_ATAQUE,
				BONECRUSHER_HUMANOIDE_VELOCIDAD);
	}
	
	@Override
	public String avatarModo() {
		return BONECRUSHER_HUMANOIDE_AVATAR;
	}
}
