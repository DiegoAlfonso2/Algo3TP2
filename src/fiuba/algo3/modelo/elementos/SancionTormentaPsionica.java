package fiuba.algo3.modelo.elementos;

public class SancionTormentaPsionica extends Bonus {

	public SancionTormentaPsionica() {
		this.nombre = "Sancion Tormenta Psionica";
		this.activo = false;
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
    public boolean modificarFusionable() {
        return false;
    }

    public void descontarTurno() {
		// Este metodo no hace nada ya que la Tormenta Psionica afecta el ataque durante toda la partida.
	}
	
}
