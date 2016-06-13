package fiuba.algo3.modelo.modos;

import java.util.Collection;

import fiuba.algo3.modelo.Ataque;
import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;

public abstract class UnidadTerrestre extends Modo {
	
	protected UnidadTerrestre(int ptosAtaque, int distAtaque, int velocidad) {
		super(ptosAtaque, distAtaque, velocidad);
	}

	@Override
	public Collection<Consecuencia> atravesarEspinas(EstadoVital estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int atravesarPantano() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void atravesarNebulosaAndromeda() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atravesarTormentaPsionica(Ataque ataque) {
		// TODO Auto-generated method stub
		
	}

}
