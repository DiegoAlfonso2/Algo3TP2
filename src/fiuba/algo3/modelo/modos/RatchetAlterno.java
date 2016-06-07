package fiuba.algo3.modelo.modos;

public class RatchetAlterno extends Modo {

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

	@Override
	public int atravesarEspinas(int puntosDeVida) {
		return puntosDeVida;
	}

	@Override
	public int atravesarPantano() {
		return 1;
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

