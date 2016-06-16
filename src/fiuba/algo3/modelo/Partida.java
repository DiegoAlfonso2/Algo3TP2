package fiuba.algo3.modelo;

import fiuba.algo3.modelo.acciones.Accion;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.excepciones.JuegoNoEstaActivoException;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Partida {

	private Tablero tablero;
	Jugador jugador1;
	Jugador jugador2;
	private boolean jugando;
	
	public Partida(Jugador jugador1, Jugador jugador2) {
		(this.jugador1 = jugador1).inicializarTurno();
		this.jugador2 = jugador2;
		this.tablero = new Tablero(10, 10);

		tablero.crearBonus();
		tablero.crearSuperficies();
		tablero.inicializarAlgoformers(this.jugador1.obtenerAlgoformers(), this.jugador2.obtenerAlgoformers());
        tablero.ponerChispaSuprema(new ChispaSuprema(),new Coordenada(6,5));

		this.jugando = true;
	}
	
	public void jugar(Accion accion) {
		if (!jugando) {
			throw new JuegoNoEstaActivoException();
		}
		accion.ejecutarSobre(this, this.tablero);
		terminarTurno();
	}
	
	private void terminarTurno(){
		this.hayGanador();
		this.obtenerJugadorActivo().terminarTurno();
		this.obtenerJugadorActivo().activarBonus();
		this.jugador1.cambiarTurno();
		this.jugador2.cambiarTurno();
	}

	private void hayGanador() {
		this.jugador1.sigueParticipando();
		this.jugador2.sigueParticipando();
	}

	public AlgoFormer obtenerAlgoformer(Coordenada ubicacion) {
		return this.tablero.algoFormerEnCasillero(ubicacion);
	}

	public Contenido obtenerContenido(Coordenada ubicacion) {
		return this.tablero.contenidoEnCasillero(ubicacion);
	}
	public String obtenerModoAlgoformer(Coordenada ubicacion) {
		return this.tablero.algoFormerEnCasillero(ubicacion).getAvatar();
	}

	public boolean casilleroVacio(Coordenada ubicacion) {
		return this.tablero.casilleroVacio(ubicacion);
	}

	public int obtenerVidaAlgoFormer(Coordenada ubicacion) {
		return this.tablero.algoFormerEnCasillero(ubicacion).getPuntosDeVida();		
	}
	
	public int obtenerAtaqueAlgoFormer(Coordenada ubicacion) {
		return this.tablero.algoFormerEnCasillero(ubicacion).getPtosDeAtaque();		
	}

	public Jugador obtenerJugadorActivo() {
		if (this.jugador1.estaActivo())
			return this.jugador1;
		return this.jugador2;
	}

	public boolean puedeJugar(Coordenada ubicacion) {
		return (this.obtenerJugadorActivo().lePertenece(this.obtenerAlgoformer(ubicacion)));
	}
	
}
	

