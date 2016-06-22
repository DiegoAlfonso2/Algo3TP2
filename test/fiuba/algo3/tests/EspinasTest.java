package fiuba.algo3.tests;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.superficies.Espinas;
import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.tests.mocks.AlgoAereoMock;
import fiuba.algo3.tests.mocks.AlgoFormerMock;
import fiuba.algo3.tests.mocks.AlgoHumanoideMock;
import fiuba.algo3.tests.mocks.AlgoTerrestreMock;


public class EspinasTest {

	@Test
	public void testAtravesarHumanoide_AlternoTerrestre() {
		int ptosVidaIniciales = 100;
		int danioEsperado = 5;
		AlgoFormer humanoideTerrestre = new AlgoFormerMock(
				"AlgoFormer Mock",
				ptosVidaIniciales,
				new AlgoHumanoideMock(1, 1, 1),
				new AlgoTerrestreMock(1, 1, 1));
		Espinas espinas = new Espinas();
		Assert.assertEquals("Mock Humanoide", humanoideTerrestre.getAvatar());
		Assert.assertEquals(
				humanoideTerrestre.getEstadoVital().getPuntosDeVidaRestantes(),
				ptosVidaIniciales);
		Assert.assertEquals(humanoideTerrestre.getPuntosDeVida(), ptosVidaIniciales);
		
		Collection<Consecuencia> consecuencias = espinas.actuarSobreAlgoformer(
				humanoideTerrestre, 
				humanoideTerrestre.getEstadoVital());
		for (Consecuencia c : consecuencias) {
			c.serAfrontadaPor(humanoideTerrestre);
		}
		int ptosVidaRestantes = ptosVidaIniciales - danioEsperado;
		
		Assert.assertEquals(
				humanoideTerrestre.getEstadoVital().getPuntosDeVidaRestantes(),
				ptosVidaRestantes);
		Assert.assertEquals(humanoideTerrestre.getPuntosDeVida(), ptosVidaRestantes);
		
	}

	@Test
	public void testAtravesarHumanoide_AlternoAereo() {
		int ptosVidaIniciales = 100;
		int danioEsperado = 5;
		AlgoFormer humanoideAereo = new AlgoFormerMock(
				"AlgoFormer Mock",
				ptosVidaIniciales,
				new AlgoHumanoideMock(1, 1, 1),
				new AlgoAereoMock(1, 1, 1));
		Espinas espinas = new Espinas();
		Assert.assertEquals("Mock Humanoide", humanoideAereo.getAvatar());
		Assert.assertEquals(
				humanoideAereo.getEstadoVital().getPuntosDeVidaRestantes(),
				ptosVidaIniciales);
		Assert.assertEquals(humanoideAereo.getPuntosDeVida(), ptosVidaIniciales);
		
		Collection<Consecuencia> consecuencias = espinas.actuarSobreAlgoformer(
				humanoideAereo, 
				humanoideAereo.getEstadoVital());
		for (Consecuencia c : consecuencias) {
			c.serAfrontadaPor(humanoideAereo);
		}
		int ptosVidaRestantes = ptosVidaIniciales - danioEsperado;
		
		Assert.assertEquals(
				humanoideAereo.getEstadoVital().getPuntosDeVidaRestantes(),
				ptosVidaRestantes);
		Assert.assertEquals(humanoideAereo.getPuntosDeVida(), ptosVidaRestantes);
		
	}
	
	@Test
	public void testAtravesarTerrestre() {
		int ptosVidaIniciales = 100;
		int danioEsperado = 5;
		AlgoFormer terrestre = new AlgoFormerMock(
				"AlgoFormer Mock",
				ptosVidaIniciales,
				new AlgoHumanoideMock(1, 1, 1),
				new AlgoTerrestreMock(1, 1, 1));
		terrestre.transformar();
		Espinas espinas = new Espinas();
		Assert.assertEquals("Unidad Terrestre Mock", terrestre.getAvatar());
		Assert.assertEquals(
				terrestre.getEstadoVital().getPuntosDeVidaRestantes(),
				ptosVidaIniciales);
		Assert.assertEquals(terrestre.getPuntosDeVida(), ptosVidaIniciales);
		
		Collection<Consecuencia> consecuencias = espinas.actuarSobreAlgoformer(
				terrestre, 
				terrestre.getEstadoVital());
		for (Consecuencia c : consecuencias) {
			c.serAfrontadaPor(terrestre);
		}
		int ptosVidaRestantes = ptosVidaIniciales - danioEsperado;
		
		Assert.assertEquals(
				terrestre.getEstadoVital().getPuntosDeVidaRestantes(),
				ptosVidaRestantes);
		Assert.assertEquals(terrestre.getPuntosDeVida(), ptosVidaRestantes);
		
	}

	@Test
	public void testAtravesarAereo() {
		int ptosVidaIniciales = 100;
		int danioEsperado = 0;
		AlgoFormer aereo = new AlgoFormerMock(
				"AlgoFormer Mock",
				ptosVidaIniciales,
				new AlgoHumanoideMock(1, 1, 1),
				new AlgoAereoMock(1, 1, 1));
		aereo.transformar();
		Espinas espinas = new Espinas();
		Assert.assertEquals("Unidad Aerea Mock", aereo.getAvatar());
		Assert.assertEquals(
				aereo.getEstadoVital().getPuntosDeVidaRestantes(),
				ptosVidaIniciales);
		Assert.assertEquals(aereo.getPuntosDeVida(), ptosVidaIniciales);
		
		Collection<Consecuencia> consecuencias = espinas.actuarSobreAlgoformer(
				aereo, 
				aereo.getEstadoVital());
		for (Consecuencia c : consecuencias) {
			c.serAfrontadaPor(aereo);
		}
		int ptosVidaRestantes = ptosVidaIniciales - danioEsperado;
		
		Assert.assertEquals(
				aereo.getEstadoVital().getPuntosDeVidaRestantes(),
				ptosVidaRestantes);
		Assert.assertEquals(aereo.getPuntosDeVida(), ptosVidaRestantes);
		
	}

}
