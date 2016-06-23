package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.excepciones.FinalException;

public class ChispaSuprema implements Contenido{

    private String nombre = "Chispa Suprema";
    private Partida partida;

    public String getNombre() {
        return this.nombre;
    }

	@Override
	public Bonus definirBonus() {
		return null;
	}

	@Override
	public ChispaSuprema definirChispa() {
		return this;
	}

    @Override
    public FlagFusion definirFlagFusion() {
        return null;
    }

    @Override
	public void almacenarse(Modificadores bonus, ChispaSuprema chispa) {
		chispa = this;
		throw new FinalException();
	}
}
