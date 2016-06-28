package fiuba.algo3.modelo.elementos;

public class SancionTormentaPsionica extends Bonus {
	
	private final String NOMBRE = "Sancion Tormenta Psionica";

	public SancionTormentaPsionica() {

	}
	
	@Override
	public String getNombre() {
		return NOMBRE;
	}

    @Override
	public int modificarAtaque(int ataqueParcial) {
		return (int) (ataqueParcial * 0.6);
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
    public void descontarTurno() {

    }

}

