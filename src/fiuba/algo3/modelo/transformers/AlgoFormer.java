package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.elementos.Modificadores;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.modos.Modo;

public abstract class AlgoFormer{
	
	protected String nombre;
	protected String avatar;
	protected int ataque;
	protected int distAtaque;
	protected int velocidad;
	protected int puntosDeVida;
	protected int movimientos;
	protected Modificadores bonus;
    protected ChispaSuprema chispa;
	protected Modo modoActivo;

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
		return this.ataque;
	}

	public int getDistanciaAtaque() {
		return this.distAtaque;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public abstract boolean perteneceA(Jugador jugador);
	
	public void cambiarModo() {
		this.modoActivo = modoActivo.cambiarModo();
		this.setearCaracteristicas(modoActivo);
	}
	
	protected void setearCaracteristicas(Modo modo) {
		this.avatar = modo.avatarModo();
		this.ataque = modo.ataqueModo();
		this.distAtaque = modo.distAtaqueModo();
		this.velocidad = modo.velocidadModo();
	}

	public boolean estaVivo() {
		return puntosDeVida > 0;
	}

	public void validarMovimiento(int cantMov) {
		if (cantMov > this.velocidad){
			throw new MovimientoInvalidoException();
		}	
	}

	public void absorber(Contenido contenido) {
		contenido.almacenarse(this.bonus, this.chispa);
	}

	public abstract void atravesarEspinas();
	
	public abstract void atravesarPantano();
	
	public abstract void atravesarNebulosaAndromeda();
	
	public abstract void atravesarTormentaPsionica();

	public void resetearMovimientosPosibles() {
		this.movimientos = this.velocidad;
	}

	public boolean poseeMovimientosPosibles() {
		return (this.movimientos > 0);
	}

	public void descontarMovimientoPosible(int i) {
		this.movimientos -= 1;
	}

	public boolean tieneBonus(String bonus) {
		return this.bonus.tieneBonus(bonus);
	}
	
	public boolean ataquePosible(int distancia) {
		return (distAtaque >= distancia);
	}

	public int atacar() {
		return bonus.modificarAtaque(this.ataque);
	}

	public void recibirAtaque(int ataque) {
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
	
}

