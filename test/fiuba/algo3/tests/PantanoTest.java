package fiuba.algo3.tests;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.superficies.Pantano;
import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.tests.mocks.AlgoAereoMock;
import fiuba.algo3.tests.mocks.AlgoFormerMock;
import fiuba.algo3.tests.mocks.AlgoHumanoideMock;
import fiuba.algo3.tests.mocks.AlgoTerrestreMock;

public class PantanoTest {

	@Test(expected=MovimientoInvalidoException.class)
	public void testAtravesarHumanoide_AlternoTerrestre() {
		AlgoFormer humanoideTerrestre = new AlgoFormerMock(
				"AlgoFormer Mock",
				1,
				new AlgoHumanoideMock(1, 1, 1),
				new AlgoTerrestreMock(1, 1, 1));
		Pantano pantano = new Pantano();
		Assert.assertEquals("Mock Humanoide", humanoideTerrestre.getAvatar());
		
		Collection<Consecuencia> consecuencias = pantano.actuarSobreAlgoformer(
				humanoideTerrestre, 
				humanoideTerrestre.getEstadoVital());
		for (Consecuencia c : consecuencias) {
			c.serAfrontadaPor(humanoideTerrestre);
		}
		Assert.fail();
	}
	
	@Test(expected=MovimientoInvalidoException.class)
	public void testAtravesarHumanoide_AlternoAereo() {
		AlgoFormer humanoideAereo = new AlgoFormerMock(
				"AlgoFormer Mock",
				1,
				new AlgoHumanoideMock(1, 1, 1),
				new AlgoAereoMock(1, 1, 1));
		Pantano pantano = new Pantano();
		Assert.assertEquals("Mock Humanoide", humanoideAereo.getAvatar());
		
		Collection<Consecuencia> consecuencias = pantano.actuarSobreAlgoformer(
				humanoideAereo, 
				humanoideAereo.getEstadoVital());
		for (Consecuencia c : consecuencias) {
			c.serAfrontadaPor(humanoideAereo);
		}
		Assert.fail();
	}

}
