package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.modelo.transformers.Bumblebee;
import fiuba.algo3.modelo.transformers.Optimus;
import fiuba.algo3.modelo.transformers.Ratchet;

public class JugadorAutobots extends Jugador {

	public JugadorAutobots(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<AlgoFormer>();
		this.equipo.add(new Optimus());
		this.equipo.add(new Bumblebee());
		this.equipo.add(new Ratchet());
	}

	@Override
	public boolean lePertenece(AlgoFormer personaje) {
		return personaje.equipoAutobots();
	}

}
