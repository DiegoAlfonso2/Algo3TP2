package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.elementos.Burbuja;

public class BurbujaTest {

	@Test
	public void testBurbujaModificaDefensa() {
		Burbuja testeada = new Burbuja();
		testeada.activar();
		Assert.assertEquals(0, testeada.modificarDefensa(1000));
	}
	
	@Test
	public void testBurbujaNoModificaAtaque() {
		Burbuja testeada = new Burbuja();
		testeada.activar();
		Assert.assertEquals(1000, testeada.modificarAtaque(1000));
	}
	
	@Test
	public void testBurbujaNoModificaVelocidad() {
		Burbuja testeada = new Burbuja();
		testeada.activar();
		Assert.assertEquals(1000, testeada.modificarVelocidad(1000));
	}
	
	@Test
	public void testBurbujaDuracionTurnosPropios() {
		final int duracion = 2;
		Burbuja testeada = new Burbuja();
		Assert.assertFalse(testeada.estaActivo());
		testeada.activar();
		Assert.assertTrue(testeada.estaActivo());
		for (int i = 1; i <= duracion; i++) {
			Assert.assertEquals(0, testeada.modificarDefensa(1000));
			testeada.descontarTurno();
		}
		Assert.assertFalse(testeada.estaActivo());
		Assert.assertEquals(1000, testeada.modificarDefensa(1000));
	}
	
}
