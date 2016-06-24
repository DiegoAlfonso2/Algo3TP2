package fiuba.algo3.tests;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.modos.Modo;
import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.modelo.transformers.Optimus;
import fiuba.algo3.tests.mocks.AlgoHumanoideMock;
import fiuba.algo3.tests.mocks.AlgoTerrestreMock;
import fiuba.algo3.tests.mocks.AutobotMock;
import fiuba.algo3.tests.mocks.DecepticonMock;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class AlgoFormerTest {

	@Test
	public void testEmpiezaEnModoHumanoide() {
		Optimus optimus = new Optimus();
		Assert.assertEquals(optimus.getAvatar(), "Optimus Humanoide");
	}

	@Test
	public void testTransformarAModoAlterno() {
		Optimus optimus = new Optimus();

		Assert.assertEquals(optimus.getAvatar(), "Optimus Humanoide");
		optimus.transformar();
		Assert.assertEquals(optimus.getAvatar(), "Peterbilt 379");
	}

	@Test
	public void testTransformarDeVueltaAHumanoide() {

		Optimus optimus = new Optimus();

		Assert.assertEquals(optimus.getAvatar(), "Optimus Humanoide");
		optimus.transformar();
		Assert.assertEquals(optimus.getAvatar(), "Peterbilt 379");
		optimus.transformar();
		Assert.assertEquals(optimus.getAvatar(), "Optimus Humanoide");
	}


	@Test
	public void testAtacarAlgoFormer_AutobotAtacante() {
		final int ptosVidaIniciales = 10;
		final int ptosAtaque = 1;
		final int distanciaValida = 1;
		Modo atacanteHumanoide = new AlgoHumanoideMock(ptosAtaque, distanciaValida, 0);
		Modo atacanteTerrestre = new AlgoTerrestreMock(0, 0, 0);
		AlgoFormer atacante = new AutobotMock(
				"Atacante", 
				1, 
				atacanteHumanoide, 
				atacanteTerrestre);
		Modo atacadoHumanoide = new AlgoHumanoideMock(1, 1, 1);
		Modo atacadoTerrestre = new AlgoTerrestreMock(1, 1, 1);
		AlgoFormer atacado = new DecepticonMock(
				"Atacado",
				ptosVidaIniciales, 
				atacadoHumanoide, 
				atacadoTerrestre);

		Assert.assertTrue(
				atacado.getEstadoVital().getPuntosDeVidaRestantes() 
				== 
				ptosVidaIniciales);
		
		atacante.atacar(atacado, distanciaValida);
		
		Assert.assertTrue(
				atacado.getEstadoVital().getPuntosDeVidaRestantes() 
				== 
				ptosVidaIniciales - ptosAtaque);
	}

	@Test
	public void testAtacarAlgoFormer_DecepticonAtacante() {
		final int ptosVidaIniciales = 10;
		final int ptosAtaque = 1;
		final int distanciaValida = 1;
		Modo atacanteHumanoide = new AlgoHumanoideMock(ptosAtaque, distanciaValida, 0);
		Modo atacanteTerrestre = new AlgoTerrestreMock(0, 0, 0);
		AlgoFormer atacante = new DecepticonMock(
				"Atacante", 
				1, 
				atacanteHumanoide, 
				atacanteTerrestre);
		Modo atacadoHumanoide = new AlgoHumanoideMock(1, 1, 1);
		Modo atacadoTerrestre = new AlgoTerrestreMock(1, 1, 1);
		AlgoFormer atacado = new AutobotMock(
				"Atacado",
				ptosVidaIniciales, 
				atacadoHumanoide, 
				atacadoTerrestre);

		Assert.assertTrue(
				atacado.getEstadoVital().getPuntosDeVidaRestantes() 
				== 
				ptosVidaIniciales);
		
		atacante.atacar(atacado, distanciaValida);
		
		Assert.assertTrue(
				atacado.getEstadoVital().getPuntosDeVidaRestantes() 
				== 
				ptosVidaIniciales - ptosAtaque);
	}

	@Test(expected=AtaqueInvalidoException.class)
	public void testAtacarEquipoPropioLanzaExcepcion_Autobot() {
		final int ptosVidaIniciales = 10;
		final int ptosAtaque = 1;
		final int distanciaValida = 1;
		Modo atacanteHumanoide = new AlgoHumanoideMock(ptosAtaque, distanciaValida, 0);
		Modo atacanteTerrestre = new AlgoTerrestreMock(0, 0, 0);
		AlgoFormer atacante = new AutobotMock(
				"Atacante", 
				1, 
				atacanteHumanoide, 
				atacanteTerrestre);
		Modo atacadoHumanoide = new AlgoHumanoideMock(1, 1, 1);
		Modo atacadoTerrestre = new AlgoTerrestreMock(1, 1, 1);
		AlgoFormer atacado = new AutobotMock(
				"Atacado",
				ptosVidaIniciales, 
				atacadoHumanoide, 
				atacadoTerrestre);

		Assert.assertTrue(
				atacado.getEstadoVital().getPuntosDeVidaRestantes() 
				== 
				ptosVidaIniciales);
		
		atacante.atacar(atacado, distanciaValida);
	}

	@Test(expected=AtaqueInvalidoException.class)
	public void testAtacarEquipoPropioLanzaExcepcion_Decepticon() {
		final int ptosVidaIniciales = 10;
		final int ptosAtaque = 1;
		final int distanciaValida = 1;
		Modo atacanteHumanoide = new AlgoHumanoideMock(ptosAtaque, distanciaValida, 0);
		Modo atacanteTerrestre = new AlgoTerrestreMock(0, 0, 0);
		AlgoFormer atacante = new DecepticonMock(
				"Atacante", 
				1, 
				atacanteHumanoide, 
				atacanteTerrestre);
		Modo atacadoHumanoide = new AlgoHumanoideMock(1, 1, 1);
		Modo atacadoTerrestre = new AlgoTerrestreMock(1, 1, 1);
		AlgoFormer atacado = new DecepticonMock(
				"Atacado",
				ptosVidaIniciales, 
				atacadoHumanoide, 
				atacadoTerrestre);

		Assert.assertTrue(
				atacado.getEstadoVital().getPuntosDeVidaRestantes() 
				== 
				ptosVidaIniciales);
		
		atacante.atacar(atacado, distanciaValida);
		Assert.fail();
	}

}
