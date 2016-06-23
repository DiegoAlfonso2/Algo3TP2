package fiuba.algo3.modelo.transformers;

import java.util.Collection;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.elementos.Modificadores;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.modos.Modo;

public abstract class AlgoFormer{
	
	private String nombre;
	private int puntosDeVida;
	private Modificadores bonus;
	private ChispaSuprema chispa;
	private Modo modoActivo;
	private Modo modoInactivo;
    private boolean disponible;
    private boolean fusionable;
    private boolean ganador;

	protected AlgoFormer(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		this.nombre = nombre;
		this.puntosDeVida = puntosDeVida;
		this.modoActivo = modoHumanoide;
		this.modoInactivo = modoAlterno;
		this.bonus = new Modificadores();
        this.disponible = true;
        this.fusionable = false;

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

	public abstract boolean perteneceA(JugadorAutobots jugador);
	public abstract boolean perteneceA(JugadorDecepticons jugador);
	
	public void transformar() {
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
	
	protected boolean ataquePosible(int distancia) {
		return (modoActivo.getDistAtaque() >= distancia);
	}

	public int getAtaqueModificado() {
		return bonus.modificarAtaque(modoActivo.getPtosDeAtaque());
	}

	public abstract void atacar(AlgoFormer objetivo, int distanciaAObjetivo);

	protected abstract void recibirAtaque(Autobot atacante, int ataque);
	protected abstract void recibirAtaque(Decepticon atacante, int ataque);
	
	public void recibirDanio(int ataqueRecibido) {
		this.puntosDeVida -= ataqueRecibido;
	}

	public void descontarTurnos() {
		this.bonus.descontarTurnos();
	}

	public void activarBonus() {
		this.bonus.activarBonus();
	}

    public void actualizarEstado(){
        disponible = this.bonus.disponibilidad ();
        fusionable = this.bonus.fusionable ();
    }

    public boolean esfusionable(){
        return this.fusionable;
    }

    public boolean estaActivado() { return this.disponible; }

	public Collection<Consecuencia> atravesarPantano(EstadoVital estado) {
		return modoActivo.atravesarPantano(estado);
	}

    public void completoChispa() {
    }

//	public abstract void atravesarPantano();
//	
//	public abstract void atravesarNebulosaAndromeda();
//	
//	public abstract void atravesarTormentaPsionica();
	
}

