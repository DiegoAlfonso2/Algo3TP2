package fiuba.algo3.modelo;

public class Modo {

	private String avatar;
	private int ataque;
	private int distAtaque;
	private int velocidad;

	public Modo(String avatar, int ataque, int distAtaque, int velocidad) {
		this.avatar = avatar;
		this.ataque = ataque;
		this.distAtaque = distAtaque;
		this.velocidad = velocidad;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDistAtaque() {
		return distAtaque;
	}

	public void setDistAtaque(int distAtaque) {
		this.distAtaque = distAtaque;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}
