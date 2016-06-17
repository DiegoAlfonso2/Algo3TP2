package fiuba.algo3.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.superficies.Pantano;
import fiuba.algo3.modelo.transformers.AlgoFormer;
import fiuba.algo3.modelo.transformers.Bumblebee;
import fiuba.algo3.modelo.transformers.Optimus;
import fiuba.algo3.modelo.transformers.Ratchet;

public class MoverTest {

	private void moverYChequear(AlgoFormer personaje, Tablero tablero, Coordenada... coordenadas) {
		Assert.assertTrue(tablero.algoFormerEnCasillero(coordenadas[0]) == personaje);
		mover(tablero, coordenadas);
		Assert.assertTrue(tablero.algoFormerEnCasillero(coordenadas[coordenadas.length - 1]) 
				== personaje);
		for (int i = 0; i < coordenadas.length - 1; ++i) {
			Assert.assertTrue(tablero.casilleroVacio(coordenadas[i]));
		}
	}
	
	private void mover(Tablero tablero, Coordenada... coordenadas) {
		List<Coordenada> coordenadasMovimiento = new ArrayList<Coordenada>();
		for (Coordenada coordenada : coordenadas) {
			coordenadasMovimiento.add(coordenada);
		}
		Mover testeado = new Mover(coordenadasMovimiento);
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		testeado.ejecutarSobre(new Partida(jugador1, jugador2), tablero);
	}
	
	/**
	 *  Caso positivo de movimiento de Optimus Humanoide en 
	 *  todas las direccioens
	 */
	@Test
	public void test01MoverOptimusHumanoideRangoMaximo() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimusHumanoide = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(1,1);
		tablero.ponerAlgoformer(optimusHumanoide, ubicacionInicial);
		
		// 1
		// -*
		moverYChequear(optimusHumanoide, tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				new Coordenada(1, 3));
		
		// 2
		// |
		// *
		moverYChequear(optimusHumanoide, tablero,
				new Coordenada(1, 3),
				new Coordenada(2, 3),
				new Coordenada(3, 3));
		
		// 3
		// \
		//  *
		moverYChequear(optimusHumanoide, tablero,
				new Coordenada(3, 3),
				new Coordenada(4, 4),
				new Coordenada(5, 5));
		
		// 4
		//  *
		// /
		moverYChequear(optimusHumanoide, tablero,
				new Coordenada(5, 5),
				new Coordenada(4, 6),
				new Coordenada(3, 7));

		// 5
		// *
		// |
		moverYChequear(optimusHumanoide, tablero,
				new Coordenada(3, 7),
				new Coordenada(2, 7),
				new Coordenada(1, 7));

		// 6
		//  /
		// *
		moverYChequear(optimusHumanoide, tablero,
				new Coordenada(1, 7),
				new Coordenada(2, 6),
				new Coordenada(3, 5));

		// 7
		// *-
		moverYChequear(optimusHumanoide, tablero,
				new Coordenada(3, 5),
				new Coordenada(3, 4),
				new Coordenada(3, 3));

		// 8
		// *
		//  \
		moverYChequear(optimusHumanoide, tablero,
				new Coordenada(3, 3),
				new Coordenada(2, 2),
				new Coordenada(1, 1));
	}
	
	/**
	 *  Caso positivo de movimiento de Optimus Terrestre
	 */
	@Test
	public void test02MoverOptimusTerrestreRangoMaximo() {
		Tablero tablero = new Tablero(30, 30);
		Optimus optimusTerrestre = new Optimus();
		optimusTerrestre.cambiarModo();
		Coordenada ubicacionInicial = new Coordenada(1,1);
		tablero.ponerAlgoformer(optimusTerrestre, ubicacionInicial);

		// 1
		// -*
		moverYChequear(optimusTerrestre, tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				new Coordenada(1, 3),
				new Coordenada(1, 4),
				new Coordenada(1, 5),
				new Coordenada(1, 6));
		
		// 2
		// |
		// *
		moverYChequear(optimusTerrestre, tablero,
				new Coordenada(1, 6),
				new Coordenada(2, 6),
				new Coordenada(3, 6),
				new Coordenada(4, 6),
				new Coordenada(5, 6),
				new Coordenada(6, 6));
		
		// 3
		// \
		//  *
		moverYChequear(optimusTerrestre, tablero,
				new Coordenada(6, 6),
				new Coordenada(7, 7),
				new Coordenada(8, 8),
				new Coordenada(9, 9),
				new Coordenada(10, 10),
				new Coordenada(11, 11));
		
		// 4
		//  *
		// /
		moverYChequear(optimusTerrestre, tablero,
				new Coordenada(11, 11),
				new Coordenada(10, 12),
				new Coordenada(9, 13),
				new Coordenada(8, 14),
				new Coordenada(7, 15),
				new Coordenada(6, 16));

		// 5
		// *
		// |
		moverYChequear(optimusTerrestre, tablero,
				new Coordenada(6, 16),
				new Coordenada(5, 16),
				new Coordenada(4, 16),
				new Coordenada(3, 16),
				new Coordenada(2, 16),
				new Coordenada(1, 16));

		// 6
		//  /
		// *
		moverYChequear(optimusTerrestre, tablero,
				new Coordenada(1, 16),
				new Coordenada(2, 15),
				new Coordenada(3, 14),
				new Coordenada(4, 13),
				new Coordenada(5, 12),
				new Coordenada(6, 11));

		// 7
		// *-
		moverYChequear(optimusTerrestre, tablero,
				new Coordenada(6, 11),
				new Coordenada(6, 10),
				new Coordenada(6, 9),
				new Coordenada(6, 8),
				new Coordenada(6, 7),
				new Coordenada(6, 6));

		// 8
		// *
		//  \
		moverYChequear(optimusTerrestre, tablero,
				new Coordenada(6, 6),
				new Coordenada(5, 5),
				new Coordenada(4, 4),
				new Coordenada(3, 3),
				new Coordenada(2, 2),
				new Coordenada(1, 1));
		
		// Movimiento no estructurado
		// |_
		//   |
		// |/
		moverYChequear(optimusTerrestre, tablero,
				new Coordenada(1, 1),
				new Coordenada(2, 1),
				new Coordenada(2, 2),
				new Coordenada(3, 2),
				new Coordenada(4, 1),
				new Coordenada(3, 1));
		
	}
	
	/**
	 * Caso positivo de movimiento de Ratchet Humanoide
	 */
	@Test
	public void test03MoverRatchetHumanoide() {
		Tablero tablero = new Tablero(10, 10);
		Ratchet ratchetHumanoide = new Ratchet();
		Coordenada ubicacionInicial = new Coordenada(5,5);
		tablero.ponerAlgoformer(ratchetHumanoide, ubicacionInicial);
	
		moverYChequear(ratchetHumanoide, tablero,
				ubicacionInicial,
				new Coordenada(6, 5));
		
		moverYChequear(ratchetHumanoide, tablero,
				new Coordenada(6, 5),
				ubicacionInicial);
		
		moverYChequear(ratchetHumanoide, tablero,
				ubicacionInicial,
				new Coordenada(5, 6));
		
		moverYChequear(ratchetHumanoide, tablero,
				new Coordenada(5, 6),
				ubicacionInicial);

		moverYChequear(ratchetHumanoide, tablero,
				ubicacionInicial,
				new Coordenada(6, 6));
		
		moverYChequear(ratchetHumanoide, tablero,
				new Coordenada(6, 6),
				ubicacionInicial);
		
		moverYChequear(ratchetHumanoide, tablero,
				ubicacionInicial,
				new Coordenada(4, 6));
		
		moverYChequear(ratchetHumanoide, tablero,
				new Coordenada(4, 6),
				ubicacionInicial);
		
	}
	
	/**
	 * Caso positivo de movimiento de Ratchet Aereo
	 */
	@Test
	public void test04MoverRatchetAereo() {
		Tablero tablero = new Tablero(30, 30);
		Ratchet ratchetAereo = new Ratchet();
		ratchetAereo.cambiarModo();
		Coordenada ubicacionInicial = new Coordenada(1,1);
		tablero.ponerAlgoformer(ratchetAereo, ubicacionInicial);

		// 1
		// -*
		moverYChequear(ratchetAereo, tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				new Coordenada(1, 3),
				new Coordenada(1, 4),
				new Coordenada(1, 5),
				new Coordenada(1, 6));
		
		// 2
		// |
		// *
		moverYChequear(ratchetAereo, tablero,
				new Coordenada(1, 6),
				new Coordenada(2, 6),
				new Coordenada(3, 6),
				new Coordenada(4, 6),
				new Coordenada(5, 6),
				new Coordenada(6, 6));
		
		// 3
		// \
		//  *
		moverYChequear(ratchetAereo, tablero,
				new Coordenada(6, 6),
				new Coordenada(7, 7),
				new Coordenada(8, 8),
				new Coordenada(9, 9),
				new Coordenada(10, 10),
				new Coordenada(11, 11));
		
		// 4
		//  *
		// /
		moverYChequear(ratchetAereo, tablero,
				new Coordenada(11, 11),
				new Coordenada(10, 12),
				new Coordenada(9, 13),
				new Coordenada(8, 14),
				new Coordenada(7, 15),
				new Coordenada(6, 16));

		// 5
		// *
		// |
		moverYChequear(ratchetAereo, tablero,
				new Coordenada(6, 16),
				new Coordenada(5, 16),
				new Coordenada(4, 16),
				new Coordenada(3, 16),
				new Coordenada(2, 16),
				new Coordenada(1, 16));

		// 6
		//  /
		// *
		moverYChequear(ratchetAereo, tablero,
				new Coordenada(1, 16),
				new Coordenada(2, 15),
				new Coordenada(3, 14),
				new Coordenada(4, 13),
				new Coordenada(5, 12),
				new Coordenada(6, 11));

		// 7
		// *-
		moverYChequear(ratchetAereo, tablero,
				new Coordenada(6, 11),
				new Coordenada(6, 10),
				new Coordenada(6, 9),
				new Coordenada(6, 8),
				new Coordenada(6, 7),
				new Coordenada(6, 6));

		// 8
		// *
		//  \
		moverYChequear(ratchetAereo, tablero,
				new Coordenada(6, 6),
				new Coordenada(5, 5),
				new Coordenada(4, 4),
				new Coordenada(3, 3),
				new Coordenada(2, 2),
				new Coordenada(1, 1));
		
		// Movimiento no estructurado
		// |_
		//   |
		// |/
		moverYChequear(ratchetAereo, tablero,
				new Coordenada(1, 1),
				new Coordenada(2, 1),
				new Coordenada(2, 2),
				new Coordenada(3, 2),
				new Coordenada(4, 1),
				new Coordenada(3, 1));
		
	}
	
	/**
	 * Caso positivo de movimiento de Superion
	 */
	@Test
	public void test05MoverSuperion() {
		// TODO (Falta Superion)
	}
	
	/**
	 * Se intenta mover un Optimus Humanoide en un rango que no le esta permitido
	 * en este modo (maximo 2) pero si en el terrestre (maximo 5). Se espera que
	 * no se pueda hacer el movimiento porque esta en modo Humanoide 
	 */
	@Test
	public void test06MoverOptimusHumanoideRangoValidoTerrestre() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(1,1);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);

		try {
			moverYChequear(optimus, tablero,
					ubicacionInicial,
					new Coordenada(1, 2),
					new Coordenada(1, 3),
					new Coordenada(1, 4),
					new Coordenada(1, 5));
			Assert.fail();
		} catch (MovimientoInvalidoException mie) {
			
		}
		
		optimus.cambiarModo();
		
		moverYChequear(optimus, tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				new Coordenada(1, 3),
				new Coordenada(1, 4),
				new Coordenada(1, 5));
		
		optimus.cambiarModo();
		
		try {
			moverYChequear(optimus, tablero,
					new Coordenada(1, 5),
					new Coordenada(1, 4),
					new Coordenada(1, 3),
					new Coordenada(1, 2),
					ubicacionInicial);
			Assert.fail();
		} catch (MovimientoInvalidoException mie) {
			
		}
	}
	
	/**
	 * Se comprueba que si el AlgoFormer esta muerto, no se puede mover
	 */
	@Test
	public void test07AlgoformerMuertoNoSeMueve() {
//		Bumblebee bumblebee = new Bumblebee();
		// bumblebee.recibirAtaque
		// TODO (Falta el ataque)
		
	}
	
	@Test(expected=MovimientoInvalidoException.class)
	public void test08MoverOptimusHumanoideFueraRangoValido() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(1,1);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);

		moverYChequear(optimus, tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				new Coordenada(1, 3),
				new Coordenada(1, 4),
				new Coordenada(1, 5),
				new Coordenada(1, 6),
				new Coordenada(1, 7),
				new Coordenada(1, 8),
				new Coordenada(1, 9),
				new Coordenada(1, 10));
	}
	
	@Test(expected=MovimientoInvalidoException.class)
	public void test08MoverOptimusPeterbiltFueraRangoValido() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		Coordenada ubicacionInicial = new Coordenada(1,1);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);

		moverYChequear(optimus, tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				new Coordenada(1, 3),
				new Coordenada(1, 4),
				new Coordenada(1, 5),
				new Coordenada(1, 6),
				new Coordenada(1, 7),
				new Coordenada(1, 8),
				new Coordenada(1, 9),
				new Coordenada(1, 10));
	}
	
	public void test09MoverSuperionFueraRangoValido() {
		// TODO (Falta Superion)
	}

	@Test(expected=MovimientoInvalidoException.class)
	public void test10NoSePuedeAtravesarCasilleroOcupadoPorOtroAlgoformerAmigo() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada ubicacionInicial = new Coordenada(1, 1);
		Coordenada ubicacionOcupada = new Coordenada(1, 2);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);
		tablero.ponerAlgoformer(bumblebee, ubicacionOcupada);
		
		moverYChequear(optimus, tablero,
				ubicacionInicial,
				ubicacionOcupada,
				new Coordenada(1, 3));
		
	}

	@Test(expected=MovimientoInvalidoException.class)
	public void test10NoSePuedeAtravesarCasilleroOcupadoPorOtroAlgoformerEnemigo() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		
		Coordenada ubicacionInicial = new Coordenada(1, 1);
		Coordenada ubicacionOcupada = new Coordenada(1, 2);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);
		tablero.ponerAlgoformer(ratchet, ubicacionOcupada);
		
		moverYChequear(optimus, tablero,
				ubicacionInicial,
				ubicacionOcupada,
				new Coordenada(1, 3));
		
	}
	
	@Test(expected=MovimientoInvalidoException.class)
	public void test11NoSePuedeTerminarMovimientoEnCasilleroOcupadoPorOtroAlgoformerEnemigo() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		
		Coordenada ubicacionInicial = new Coordenada(1, 1);
		Coordenada ubicacionOcupada = new Coordenada(1, 3);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);
		tablero.ponerAlgoformer(ratchet, ubicacionOcupada);
		
		moverYChequear(optimus, tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				ubicacionOcupada);
	}

	@Test(expected=MovimientoInvalidoException.class)
	public void test11NoSePuedeTerminarMovimientoEnCasilleroOcupadoPorOtroAlgoformerAmigo() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada ubicacionInicial = new Coordenada(1, 1);
		Coordenada ubicacionOcupada = new Coordenada(1, 3);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);
		tablero.ponerAlgoformer(bumblebee, ubicacionOcupada);
		
		moverYChequear(optimus, tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				ubicacionOcupada);
	}

	@Test(expected=MovimientoInvalidoException.class)
	public void test12NoSePuedeAtravesarPantanoEnModoHumanoide() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(1, 1);
		Coordenada ubicacionPantano = new Coordenada(1, 2);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);
		tablero.ponerSuperficie(new Pantano(), ubicacionPantano);
		
		mover(tablero,
				ubicacionInicial,
				ubicacionPantano,
				new Coordenada(1, 3));
	}
	
	@Test(expected=MovimientoInvalidoException.class)
	public void test12NoSePuedeTerminarEnPantanoEnModoHumanoide() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(1, 1);
		Coordenada ubicacionPantano = new Coordenada(1, 3);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);
		tablero.ponerSuperficie(new Pantano(), ubicacionPantano);

		mover(tablero,
				ubicacionInicial,
				new Coordenada(1, 2),
				ubicacionPantano);
	}

	@Test(expected=MovimientoInvalidoException.class)
	public void test13NoSePuedeMoverFueraDelTablero() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(10, 10);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);

		mover(tablero,
				ubicacionInicial,
				new Coordenada(11, 10),
				new Coordenada(11, 11));
	}

	@Test(expected=MovimientoInvalidoException.class)
	public void test14NoSePuedePegarSaltosEntreCasillerosNoConsecutivos() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(1, 1);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);

		mover(tablero,
				ubicacionInicial,
				new Coordenada(4, 6),
				new Coordenada(9, 9));
	}
	
	@Test(expected=MovimientoInvalidoException.class)
	public void test14NoSePuedeTerminarEnCasilleroNoConsecutivo() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimus = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(1, 1);
		tablero.ponerAlgoformer(optimus, ubicacionInicial);

		mover(tablero,
				ubicacionInicial,
				new Coordenada(9, 9));
	}
	
	@Test(expected=CasilleroVacioException.class)
	public void test15NoSePuedeMoverDesdeCasilleroSinAlgoFormer() {
		Tablero tablero = new Tablero(10, 10);
		Optimus optimusHumanoide = new Optimus();
		Coordenada ubicacionInicial = new Coordenada(1,1);
		tablero.ponerAlgoformer(optimusHumanoide, ubicacionInicial);

		mover(tablero,
				new Coordenada(3, 3),
				new Coordenada(4, 4),
				new Coordenada(4, 5));
	}
	
	public void test16MovimientoInvalidoNoModificaAlgoFormer() {
		// TODO (Faltan modificadores y chispa suprema)
		Tablero tablero = new Tablero(10, 10);
		
	}
	
	public void test17SiAlgoFormerMuereEnElMedioNoConcluyeMovimiento() {
		// TODO (Faltan modificadores y chispa suprema)
	}

}
