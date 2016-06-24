package fiuba.algo3.modelo.modos;

import java.util.Collection;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;

public abstract class Modo {
	
	private int ptosAtaque;
	private int distAtaque;
	private int velocidad;
	
	protected Modo(int ptosAtaque, int distAtaque, int velocidad) {
		this.ptosAtaque = ptosAtaque;
		this.distAtaque = distAtaque;
		this.velocidad = velocidad;
	}
	
	public abstract String avatarModo();
	
	public int getDistAtaque() {
		return this.distAtaque;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public int getPtosDeAtaque() {
		return this.ptosAtaque;
	}

	public abstract Collection<Consecuencia> atravesarEspinas(EstadoVital estado);

	public abstract Collection<Consecuencia> atravesarPantano(EstadoVital estado);
	
	public abstract Collection<Consecuencia> atravesarNebulosaAndromeda(EstadoVital estado);

	public abstract Collection<Consecuencia> atravesarTormentaPsionica(EstadoVital estado);
		
}
