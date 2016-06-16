package fiuba.algo3.modelo.modos;

public abstract class Terrestre extends Modo {

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
		// No le ocurre nada al atravesar la Nebulosa de Andromeda.
	}

	@Override
	public void atravesarTormentaPsionica(int ataque) {
		// No le ocurre nada al atravesar la Tormenta Psionica.
	}

}
