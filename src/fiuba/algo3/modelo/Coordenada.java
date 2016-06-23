package fiuba.algo3.modelo;

public class Coordenada {
	private int x;
	private int y;

	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Devuelve la distancia Chebyshov entre dos coordenadas del tablero (
	 * siendo _this_ una de ellas).
	 * @param otra Coordenada contra la que se quiere medir la distancia
	 * @return
	 */
	public int distanciaHasta(Coordenada otra) {
		return Math.max(Math.abs(this.x - otra.x), Math.abs(this.y - otra.y));
	}
	
	/**
	 * Indica si dos casilleros representados por sus coordenadas son adyacentes 
	 * (estan uno al lado del otro, uno arriba del otro o en diagonal).
	 * @param otra Coordenada contra la que se quiere hacer la comprobacion
	 * @return
	 */
	public boolean esConsecutiva(Coordenada otra) {
		return distanciaHasta(otra) <= 1;
	}
    public int distanciaHasta(Coordenada otra){
        return Math.max (Math.abs(this.x - otra.x), Math.abs(this.y - otra.y));
    }

	@Override
	public boolean equals(Object otroObjeto) {
		try {
			Coordenada otraCoordenada = (Coordenada) otroObjeto;
			return this.x == otraCoordenada.x && this.y == otraCoordenada.y;
		} catch (ClassCastException cce) {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int seed = 2;
		seed ^= x + 0x9e3779b9 + (seed << 6) + (seed >> 2);
		seed ^= y + 0x9e3779b9 + (seed << 6) + (seed >> 2);
		return seed;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
