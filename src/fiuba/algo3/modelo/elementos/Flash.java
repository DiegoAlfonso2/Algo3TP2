package fiuba.algo3.modelo.elementos;

public class Flash extends Bonus {

	public Flash() {
		this.nombre = "Flash";
		this.activo = false;
	}

	@Override
	public int modificarAtaque(int ataqueParcial) {
		return ataqueParcial;
	}

	@Override
	public int modificarDefensa(int ataqueRecibido) {
		return ataqueRecibido;
	}

	@Override
	public int modificarVelocidad(int velocidadParcial) {
		if (this.activo)
			return velocidadParcial * 3;
		return velocidadParcial;
	}
	
}
