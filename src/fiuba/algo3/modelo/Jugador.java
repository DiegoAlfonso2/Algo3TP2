package fiuba.algo3.modelo;

import java.util.List;

import fiuba.algo3.modelo.excepciones.FinalException;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public abstract class Jugador {
	
	protected String nombre;
	private boolean estaJugando;
	protected List<AlgoFormer> equipo;
		
	public void cambiarTurno() {
		this.estaJugando = !this.estaJugando;
	}
    
    abstract public boolean lePertenece(AlgoFormer personaje);

	public void inicializarTurno() {
		this.estaJugando = true;
	}
	
	public List<AlgoFormer> obtenerAlgoformers() {
		return this.equipo;
	}

	public boolean estaActivo() {
		return this.estaJugando;
	}

	public void terminarTurno() {
		for (AlgoFormer algoformer : equipo) {
			algoformer.terminarTurno();
		}
	}

	public void sigueParticipando() {
		boolean sigueJugando = false;
		for (AlgoFormer algoformer : equipo) {
			if (algoformer.estaVivo())
				sigueJugando = true;
		}
		if (!sigueJugando){
			throw new FinalException();
		}
	}

	public String getNombre() {
		return nombre;
	}
    
}
