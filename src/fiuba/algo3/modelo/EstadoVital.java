package fiuba.algo3.modelo;

public class EstadoVital {

	private int puntosDeVidaRestantes;
	private int movimientosRestantes;
	
	public EstadoVital(int puntosDeVidaRestantes, int movimientosRestantes) {
		super();
		this.puntosDeVidaRestantes = puntosDeVidaRestantes;
		this.movimientosRestantes = movimientosRestantes;
	}

	public int getPuntosDeVidaRestantes() {
		return puntosDeVidaRestantes;
	}

	public void setPuntosDeVidaRestantes(int puntosDeVidaRestantes) {
		this.puntosDeVidaRestantes = puntosDeVidaRestantes;
	}

	public int getMovimientosRestantes() {
		return movimientosRestantes;
	}

	public void descontarMovimiento() {
		--this.movimientosRestantes;
	}
	
	public boolean esValido() {
		return movimientosRestantes >= 0;
	}
	
	public boolean estaVivo() {
		return puntosDeVidaRestantes > 0;
	}
	
}
