package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.elementos.Modificadores;
import fiuba.algo3.modelo.modos.RatchetHumanoide;

public class Ratchet extends Autobot{

    public Ratchet() {
        this.nombre = "Ratchet";
        this.puntosDeVida = 150;
        this.modoActivo = new RatchetHumanoide();
        this.setearCaracteristicas(this.modoActivo);
        this.bonus = new Modificadores();
    }
	
	public void cambiarModo() {
		modoActivo = this.modoActivo.cambiarModo();
		this.setearCaracteristicas(this.modoActivo);
	}

	@Override
	public void atravesarEspinas() {
		this.puntosDeVida = this.modoActivo.atravesarEspinas(this.puntosDeVida);
	}

	@Override
	public void atravesarPantano() {
		this.descontarMovimientoPosible(this.modoActivo.atravesarPantano());
	}
	@Override
	public void atravesarNebulosaAndromeda() {
		this.modoActivo.atravesarNebulosaAndromeda();
	}

	@Override
	public void atravesarTormentaPsionica() {
		this.modoActivo.atravesarTormentaPsionica(this.ataque);
	}
	
}