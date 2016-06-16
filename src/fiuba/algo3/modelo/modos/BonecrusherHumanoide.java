package fiuba.algo3.modelo.modos;

public class BonecrusherHumanoide extends Humanoide {

	@Override
	public Modo cambiarModo() {
		return new BonecrusherAlterno();
	}

	@Override
	public String avatarModo() {
		return "Bonecrusher Humanoide";
	}

	@Override
	public int ataqueModo() {
		return 30;
	}

	@Override
	public int distAtaqueModo() {
		return 3;
	}

	@Override
	public int velocidadModo() {
		return 1;
	}

}
