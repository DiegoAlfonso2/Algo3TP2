package fiuba.algo3.modelo.modos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.acciones.consecuencias.PenalizadorTormentaPsionica;

public abstract class UnidadAerea extends Modo {

	protected UnidadAerea(int ptosAtaque, int distAtaque, int velocidad) {
		super(ptosAtaque, distAtaque, velocidad);
	}
	
	@Override
	public Collection<Consecuencia> atravesarEspinas(EstadoVital estado) {
		return Collections.emptyList();
	}

	@Override
	public Collection<Consecuencia> atravesarPantano(EstadoVital estado) {
		return Collections.emptyList();
	}

	@Override
	public Collection<Consecuencia> atravesarNebulosaAndromeda(EstadoVital estado) {
		return Collections.emptyList();
	}

	@Override
	public Collection<Consecuencia> atravesarTormentaPsionica(EstadoVital estado) {
		Collection<Consecuencia> consecuencias = new ArrayList<>();
		consecuencias.add(new PenalizadorTormentaPsionica());
		return consecuencias;
	}

}
