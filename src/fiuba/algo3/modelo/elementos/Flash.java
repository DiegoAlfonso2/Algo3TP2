package fiuba.algo3.modelo.elementos;

public class Flash extends ModificadorAgotable {

    private final static String NOMBRE = "Flash";
    private final static int DURACION_TURNOS = 3;

    public Flash() {
        super(DURACION_TURNOS);
    }

    @Override
    public String getNombre() {
        return NOMBRE;
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
		if (this.estaActivo ())
			return velocidadParcial * 3;
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
