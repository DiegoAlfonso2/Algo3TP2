package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.modos.Modo;
import fiuba.algo3.modelo.modos.OptimusHumanoide;

public class Optimus extends Autobot{

    public Optimus() {
        this.nombre = "Optimus";
        this.puntosDeVida = 500;
        this.modoActivo = new OptimusHumanoide();
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
