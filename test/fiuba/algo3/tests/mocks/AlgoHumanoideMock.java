package fiuba.algo3.tests.mocks;

import fiuba.algo3.modelo.modos.Humanoide;

public class AlgoHumanoideMock extends Humanoide {

	protected AlgoHumanoideMock(int ptosAtaque, int distAtaque, int velocidad) {
		super(ptosAtaque, distAtaque, velocidad);
	}

	@Override
	public String avatarModo() {
		return "Mock Humanoide";
	}

}
