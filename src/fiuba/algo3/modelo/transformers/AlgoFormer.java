package fiuba.algo3.modelo.transformers;

import java.util.Collection;

import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.elementos.Bonus;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.modos.Modo;

public abstract class AlgoFormer{
	
	protected String nombre;
	protected String avatar;
	protected int puntosDeVida;
	protected Bonus bonus;
    protected ChispaSuprema chispa;
	protected Modo modoActivo;
	protected Modo modoInactivo;

	protected AlgoFormer(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		this.nombre = nombre;
		this.puntosDeVida = puntosDeVida;
		this.modoActivo = modoHumanoide;
		this.modoInactivo = modoAlterno;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getAvatar() {
		return this.avatar;
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

	public void absorber(Bonus bonus) {
		this.bonus = bonus;
	}
	
	public void absorber(ChispaSuprema chispa) {
		this.chispa = chispa;
	}
	
	public void absorber(Contenido contenido) {
		this.bonus = contenido.definirBonus();
		this.chispa = contenido.definirChispa();
	}
	
	public Collection<Consecuencia> atravesarEspinas(EstadoVital estado) {
		return modoActivo.atravesarEspinas(estado);
	}
	
//	public abstract void atravesarPantano();
//	
//	public abstract void atravesarNebulosaAndromeda();
//	
//	public abstract void atravesarTormentaPsionica();
	
}

