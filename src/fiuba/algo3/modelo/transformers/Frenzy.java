package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.Ataque;
import fiuba.algo3.modelo.modos.FrenzyHumanoide;

public class Frenzy extends Decepticon{

    public Frenzy() {
        this.nombre = "Frenzy";
        this.puntosDeVida = 400;
        this.ataque = new Ataque();
        this.modoActivo = new FrenzyHumanoide();
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