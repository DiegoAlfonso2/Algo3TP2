package fiuba.algo3.modelo.elementos;

public class Burbuja extends Bonus {

	public Burbuja() {
		this.nombre = "Burbuja";
		this.activo = false;
	}

	@Override
	public int modificarAtaque(int ataqueParcial) {
		return ataqueParcial;
	}

	@Override
	public int modificarDefensa(int ataqueRecibido) {
		if (this.activo)
			return 0;
		return ataqueRecibido;
	}

	@Override
	public int modificarVelocidad(int velocidadParcial) {
		return velocidadParcial;
	}

    @Override
    public boolean algoformerDisponible() {
        return false;
    }
    @Override
    public boolean modificarFusionable() {
        return false;
    }


    public void inicializarTurnos() {
		if (this.activo)
			this.turnosRestantes = 2;
	}
	
}
