package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.transformers.*;

public class JugadorDecepticons extends Jugador {
	
	public JugadorDecepticons(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<AlgoFormer>();		
		this.equipo.add(new Megatron());
		this.equipo.add(new Bonecrusher());
		this.equipo.add(new Frenzy());
        this.equipo.add(new Menasor(new Frenzy(),new Bonecrusher(),new Megatron()));
	}

	@Override
	public boolean lePertenece(AlgoFormer personaje) {
		return personaje.perteneceA(this);
	}
	
}
