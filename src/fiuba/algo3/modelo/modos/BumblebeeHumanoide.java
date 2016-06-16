package fiuba.algo3.modelo.modos;

public class BumblebeeHumanoide extends Humanoide {

	@Override
	public Modo cambiarModo() {
		return new BumblebeeAlterno();
	}

	@Override
	public String avatarModo() {
		return "Bumblebee Humanoide";
	}

	@Override
	public int ataqueModo() {
		return 40;
	}

	@Override
	public int distAtaqueModo() {
		return 1;
	}

	@Override
	public int velocidadModo() {
		return 2;
	}

}

