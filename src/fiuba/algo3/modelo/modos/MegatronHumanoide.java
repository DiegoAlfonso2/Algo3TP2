package fiuba.algo3.modelo.modos;

public class MegatronHumanoide extends Humanoide {

	@Override
	public Modo cambiarModo() {
		return new MegatronAlterno();
	}

	@Override
	public String avatarModo() {
		return "Megatron Humanoide";
	}

	@Override
	public int ataqueModo() {
		return 10;
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
