package fiuba.algo3.modelo.modos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.acciones.consecuencias.RecibirDanio;

public abstract class UnidadTerrestre extends Modo {
	
	protected UnidadTerrestre(int ptosAtaque, int distAtaque, int velocidad) {
		super(ptosAtaque, distAtaque, velocidad);
	}

	@Override
	public Collection<Consecuencia> atravesarEspinas(EstadoVital estado) {
		int ptosVidaRestantes = estado.getPuntosDeVidaRestantes();
		int danio = (int) Math.floor(ptosVidaRestantes * 0.05);
		danio = danio < 1 ? 1 : danio;
		estado.setPuntosDeVidaRestantes(ptosVidaRestantes - danio);
		Collection<Consecuencia> consecuencias = new ArrayList<Consecuencia>();
		consecuencias.add(new RecibirDanio(danio));
		return consecuencias;
	}

	@Override
	public Collection<Consecuencia> atravesarPantano(EstadoVital estado) {
		estado.descontarMovimiento();
		return Collections.emptyList();
	}

	@Override
	public Collection<Consecuencia> atravesarNebulosaAndromeda(EstadoVital estado) {
		return Collections.emptyList();
	}

	@Override
	public Collection<Consecuencia> atravesarTormentaPsionica(EstadoVital estado) {
		return Collections.emptyList();
	}

}
