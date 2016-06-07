package fiuba.algo3.modelo.modos;

public class FrenzyAlterno extends Modo {

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

	@Override
	public int atravesarEspinas(int puntosDeVida) {
		return (int) (puntosDeVida * 0.95);
	}

	@Override
	public int atravesarPantano() {
		return 2;
	}

	@Override
	public void atravesarNebulosaAndromeda() {
		// TODO Auto-generated method stub
	}

	@Override
	public void atravesarTormentaPsionica() {
		// TODO Auto-generated method stub
	}

}

