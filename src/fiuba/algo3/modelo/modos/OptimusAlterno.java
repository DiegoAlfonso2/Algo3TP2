package fiuba.algo3.modelo.modos;

public class OptimusAlterno extends UnidadTerrestre {

	private final static int OPTIMUS_TERRESTRE_PUNTOS_ATAQUE = 15;
	private final static int OPTIMUS_TERRESTRE_DIST_ATAQUE = 4;
	private final static int OPTIMUS_TERRESTRE_VELOCIDAD = 5;
	private final static String OPTIMUS_TERRESTRE_AVATAR =
			"Peterbilt 379";

	public OptimusAlterno() {
		super(OPTIMUS_TERRESTRE_PUNTOS_ATAQUE, 
				OPTIMUS_TERRESTRE_DIST_ATAQUE, 
				OPTIMUS_TERRESTRE_VELOCIDAD);
	}

	@Override
	public String avatarModo() {
		return OPTIMUS_TERRESTRE_AVATAR;
	}

}

