package fiuba.algo3.modelo.modos;

public class OptimusAlterno extends Terrestre {

	@Override
	public Modo cambiarModo() {
		return new OptimusHumanoide();
	}

	@Override
	public String avatarModo() {
		return "Peterbilt 379";
	}

	@Override
	public int ataqueModo() {
		return 15;
	}

	@Override
	public int distAtaqueModo() {
		return 4;
	}

	@Override
	public int velocidadModo() {
		return 5;
	}

}

