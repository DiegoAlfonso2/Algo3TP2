package fiuba.algo3.modelo.modos;

public class OptimusHumanoide extends Humanoide {

	@Override
	public Modo cambiarModo() {
		return new OptimusAlterno();
	}

	@Override
	public String avatarModo() {
		return "Optimus Humanoide";
	}

	@Override
	public int ataqueModo() {
		return 50;
	}

	@Override
	public int distAtaqueModo() {
		return 2;
	}

	@Override
	public int velocidadModo() {
		return 2;
	}

}

