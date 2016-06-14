package fiuba.algo3.modelo.modos;

public class BumblebeeAlterno extends UnidadTerrestre {
	
	private final static int BUMBLEBEE_TERRESTRE_PUNTOS_ATAQUE = 20;
	private final static int BUMBLEBEE_TERRESTRE_DIST_ATAQUE = 3;
	private final static int BUMBLEBEE_TERRESTRE_VELOCIDAD = 15;
	private final static String BUMBLEBEE_TERRESTRE_AVATAR =
			"Chevrolet Camaro Concept";

	public BumblebeeAlterno() {
		super(BUMBLEBEE_TERRESTRE_PUNTOS_ATAQUE,
				BUMBLEBEE_TERRESTRE_DIST_ATAQUE,
				BUMBLEBEE_TERRESTRE_VELOCIDAD);
	}

	@Override
	public String avatarModo() {
		return BUMBLEBEE_TERRESTRE_AVATAR;
	}
}
