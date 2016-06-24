package fiuba.algo3.modelo.modos;

import fiuba.algo3.modelo.transformers.Superion;

/**
 * Created by Julian Garate on 6/21/16.
 */
public class SuperionUnico extends Humanoide {

        private final static int SUPERION_HUMANOIDE_PUNTOS_ATAQUE = 40;
        private final static int SUPERION_HUMANOIDE_DIST_ATAQUE = 1;
        private final static int SUPERION_HUMANOIDE_VELOCIDAD = 2;
        private final static String SUPERION_HUMANOIDE_AVATAR =
                "Superion";

        public SuperionUnico() {
            super(SUPERION_HUMANOIDE_PUNTOS_ATAQUE,
                    SUPERION_HUMANOIDE_DIST_ATAQUE,
                    SUPERION_HUMANOIDE_VELOCIDAD);
        }

        @Override
        public String avatarModo() {
            return SUPERION_HUMANOIDE_AVATAR;
        }

}
