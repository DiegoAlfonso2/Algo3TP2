package fiuba.algo3.modelo.modos;

public class RatchetAlterno extends Aereo {

	@Override
	public Modo cambiarModo() {
		return new RatchetHumanoide();
	}

	@Override
	public String avatarModo() {
		return "F22 raptor";
	}

	@Override
	public int ataqueModo() {
		return 35;
	}

	@Override
	public int distAtaqueModo() {
		return 2;
	}

	@Override
	public int velocidadModo() {
		return 8;
	}

}

