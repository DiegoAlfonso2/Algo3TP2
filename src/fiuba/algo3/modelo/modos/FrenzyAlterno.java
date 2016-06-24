package fiuba.algo3.modelo.modos;

public class FrenzyAlterno extends UnidadTerrestre {

	private final static int FRENZY_TERRESTRE_PUNTOS_ATAQUE = 25;
	private final static int FRENZY_TERRESTRE_DIST_ATAQUE = 2;
	private final static int FRENZY_TERRESTRE_VELOCIDAD = 6;
	private final static String FRENZY_TERRESTRE_AVATAR = "Renault Duster";
	
	public FrenzyAlterno() {
		super(FRENZY_TERRESTRE_PUNTOS_ATAQUE,
				FRENZY_TERRESTRE_DIST_ATAQUE,
				FRENZY_TERRESTRE_VELOCIDAD);
	}
			
	@Override
	public String avatarModo() {
		return FRENZY_TERRESTRE_AVATAR;
	}

}

