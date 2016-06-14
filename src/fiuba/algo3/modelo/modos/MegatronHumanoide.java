package fiuba.algo3.modelo.modos;

public class MegatronHumanoide extends Humanoide {

	private final static int MEGATRON_HUMANOIDE_PUNTOS_ATAQUE = 10;
	private final static int MEGATRON_HUMANOIDE_DIST_ATAQUE = 3;
	private final static int MEGATRON_HUMANOIDE_VELOCIDAD = 1;
	private final static String MEGATRON_HUMANOIDE_AVATAR =
			"Megatron Humanoide";
	
	public MegatronHumanoide() {
		super(MEGATRON_HUMANOIDE_PUNTOS_ATAQUE,
				MEGATRON_HUMANOIDE_DIST_ATAQUE,
				MEGATRON_HUMANOIDE_VELOCIDAD);
	}
	
	@Override
	public String avatarModo() {
		return MEGATRON_HUMANOIDE_AVATAR;
	}

}
