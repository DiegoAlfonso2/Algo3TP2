package fiuba.algo3.modelo.modos;

public class BumblebeeAlterno extends Terrestre {

	@Override
	public Modo cambiarModo() {
		return new BumblebeeHumanoide();
	}

	@Override
	public String avatarModo() {
		return "Chevrolet Camaro Concept";
	}

	@Override
	public int ataqueModo() {
		return 20;
	}

	@Override
	public int distAtaqueModo() {
		return 3;
	}

	@Override
	public int velocidadModo() {
		return 15;
	}

}
