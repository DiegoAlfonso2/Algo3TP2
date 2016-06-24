package fiuba.algo3.modelo.modos;

public class BonecrusherAlterno extends UnidadTerrestre {
	
	private final static int BONECRUSHER_TERRESTRE_PUNTOS_ATAQUE = 30;
	private final static int BONECRUSHER_TERRESTRE_DIST_ATAQUE = 3;
	private final static int BONECRUSHER_TERRESTRE_VELOCIDAD = 8;
	private final static String BONECRUSHER_TERRESTRE_AVATAR =
			"Force Protection Industries Buffalo HMPCV buscaminas";
	
	public BonecrusherAlterno() {
		super(BONECRUSHER_TERRESTRE_PUNTOS_ATAQUE, 
				BONECRUSHER_TERRESTRE_DIST_ATAQUE, 
				BONECRUSHER_TERRESTRE_VELOCIDAD);
	}
	
	@Override
	public String avatarModo() {
		return BONECRUSHER_TERRESTRE_AVATAR;
	}

}
