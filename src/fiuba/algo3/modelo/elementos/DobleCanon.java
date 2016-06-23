package fiuba.algo3.modelo.elementos;

public class DobleCanon extends ModificadorAgotable {
	
	private final static String NOMBRE = "Doble Canon";
	private final static int DURACION_TURNOS = 3;

	public DobleCanon() {
		super(DURACION_TURNOS);
	}

	@Override
	public String getNombre() {
		return NOMBRE;
	}
	
	@Override
	public int modificarAtaque(int ataqueParcial) {
		return estaActivo() ? ataqueParcial * 2 : ataqueParcial;
	}

	@Override
	public int modificarDefensa(int ataqueRecibido) {
		return ataqueRecibido;
	}

	@Override
	public int modificarVelocidad(int velocidadParcial) {
		return velocidadParcial;
	}
	
}
