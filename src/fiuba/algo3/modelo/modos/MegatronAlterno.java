package fiuba.algo3.modelo.modos;

public class MegatronAlterno extends UnidadAerea {
	
	private final static int MEGATRON_ALTERNO_PUNTOS_ATAQUE = 55;
	private final static int MEGATRON_ALTERNO_DIST_ATAQUE = 2;
	private final static int MEGATRON_ALTERNO_VELOCIDAD = 8;
	private final static String MEGATRON_ALTERNO_AVATAR =
			"Jet Cibertroniano";
	
	public MegatronAlterno() {
		super(MEGATRON_ALTERNO_PUNTOS_ATAQUE,
				MEGATRON_ALTERNO_DIST_ATAQUE,
				MEGATRON_ALTERNO_VELOCIDAD);
	}

	@Override
	public String avatarModo() {
		return MEGATRON_ALTERNO_AVATAR;
	}

}

