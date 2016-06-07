package fiuba.algo3.modelo.modos;

public abstract class Modo {
	
	public abstract Modo cambiarModo();
	
	public abstract String avatarModo();
	
	public abstract int ataqueModo();
	
	public abstract int distAtaqueModo();
	
	public abstract int velocidadModo();

	public abstract int atravesarEspinas(int puntosDeVida);

	public abstract int atravesarPantano();

	public abstract void atravesarNebulosaAndromeda();

	public abstract void atravesarTormentaPsionica();
		
}
