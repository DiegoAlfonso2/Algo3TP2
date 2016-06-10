package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Coordenada;

public class CoordenadaTest {

	@Test
	public void test01DosCoordenadasConLosMismosValoresSonIguales() {
		Assert.assertEquals(new Coordenada(1, 1), new Coordenada(1, 1));
	}
	
	@Test
	public void test02DosCoordenadasConDistintosValoresSonDistintas() {
		Assert.assertFalse(new Coordenada(1, 1).equals(new Coordenada(1, 2)));
		Assert.assertFalse(new Coordenada(1, 1).equals(new Coordenada(2, 1)));
		Assert.assertFalse(new Coordenada(4, 5).equals(new Coordenada(5, 4)));
		Assert.assertFalse(new Coordenada(4, 5).equals(new Coordenada(8, 8)));
	}
	
	@Test
	public void test03DosCoordenadasUnaAbajoDeOtraSonAdyacentes() {
		Assert.assertTrue(new Coordenada(1, 1).esConsecutiva(new Coordenada(1, 2)));
		Assert.assertTrue(new Coordenada(1, 2).esConsecutiva(new Coordenada(1, 1)));
		Assert.assertTrue(new Coordenada(4, 4).esConsecutiva(new Coordenada(4, 5)));
		Assert.assertTrue(new Coordenada(4, 4).esConsecutiva(new Coordenada(4, 3)));
	}
	
	@Test
	public void test04DosCoordenadasUnaAlLadoDeOtraSonAdyacentes() {
		Assert.assertTrue(new Coordenada(1, 1).esConsecutiva(new Coordenada(2, 1)));
		Assert.assertTrue(new Coordenada(2, 1).esConsecutiva(new Coordenada(1, 1)));
		Assert.assertTrue(new Coordenada(4, 4).esConsecutiva(new Coordenada(5, 4)));
		Assert.assertTrue(new Coordenada(4, 4).esConsecutiva(new Coordenada(3, 4)));
	}
	
	@Test
	public void test05DosCoordenadasEnDiagonalSonAdyacentes() {
		Assert.assertTrue(new Coordenada(1, 1).esConsecutiva(new Coordenada(2, 2)));
		Assert.assertTrue(new Coordenada(2, 2).esConsecutiva(new Coordenada(1, 1)));
		Assert.assertTrue(new Coordenada(4, 5).esConsecutiva(new Coordenada(5, 6)));
		Assert.assertTrue(new Coordenada(4, 5).esConsecutiva(new Coordenada(5, 4)));
		Assert.assertTrue(new Coordenada(4, 5).esConsecutiva(new Coordenada(3, 6)));
		Assert.assertTrue(new Coordenada(4, 5).esConsecutiva(new Coordenada(3, 4)));
	}
	
	@Test
	public void test06DosCoordenadasSeparadasNoSonAdyacentes() {
		Assert.assertFalse(new Coordenada(1, 1).esConsecutiva(new Coordenada(3, 3)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(2, 2)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(2, 3)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(2, 4)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(2, 5)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(2, 6)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(3, 2)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(4, 2)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(5, 2)));
		Assert.assertFalse(new Coordenada(4, 4).esConsecutiva(new Coordenada(6, 2)));
	}
}
