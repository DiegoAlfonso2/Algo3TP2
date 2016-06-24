package fiuba.algo3.modelo.acciones.consecuencias;

import fiuba.algo3.modelo.transformers.AlgoFormer;

public class RecibirDanio implements Consecuencia {
	
	int danio;
	
	public RecibirDanio(int danioAAplicar) {
		this.danio = danioAAplicar;
	}

	@Override
	public void serAfrontadaPor(AlgoFormer personaje) {
		personaje.recibirDanio(danio);
	}

}
