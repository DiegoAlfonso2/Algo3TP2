package fiuba.algo3.modelo.modos;

public class BonecrusherAlterno extends Modo {

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
