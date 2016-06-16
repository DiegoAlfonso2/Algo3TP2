package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.elementos.Modificadores;
import fiuba.algo3.modelo.modos.BonecrusherHumanoide;

public class Bonecrusher extends Decepticon{

    public Bonecrusher() {
        this.nombre = "Bonecrusher";
        this.puntosDeVida = 200;
        this.modoActivo = new BonecrusherHumanoide();
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