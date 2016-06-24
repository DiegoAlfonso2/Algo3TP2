package fiuba.algo3.modelo.modos;

/**
 * Created by Julian Garate on 6/21/16.
 */
public class MenasorUnico extends Humanoide {
    private final static int MENASOR_HUMANOIDE_PUNTOS_ATAQUE = 40;
    private final static int MENASOR_HUMANOIDE_DIST_ATAQUE = 1;
    private final static int MENASOR_HUMANOIDE_VELOCIDAD = 2;
    private final static String MENASOR_HUMANOIDE_AVATAR =
            "Menasor";

    public MenasorUnico() {
        super(MENASOR_HUMANOIDE_PUNTOS_ATAQUE,
                MENASOR_HUMANOIDE_DIST_ATAQUE,
                MENASOR_HUMANOIDE_VELOCIDAD);
    }

    @Override
    public String avatarModo() {
        return MENASOR_HUMANOIDE_AVATAR;
    }
}
