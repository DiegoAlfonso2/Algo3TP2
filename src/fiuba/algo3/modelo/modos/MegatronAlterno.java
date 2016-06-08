package fiuba.algo3.modelo.modos;

import fiuba.algo3.modelo.Ataque;

public class MegatronAlterno extends Modo {

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
	public void atravesarTormentaPsionica(Ataque ataque) {
		if (!ataque.sufrioModificacionPsionica()) {
			ataque.modificacionPsionica();
		}
	}

}

