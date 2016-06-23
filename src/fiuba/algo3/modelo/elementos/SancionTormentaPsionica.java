package fiuba.algo3.modelo.elementos;

public class SancionTormentaPsionica extends Bonus {

    private final static String NOMBRE = "Sancion Tormenta Psionica";

    @Override
    public String getNombre() { return NOMBRE; }

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
    public boolean modificarFusionable() {
        return false;
    }

    @Override
    public void descontarTurno() {

    }

}

