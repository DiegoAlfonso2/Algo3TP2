package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.elementos.Bonus;

/**
 * Created by Julian Garate on 7/1/16.
 */
public class SancionNebulosaAndromeda extends ModificadorAgotable {

        private final static String NOMBRE = "SancionNebulosaAndromeda";
        private final static int DURACION_TURNOS = 3;

        public SancionNebulosaAndromeda() {
            super(DURACION_TURNOS);
        }

        @Override
        public String getNombre() {
            return NOMBRE;
        }

        @Override
        public int modificarAtaque(int ataqueParcial) {
            return ataqueParcial;
        }

        @Override
        public int modificarDefensa(int ataqueRecibido) {
            return ataqueRecibido;
        }

        @Override
        public int modificarVelocidad(int velocidadParcial) {
            return velocidadParcial;
        }

        @Override
        public boolean algoformerDisponible() { return !estaActivo ();   }


    }
