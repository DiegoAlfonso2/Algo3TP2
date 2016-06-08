package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Ataque;
import fiuba.algo3.modelo.modos.MegatronHumanoide;

public class Megatron extends Decepticon {
	
	public Megatron() {
        this.nombre = "Megatron";
        this.puntosDeVida = 550;
        this.ataque = new Ataque();
        this.modoActivo = new MegatronHumanoide();
        this.setearCaracteristicas(this.modoActivo);
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