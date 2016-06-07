package fiuba.algo3.modelo.modos;

public class BumblebeeAlterno extends Modo {

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
