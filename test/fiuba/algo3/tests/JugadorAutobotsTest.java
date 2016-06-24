package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.transformers.Bonecrusher;
import fiuba.algo3.modelo.transformers.Bumblebee;
import fiuba.algo3.modelo.transformers.Frenzy;
import fiuba.algo3.modelo.transformers.Megatron;
import fiuba.algo3.modelo.transformers.Optimus;
import fiuba.algo3.modelo.transformers.Ratchet;

public class JugadorAutobotsTest {

	private JugadorAutobots jugador;
	
	@Before
	public void setUp() {
		jugador = new JugadorAutobots("Autobots");
	}

	@Test
	public void testLePertenecenLosAutobots() {
		Assert.assertTrue(jugador.lePertenece(new Optimus()));
		Assert.assertTrue(jugador.lePertenece(new Ratchet()));
		Assert.assertTrue(jugador.lePertenece(new Bumblebee()));
	}

	@Test
	public void testNoLePertenecenLosDecepticons() {
		Assert.assertFalse(jugador.lePertenece(new Frenzy()));
		Assert.assertFalse(jugador.lePertenece(new Bonecrusher()));
		Assert.assertFalse(jugador.lePertenece(new Megatron()));
	}
	
}
