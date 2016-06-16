package fiuba.algo3.modelo.modos;

public class BonecrusherAlterno extends Terrestre {

	@Override
	public Modo cambiarModo() {
		return new BonecrusherHumanoide();
	}

	@Override
	public String avatarModo() {
		return "Force Protection Industries Buffalo HMPCV buscaminas";
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
		return 8;
	}

}
