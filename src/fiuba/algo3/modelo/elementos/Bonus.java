package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.Contenido;

public abstract class Bonus implements Contenido {

	protected String nombre;
	protected int turnosRestantes;
	protected boolean activo;
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public Bonus definirBonus() {
		return this;
	}

	@Override
	public ChispaSuprema definirChispa() {
		return null;
	}

	@Override
	public void almacenarse(Modificadores bonus, ChispaSuprema chispa) {
		this.inicializarTurnos();
		bonus.agregar(this);
	}

	public abstract int modificarAtaque(int ataqueParcial);

	public abstract int modificarDefensa(int ataqueRecibido);
	
	public abstract int modificarVelocidad(int velocidadParcial);
	
	public void inicializarTurnos() {
		this.turnosRestantes = 3;
	}
	
	public void descontarTurno() {
		if (this.activo)
			this.turnosRestantes -= 1;
	}

	public void activarBonus() {
		this.activo = true;
	}
	
}
