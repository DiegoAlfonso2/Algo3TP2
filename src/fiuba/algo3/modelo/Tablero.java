package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.elementos.Bonus;
import fiuba.algo3.modelo.elementos.Burbuja;
import fiuba.algo3.modelo.elementos.ChispaSuprema;
import fiuba.algo3.modelo.elementos.DobleCanon;
import fiuba.algo3.modelo.elementos.Flash;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.excepciones.PosicionInvalidaException;
import fiuba.algo3.modelo.superficies.Aire;
import fiuba.algo3.modelo.superficies.Espinas;
import fiuba.algo3.modelo.superficies.NebulosaAndromeda;
import fiuba.algo3.modelo.superficies.Nube;
import fiuba.algo3.modelo.superficies.Pantano;
import fiuba.algo3.modelo.superficies.Rocosa;
import fiuba.algo3.modelo.superficies.Superficie;
import fiuba.algo3.modelo.superficies.Terreno;
import fiuba.algo3.modelo.superficies.TormentaPsionica;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Tablero {
	
	private int largoX;
	private int largoY;
	private List<Casillero> casilleros;

	public Tablero(int largoX, int largoY) {
		this.largoX = largoX;
		this.largoY = largoY;
		casilleros = new ArrayList<Casillero>(largoX * largoY);
		for (int i = 1; i <= largoX; ++i) {
			for (int j = 1; j <= largoX; ++j) {
				casilleros.add(new Casillero(new Coordenada(i, j)));
			}
		}
	}

	public AlgoFormer algoFormerEnCasillero(Coordenada ubicacion) {
		return localizarCasillero(ubicacion).obtenerAlgoformer();
	}

	public boolean casilleroVacio(Coordenada ubicacion) {
		return localizarCasillero(ubicacion).estaVacio();
	}

	private Casillero localizarCasillero(Coordenada ubicacion) {
		for (Casillero casillero: casilleros) {
			if (casillero.estaEnPosicion(ubicacion)) {
				return casillero;
			}
		}
		throw new PosicionInvalidaException();
	}

	public void ponerAlgoformer(AlgoFormer personaje, Coordenada ubicacion) {
		localizarCasillero(ubicacion).ponerAlgoformer(personaje);
	}
	
    public void ponerChispaSuprema( ChispaSuprema chispaSuprema, Coordenada ubicacion) {
        localizarCasillero(ubicacion).ponerContenido(chispaSuprema);
    }

	public void sacarAlgoformer(AlgoFormer personaje, Coordenada ubicacion) {
		localizarCasillero(ubicacion).sacarAlgoformer();
	}

	public Collection<Consecuencia> atravesarCasillero(Coordenada coordenada, AlgoFormer personaje, EstadoVital estado) {
		Casillero destino = localizarCasillero(coordenada);
		if (destino.hayAlgoformer()){
			throw new MovimientoInvalidoException();
		}
		estado.descontarMovimiento();
		return destino.actuarSobreAlgoformer(personaje, estado);
	}

	public Contenido contenidoEnCasillero(Coordenada ubicacion) {
		return(localizarCasillero(ubicacion).obtenerContenido());
	}

	public void ponerSuperficie(Terreno terreno, Coordenada coordenada) {
		this.localizarCasillero(coordenada).ponerSuperficie(terreno);	
	}
	
	public void ponerSuperficie(Aire espacioAereo, Coordenada coordenada) {
		this.localizarCasillero(coordenada).ponerSuperficie(espacioAereo);	
	}

	public void crearSuperficies() {
		for (int filas = 1 ; filas < (this.largoX + 1) ; filas++){
			for (int columnas = 1 ; columnas < (this.largoY + 1) ; columnas ++){
				this.ponerSuperficie(new Rocosa(), new Coordenada(filas,columnas));
				this.ponerSuperficie(new Nube(), new Coordenada(filas,columnas));
			}
		}
		// Hardcodeo las Zonas de Pantanos.
		this.ponerSuperficie(new Pantano(), new Coordenada(1,2));
		this.ponerSuperficie(new Pantano(), new Coordenada(2,8));
		this.ponerSuperficie(new Pantano(), new Coordenada(4,4));
		this.ponerSuperficie(new Pantano(), new Coordenada(4,7));
		this.ponerSuperficie(new Pantano(), new Coordenada(9,2));
		this.ponerSuperficie(new Pantano(), new Coordenada(9,8));
		this.ponerSuperficie(new Pantano(), new Coordenada(9,10));
		
		// Hardcodeo las Zonas de Espinas.
		this.ponerSuperficie(new Espinas(), new Coordenada(1,4));
		this.ponerSuperficie(new Espinas(), new Coordenada(2,1));
		this.ponerSuperficie(new Espinas(), new Coordenada(2,6));
		this.ponerSuperficie(new Espinas(), new Coordenada(3,9));
		this.ponerSuperficie(new Espinas(), new Coordenada(4,5));
		this.ponerSuperficie(new Espinas(), new Coordenada(5,10));
		this.ponerSuperficie(new Espinas(), new Coordenada(8,1));
        this.ponerSuperficie(new Espinas(), new Coordenada(8,6));
        this.ponerSuperficie(new Espinas(), new Coordenada(9,4));
        this.ponerSuperficie(new Espinas(), new Coordenada(9,9));
        
        // Hardcodeo las Zonas de Nebulosas de Andr�meda.
		this.ponerSuperficie(new NebulosaAndromeda(), new Coordenada(1,6));
        this.ponerSuperficie(new NebulosaAndromeda(), new Coordenada(2,10));
        this.ponerSuperficie(new NebulosaAndromeda(), new Coordenada(3,8));
        this.ponerSuperficie(new NebulosaAndromeda(), new Coordenada(4,2));
        this.ponerSuperficie(new NebulosaAndromeda(), new Coordenada(7,4));
        this.ponerSuperficie(new NebulosaAndromeda(), new Coordenada(7,9));
        this.ponerSuperficie(new NebulosaAndromeda(), new Coordenada(9,6));
        this.ponerSuperficie(new NebulosaAndromeda(), new Coordenada(10,4));
        
        // Hardcodeo las Zonas de Tormentas Psi�nicas.
        this.ponerSuperficie(new TormentaPsionica(), new Coordenada(2,3));
        this.ponerSuperficie(new TormentaPsionica(), new Coordenada(2,9));
        this.ponerSuperficie(new TormentaPsionica(), new Coordenada(4,3));
        this.ponerSuperficie(new TormentaPsionica(), new Coordenada(4,6));
        this.ponerSuperficie(new TormentaPsionica(), new Coordenada(7,1));
        this.ponerSuperficie(new TormentaPsionica(), new Coordenada(7,6));
        this.ponerSuperficie(new TormentaPsionica(), new Coordenada(10,5));
	}

	public void inicializarAlgoformers(List<AlgoFormer> autobots, List<AlgoFormer> decepticons) {
		this.ponerAlgoformer(autobots.get(0), new Coordenada(1,1));
        this.ponerAlgoformer(autobots.get(1), new Coordenada(3,1));
        this.ponerAlgoformer(autobots.get(2), new Coordenada(1,3));
        this.ponerAlgoformer(decepticons.get(0), new Coordenada(10,10));
        this.ponerAlgoformer(decepticons.get(1), new Coordenada(10,8));
        this.ponerAlgoformer(decepticons.get(2), new Coordenada(8,10));
	}

	public void crearBonus() {
		this.ponerBonus(new Burbuja(), new Coordenada(3,4));
		this.ponerBonus(new Burbuja(), new Coordenada(5,7));
		this.ponerBonus(new Burbuja(), new Coordenada(8,6));
		this.ponerBonus(new Burbuja(), new Coordenada(10,2));
		
		this.ponerBonus(new DobleCanon(), new Coordenada(2,10));
		this.ponerBonus(new DobleCanon(), new Coordenada(4,7));
		this.ponerBonus(new DobleCanon(), new Coordenada(7,1));
		this.ponerBonus(new DobleCanon(), new Coordenada(10,4));
		
		this.ponerBonus(new Flash(), new Coordenada(1,6));
		this.ponerBonus(new Flash(), new Coordenada(4,3));
		this.ponerBonus(new Flash(), new Coordenada(6,9));
		this.ponerBonus(new Flash(), new Coordenada(9,4));
	}
	
	private void ponerBonus(Bonus bonus, Coordenada coordenada) {
		this.localizarCasillero(coordenada).ponerBonus(bonus);
	}

	public void efectuarAtaque(Coordenada coordAtacante, Coordenada coordDefensor) {
//		this.algoFormerEnCasillero(defensor).recibirAtaque(this.algoFormerEnCasillero(atacante).atacar());
		AlgoFormer atacante = algoFormerEnCasillero(coordAtacante);
		AlgoFormer atacado = algoFormerEnCasillero(coordDefensor);
		atacante.atacar(atacado, coordAtacante.distanciaHasta(coordDefensor));
		if (!atacado.estaVivo())
			localizarCasillero(coordDefensor).sacarAlgoformer();
	}

	public Superficie obtenerSuperficieAerea(Coordenada coordenada){
		return this.localizarCasillero(coordenada).obtenerAereo();
	}
	
	public Superficie obtenerSuperficieTerrestre(Coordenada coordenada) {
		return this.localizarCasillero(coordenada).obtenerTerreno();
	}
	
}

