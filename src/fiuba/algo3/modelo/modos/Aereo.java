package fiuba.algo3.modelo.modos;

public abstract class Aereo extends Modo {

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
	public void atravesarTormentaPsionica(int ataque) {
		// TODO Auto-generated method stub
	}

}
