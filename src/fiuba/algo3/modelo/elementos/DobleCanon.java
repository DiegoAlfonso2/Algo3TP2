package fiuba.algo3.modelo.elementos;

public class DobleCanon extends Bonus {

	public DobleCanon() {
		this.nombre = "Doble Canon";
		this.activo = false;
	}

	@Override
	public int modificarAtaque(int ataqueParcial) {
		if (this.activo)
			return ataqueParcial * 2;
		return ataqueParcial;
	}

	@Override
	public int modificarDefensa(int ataqueRecibido) {
		return ataqueRecibido;
	}

	@Override
	public int modificarVelocidad(int velocidadParcial) {
		return velocidadParcial;
	}

    @Override
    public boolean algoformerDisponible() {
        return true;
    }

    @Override
    public boolean modificarFusionable() {
        return false;
    }

}
