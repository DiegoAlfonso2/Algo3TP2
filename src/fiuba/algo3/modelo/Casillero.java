package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.superficies.Aire;
import fiuba.algo3.modelo.superficies.Terreno;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Casillero {
	
	private Terreno terreno;
	private Aire espacioAereo;
	private Coordenada posicion;
	private AlgoFormer algoformer;
	private Contenido contenido;
		
	public Casillero(Coordenada posicion) {
		this.posicion = posicion;
		this.algoformer = null;
	}
	
	// TODO ver como usar esto en lugar de cada metodo por separado
    public void ponerContenido(Contenido unContenido) {
        if (this.contenido != null) {
            throw new CasilleroOcupadoException();
        }
        this.contenido = unContenido;
    }

	public void ponerAlgoformer(AlgoFormer personaje) {
		if (this.algoformer != null) {
			throw new CasilleroOcupadoException();
		}
		this.algoformer = personaje;
	}
	
	public AlgoFormer obtenerAlgoformer() {
		if (this.algoformer == null) {
			throw new CasilleroVacioException();
		}
		return this.algoformer;
	}
	
	public void sacarAlgoformer() {
		if (this.algoformer == null) {
			throw new CasilleroVacioException();
		}
		this.algoformer = null;
	}

	public boolean estaEnPosicion(Coordenada posicion) {
		return this.posicion.equals(posicion);
	}
	
	public boolean estaVacio() {
		return (this.algoformer == null && this.contenido == null);
	}

	public Contenido obtenerContenido() {
		if (this.contenido == null) {
			throw new CasilleroVacioException();
		}
		return this.contenido;
	}

	public void actuarSobreAlgoformer(AlgoFormer personaje) {
		if (this.contenido != null) {
			personaje.absorber(contenido);
		}
		if (this.terreno != null) {
			terreno.actuarSobreAlgoformer(personaje);
		}
		if (this.espacioAereo != null) {
			espacioAereo.actuarSobreAlgoformer(personaje);
		}
	}

	public void ponerSuperficie(Terreno terreno) {
		this.terreno = terreno;
	}
	
	public void ponerSuperficie(Aire aire) {
		this.espacioAereo = aire;
	}
	
	public boolean hayAlgoformer() {
		return !(algoformer == null);
	}
	
}
