package fiuba.algo3.modelo;

import fiuba.algo3.modelo.elementos.Bonus;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.elementos.Modificadores;

public interface Contenido {

    public String getNombre();

	public Bonus definirBonus();

	public ChispaSuprema definirChispa();

	public abstract void almacenarse(Modificadores bonus, ChispaSuprema chispa);
    
}
