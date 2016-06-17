package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.modelo.transformers.Bonecrusher;
import fiuba.algo3.modelo.transformers.Frenzy;
import fiuba.algo3.modelo.transformers.Megatron;

public class JugadorDecepticons extends Jugador {
	
	public JugadorDecepticons(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<AlgoFormer>();		
		this.equipo.add(new Megatron());
		this.equipo.add(new Bonecrusher());
		this.equipo.add(new Frenzy());
	}

	@Override
	public boolean lePertenece(AlgoFormer personaje) {
		return personaje.equipoDecepticons();
	}
	
}
