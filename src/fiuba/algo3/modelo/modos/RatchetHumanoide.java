package fiuba.algo3.modelo.modos;

public class RatchetHumanoide extends Humanoide {

	@Override
	public Modo cambiarModo() {
		return new RatchetAlterno();
	}

	@Override
	public String avatarModo() {
		return "Ratchet Humanoide";
	}

	@Override
	public int ataqueModo() {
		return 5;
	}

	@Override
	public int distAtaqueModo() {
		return 5;
	}

	@Override
	public int velocidadModo() {
		return 1;
	}

}

