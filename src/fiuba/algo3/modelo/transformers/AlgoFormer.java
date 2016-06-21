package fiuba.algo3.modelo.transformers;

import java.util.Collection;

import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.elementos.Modificadores;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.modelo.modos.Modo;

public abstract class AlgoFormer{
	
	private String nombre;
	private int puntosDeVida;
	private Modificadores bonus;
	private ChispaSuprema chispa;
	private Modo modoActivo;
	private Modo modoInactivo;

	protected AlgoFormer(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		this.nombre = nombre;
		this.puntosDeVida = puntosDeVida;
		this.modoActivo = modoHumanoide;
		this.modoInactivo = modoAlterno;
		this.bonus = new Modificadores();
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getAvatar() {
		return modoActivo.avatarModo();
	}

	public int getPuntosDeVida() {
		return puntosDeVida;
	}

	public int getPtosDeAtaque() {
		return modoActivo.getPtosDeAtaque();
	}

	public int getDistanciaAtaque() {
		return modoActivo.getDistAtaque();
	}

	public int getVelocidad() {
		return modoActivo.getVelocidad();
	}

	public abstract boolean perteneceA(Jugador jugador);
	
	public void cambiarModo() {
		Modo tmp = modoActivo;
		this.modoActivo = modoInactivo;
		this.modoInactivo = tmp;
	}
	
	public EstadoVital getEstadoVital() {
		return new EstadoVital(getPuntosDeVida(), getVelocidad());
	}

	public boolean estaVivo() {
		return puntosDeVida > 0;
	}

	public void absorber(Contenido contenido) {
		contenido.almacenarse(this.bonus, this.chispa);
	}
	
	public Collection<Consecuencia> atravesarEspinas(EstadoVital estado) {
		return modoActivo.atravesarEspinas(estado);
	}

	public boolean tieneBonus(String bonus) {
		return this.bonus.tieneBonus(bonus);
	}
	
	private boolean ataquePosible(int distancia) {
		return (modoActivo.getDistAtaque() >= distancia);
	}
	
	public int getAtaqueModificado() {
		return bonus.modificarAtaque(modoActivo.getPtosDeAtaque());
	}

	public void atacar(AlgoFormer objetivo, int distanciaAObjetivo) {
		if (!ataquePosible(distanciaAObjetivo)) {
			throw new AtaqueInvalidoException();
		}
		objetivo.recibirAtaque(this, getAtaqueModificado());
	}

	protected void recibirAtaque(AlgoFormer atacante, int ataque) {
		this.recibirDanio(bonus.modificarDefensa(ataque));
	}
	
	private void recibirDanio(int ataqueRecibido) {
		this.puntosDeVida -= ataqueRecibido;
	}

	public void descontarTurnos() {
		this.bonus.descontarTurnos();
	}

	public void activarBonus() {
		this.bonus.activarBonus();
	}

	public abstract boolean equipoAutobots();
	
	public abstract boolean equipoDecepticons();
	
//	public abstract void atravesarPantano();
//	
//	public abstract void atravesarNebulosaAndromeda();
//	
//	public abstract void atravesarTormentaPsionica();
	
}

