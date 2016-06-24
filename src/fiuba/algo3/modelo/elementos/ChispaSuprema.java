package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class ChispaSuprema implements Contenido{

    private String nombre = "Chispa Suprema";

    public String getNombre() {
        return this.nombre;
    }

	@Override
	public void interactuarCon(AlgoFormer personaje) {
		personaje.absorber(this);
	}
}
