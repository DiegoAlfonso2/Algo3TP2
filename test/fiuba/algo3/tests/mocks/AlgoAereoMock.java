package fiuba.algo3.tests.mocks;

import fiuba.algo3.modelo.modos.UnidadAerea;

public class AlgoAereoMock extends UnidadAerea {

	public AlgoAereoMock(int ptosAtaque, int distAtaque, int velocidad) {
		super(ptosAtaque, distAtaque, velocidad);
	}

	@Override
	public String avatarModo() {
		return "Unidad Aerea Mock";
	}

}
