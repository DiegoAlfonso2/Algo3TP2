package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.transformers.Bonecrusher;
import fiuba.algo3.modelo.transformers.Bumblebee;
import fiuba.algo3.modelo.transformers.Frenzy;
import fiuba.algo3.modelo.transformers.Megatron;
import fiuba.algo3.modelo.transformers.Optimus;
import fiuba.algo3.modelo.transformers.Ratchet;

public class JugadorDecepticonsTest {

	private JugadorDecepticons jugador;
	
	@Before
	public void setUp() {
		jugador = new JugadorDecepticons("Decepticons");
	}

	@Test
	public void testLePertenecenLosDecepticons() {
		Assert.assertTrue(jugador.lePertenece(new Frenzy()));
		Assert.assertTrue(jugador.lePertenece(new Bonecrusher()));
		Assert.assertTrue(jugador.lePertenece(new Megatron()));
	}
	
	@Test
	public void testNoLePertenecenLosAutobots() {
		Assert.assertFalse(jugador.lePertenece(new Optimus()));
		Assert.assertFalse(jugador.lePertenece(new Ratchet()));
		Assert.assertFalse(jugador.lePertenece(new Bumblebee()));
	}

}
