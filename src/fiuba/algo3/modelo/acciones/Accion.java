package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;

public interface Accion {

	void ejecutarSobre(Partida partida, Tablero tablero);
}
