package fiuba.algo3.tests.mocks;

import fiuba.algo3.modelo.modos.UnidadTerrestre;

public class AlgoTerrestreMock extends UnidadTerrestre {

	public AlgoTerrestreMock(int ptosAtaque, int distAtaque, int velocidad) {
		super(ptosAtaque, distAtaque, velocidad);
	}

	@Override
	public String avatarModo() {
		return "Unidad Terrestre Mock";
	}

}
