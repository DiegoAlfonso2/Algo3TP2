package fiuba.algo3.modelo.modos;

public class FrenzyHumanoide extends Humanoide {

	@Override
	public Modo cambiarModo() {
		return new FrenzyAlterno();
	}

	@Override
	public String avatarModo() {
		return "Frenzy Humanoide";
	}

	@Override
	public int ataqueModo() {
		return 10;
	}

	@Override
	public int distAtaqueModo() {
		return 5;
	}

	@Override
	public int velocidadModo() {
		return 2;
	}

}

