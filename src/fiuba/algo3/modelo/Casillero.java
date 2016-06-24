package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.modelo.acciones.consecuencias.AbsorberContenido;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.elementos.Bonus;
import fiuba.algo3.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.superficies.Aire;
import fiuba.algo3.modelo.superficies.Nube;
import fiuba.algo3.modelo.superficies.Rocosa;
import fiuba.algo3.modelo.superficies.Superficie;
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
		this.contenido = null;
		this.algoformer = null;
		this.terreno = new Rocosa();
		this.espacioAereo = new Nube();
	}
	
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
		return this.contenido == null;
	}

	public Contenido obtenerContenido() {
		if (this.contenido == null) {
			throw new CasilleroVacioException();
		}
		return this.contenido;
	}

	public Collection<Consecuencia> actuarSobreAlgoformer(AlgoFormer personaje, EstadoVital estado) {
		Collection<Consecuencia> consecuenciasDeActuarSobreAlgoformer = new ArrayList<Consecuencia>();
		if (this.contenido != null) {
			consecuenciasDeActuarSobreAlgoformer.add(new AbsorberContenido(this));
		}
		if (this.terreno != null) {
			consecuenciasDeActuarSobreAlgoformer.addAll(terreno.actuarSobreAlgoformer(personaje, estado));
		}
		if (this.espacioAereo != null) {
			consecuenciasDeActuarSobreAlgoformer.addAll(espacioAereo.actuarSobreAlgoformer(personaje, estado));
		}
		return consecuenciasDeActuarSobreAlgoformer;
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

	public void ponerBonus(Bonus bonus) {
		this.contenido = bonus;
	}

	public void sacarContenido() {
		this.contenido = null;
	}

	public Superficie obtenerTerreno(){
		return (this.terreno);
	}
	
	public Superficie obtenerAereo(){
		return (this.espacioAereo);
	}
	
}
