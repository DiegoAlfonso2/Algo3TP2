package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.transformers.*;

public class JugadorAutobots extends Jugador {

	public JugadorAutobots(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<AlgoFormer>();
		this.equipo.add(new Optimus());
		this.equipo.add(new Bumblebee());
		this.equipo.add(new Ratchet());
        this.equipo.add(new Superion (new Optimus(),new Ratchet(),new Bumblebee()));
	}

	@Override
	public boolean lePertenece(AlgoFormer personaje) {
		return personaje.perteneceA(this);
	}

}
