package fiuba.algo3.modelo.transformers;

import java.util.Collection;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.elementos.Bonus;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.elementos.Modificadores;
import fiuba.algo3.modelo.excepciones.AlgoformerInactivoException;
import fiuba.algo3.modelo.modos.Modo;

public abstract class AlgoFormer{
	
	private String nombre;
	private int puntosDeVida;
	private Modificadores modificadores;
	private ChispaSuprema chispa;
	private Modo modoActivo;
	private Modo modoInactivo;
    private boolean disponible;
    private boolean ganador;

	protected AlgoFormer(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		this.nombre = nombre;
		this.puntosDeVida = puntosDeVida;
		this.modoActivo = modoHumanoide;
		this.modoInactivo = modoAlterno;
		this.modificadores = new Modificadores();
        this.disponible = true;
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

	public int getAtaqueModificado() {
		return modificadores.modificarAtaque(getPtosDeAtaque());
	}

	public int getDistanciaAtaque() {
		return modoActivo.getDistAtaque();
	}

	public int getDistanciaAtaqueModificada() {
		return getDistanciaAtaque();
	}

	public int getVelocidad() {
		return modoActivo.getVelocidad();
	}

	public int getVelocidadModificada() {
		return modificadores.modificarVelocidad(getVelocidad());
	}

	public EstadoVital getEstadoVital() {
		return new EstadoVital(getPuntosDeVida(), getVelocidadModificada());
	}

	public void transformar() {
		Modo tmp = modoActivo;
		this.modoActivo = modoInactivo;
		this.modoInactivo = tmp;
	}

	public boolean estaVivo() {
		return puntosDeVida > 0;
	}

	public void absorber(Bonus contenido) {
		modificadores.agregar(contenido);
	}

	public void absorber(ChispaSuprema contenido) {
		chispa = contenido;
	}
	
	public Collection<Consecuencia> atravesarEspinas(EstadoVital estado) {
		return modoActivo.atravesarEspinas(estado);
	}

	public Collection<Consecuencia> atravesarPantano(EstadoVital estado) {
		return modoActivo.atravesarPantano(estado);
	}
	
	public Collection<Consecuencia> atravesarTormentaPsionica(EstadoVital estado) {
		return modoActivo.atravesarTormentaPsionica(estado);
	}
	
	public Collection<Consecuencia> atravesarNebulosAndromeda(EstadoVital estado) {
		return modoActivo.atravesarNebulosaAndromeda(estado);
	}

	public boolean tieneBonus(String bonus) {
		return this.modificadores.tieneBonus(bonus);
	}
	
	protected boolean ataquePosible(int distancia) {
		return (modoActivo.getDistAtaque() >= distancia);
	}

	public abstract void atacar(AlgoFormer objetivo, int distanciaAObjetivo);

	protected abstract void recibirAtaque(Autobot atacante, int ataque);
	
	protected abstract void recibirAtaque(Decepticon atacante, int ataque);
	
	public void recibirDanio(int ataqueRecibido) {
		this.puntosDeVida -= ataqueRecibido;
	}

	public abstract boolean perteneceA(JugadorAutobots jugador);
	
	public abstract boolean perteneceA(JugadorDecepticons jugador);

	public void terminarTurno() {
		this.modificadores.descontarTurnos();
		this.modificadores.activarBonus();
        this.actualizarEstado ();
	}

    private void actualizarEstado(){
        disponible = this.modificadores.disponibilidad ();
    }

    public boolean estaActivado() {
    	return this.disponible;
    }

	public boolean estaActivo() {
		return this.disponible;
	}

	public int modificarDefensa(int ataque) {
		return modificadores.modificarDefensa(ataque);
	}

}

