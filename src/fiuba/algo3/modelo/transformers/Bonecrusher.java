package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.modos.BonecrusherHumanoide;
import fiuba.algo3.modelo.modos.Modo;

public class Bonecrusher extends Decepticon{

    public Bonecrusher() {
        this.nombre = "Bonecrusher";
        this.puntosDeVida = 200;
        this.modoActivo = new BonecrusherHumanoide();
        this.setearCaracteristicas(this.modoActivo);
    }
	
	private void setearCaracteristicas(Modo modo) {
		this.avatar = modo.avatarModo();
		this.ataque = modo.ataqueModo();
		this.distAtaque = modo.distAtaqueModo();
		this.velocidad = modo.velocidadModo();
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
		this.modoActivo.atravesarTormentaPsionica();
	}
	
}