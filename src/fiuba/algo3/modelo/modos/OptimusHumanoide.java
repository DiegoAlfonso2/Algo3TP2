package fiuba.algo3.modelo.modos;

public class OptimusHumanoide extends Humanoide {

	private final static int OPTIMUS_HUMANOIDE_PUNTOS_ATAQUE = 50;
	private final static int OPTIMUS_HUMANOIDE_DIST_ATAQUE = 2;
	private final static int OPTIMUS_HUMANOIDE_VELOCIDAD = 2;
	private final static String OPTIMUS_HUMANOIDE_AVATAR =
			"Optimus Humanoide";
	
	public OptimusHumanoide() {
		super(OPTIMUS_HUMANOIDE_PUNTOS_ATAQUE,
				OPTIMUS_HUMANOIDE_DIST_ATAQUE,
				OPTIMUS_HUMANOIDE_VELOCIDAD);
	}
	
	@Override
	public String avatarModo() {
		return OPTIMUS_HUMANOIDE_AVATAR;
	}

}

