package fiuba.algo3.modelo.modos;

public class MegatronAlterno extends Aereo {

	@Override
	public Modo cambiarModo() {
		return new MegatronHumanoide();
	}

	@Override
	public String avatarModo() {
		return "Jet Cibertroniano";
	}

	@Override
	public int ataqueModo() {
		return 55;
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

