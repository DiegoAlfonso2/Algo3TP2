package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Ataque;
import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.elementos.Bonus;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.modos.Modo;

public abstract class AlgoFormer{
	
	protected String nombre;
	protected String avatar;
	protected Ataque ataque;
	protected int distAtaque;
	protected int velocidad;
	protected int puntosDeVida;
	protected int movimientos;
	protected Bonus bonus;
    protected ChispaSuprema chispa;
	protected Modo modoActivo;

	/*public AlgoFormer(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		this.nombre = nombre;
		this.puntosDeVida = puntosDeVida;
		this.modoActivo = modoHumanoide;
		this.modoInactivo = modoAlterno;
	}
    */

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
		return this.ataque.getPtosDeAtaque();
	}

	public int getDistanciaAtaque() {
		return this.distAtaque;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public void cambiarModo() {
		this.modoActivo = modoActivo.cambiarModo();
		this.setearCaracteristicas(modoActivo);
	}
	
	protected void setearCaracteristicas(Modo modo) {
		this.avatar = modo.avatarModo();
		this.ataque.setPtosDeAtaque(modo.ataqueModo());
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
	
}

