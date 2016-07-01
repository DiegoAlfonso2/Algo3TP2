package fiuba.algo3.modelo.elementos;

public class Burbuja extends ModificadorAgotable {

	private final static String NOMBRE = "Burbuja";
	private final static int DURACION_TURNOS = 2;

	public Burbuja() {
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
		return estaActivo() ? 0 : ataqueRecibido;
	}

	@Override
	public int modificarVelocidad(int velocidadParcial) {
		return velocidadParcial;
	}

    @Override
    public boolean algoformerDisponible() {
        return true;
    }

}
