package fiuba.algo3.modelo;

public class Ataque {
	
	private int puntos;
	private boolean modificacionPsionica;

	
	public Ataque() {
		this.modificacionPsionica = false;
	}
	
	public int getPtosDeAtaque() {
		return puntos;
	}

	public void setPtosDeAtaque(int puntos) {
		this.puntos = puntos;
	}
	
	public void modificacionPsionica() {
		this.puntos = (int) (this.puntos * 0.6);
		this.modificacionPsionica = true;
	}
	
	public boolean sufrioModificacionPsionica() {
		return modificacionPsionica;
	}

}
