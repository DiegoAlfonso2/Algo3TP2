package fiuba.algo3.modelo.modos;

public class FrenzyAlterno extends Terrestre {

	@Override
	public Modo cambiarModo() {
		return new FrenzyHumanoide();	
	}

	@Override
	public String avatarModo() {
		return "Renault Duster";
	}

	@Override
	public int ataqueModo() {
		return 25;
	}

	@Override
	public int distAtaqueModo() {
		return 2;
	}

	@Override
	public int velocidadModo() {
		return 6;
	}

}

