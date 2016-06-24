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
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;
import fiuba.algo3.modelo.excepciones.BonusYaAgregadoException;

public class BonusTest {

	@Test
	public void test01agarrarBonusBurbuja() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(3,1);
		Coordenada coordenada1 = new Coordenada(3,2);
		Coordenada coordenada2 = new Coordenada(3,3);
		Coordenada coordenada3 = new Coordenada(3,4);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
        movimiento.add(coordenada2);
        movimiento.add(coordenada3);
                
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");

		// Se hardcodea un Bumblebee en la posicion (3,1).
		// Se hardcodean los bonus de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);

		Transformar transformarBumblebee = new Transformar(coordenada0);
		partida.jugar(transformarBumblebee);
		
		// Solo se utiliza para poder pasar el turno de los Decepticons, ya que no se pueden hacer 2 acciones en el mismo turno. 
		Transformar transformarMegatron = new Transformar (new Coordenada(10,10));
		partida.jugar(transformarMegatron);
		
		Mover moverBumblebee = new Mover(movimiento);
		partida.jugar(moverBumblebee);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada3).tieneBonus("Burbuja"));
		Assert.assertTrue(partida.casilleroVacio(coordenada3));
	}
//	
//	@Test
//	public void test02agarrarBonusDobleCanon() {
//		List<Coordenada> movimiento = new ArrayList<Coordenada>();
//		Coordenada coordenada0 = new Coordenada(10,8);
//		Coordenada coordenada1 = new Coordenada(10,7);
//		Coordenada coordenada2 = new Coordenada(10,6);
//		Coordenada coordenada3 = new Coordenada(10,5);
//		Coordenada coordenada4 = new Coordenada(10,4);
//		movimiento.add(coordenada0);
//		movimiento.add(coordenada1);
//        movimiento.add(coordenada2);
//        movimiento.add(coordenada3);
//        movimiento.add(coordenada4);
//                
//		Jugador jugador1 = new JugadorAutobots("Pepito");
//		Jugador jugador2 = new JugadorDecepticons("Pirulo");
//
//		// Se hardcodea un Bonecrusher en la posicion (10,8).
//		// Se hardcodean los bonus de acuerdo al mapa adjunto.
//		Partida partida = new Partida(jugador2, jugador1);
//
//		Transformar transformarBonecrusher = new Transformar(coordenada0);
//		partida.jugar(transformarBonecrusher);
//		
//		// Solo se utiliza para poder pasar el turno de los Decepticons, ya que no se pueden hacer 2 acciones en el mismo turno. 
//		Transformar transformarMegatron = new Transformar (new Coordenada(10,10));
//		partida.jugar(transformarMegatron);
//		
//		Mover moverBonecrusher = new Mover(movimiento);
//		partida.jugar(moverBonecrusher);
//
//		Assert.assertTrue(partida.obtenerAlgoformer(coordenada4).tieneBonus("Doble Canon"));
//		Assert.assertTrue(partida.casilleroVacio(coordenada4));
//	}
//	
//	@Test
//	public void test03agarrarBonusFlash() {
//		List<Coordenada> movimiento = new ArrayList<Coordenada>();
//		Coordenada coordenada0 = new Coordenada(1,3);
//		Coordenada coordenada1 = new Coordenada(1,4);
//		Coordenada coordenada2 = new Coordenada(1,5);
//		Coordenada coordenada3 = new Coordenada(1,6);
//		movimiento.add(coordenada0);
//		movimiento.add(coordenada1);
//        movimiento.add(coordenada2);
//        movimiento.add(coordenada3);
//                
//		Jugador jugador1 = new JugadorAutobots("Pepito");
//		Jugador jugador2 = new JugadorDecepticons("Pirulo");
//		// Se hardcodea un Ratcher en la posicion (1,3).
//		// Se hardcodean los bonus de acuerdo al mapa adjunto.
//		Partida partida = new Partida(jugador1, jugador2);
//
//		Transformar transformarRatchet = new Transformar(coordenada0);
//		partida.jugar(transformarRatchet);
//		
//		// Solo se utiliza para poder pasar el turno de los Decepticons, ya que no se pueden hacer 2 acciones en el mismo turno. 
//		Transformar transformarMegatron = new Transformar (new Coordenada(10,10));
//		partida.jugar(transformarMegatron);
//		
//		Mover moverRatchet = new Mover(movimiento);
//		partida.jugar(moverRatchet);
//
//		Assert.assertTrue(partida.obtenerAlgoformer(coordenada3).tieneBonus("Doble Canon"));
//		Assert.assertTrue(partida.casilleroVacio(coordenada3));
//	}
//	
//	@Test(expected=BonusYaAgregadoException.class)
//	public void test04noPuedeAgarrarDosBonusIguales() {
//		List<Coordenada> movimiento = new ArrayList<Coordenada>();
//		Coordenada coordenada0 = new Coordenada(3,1);
//		Coordenada coordenada1 = new Coordenada(3,2);
//		Coordenada coordenada2 = new Coordenada(3,3);
//		Coordenada coordenada3 = new Coordenada(3,4);
//		Coordenada coordenada4 = new Coordenada(3,5);
//		Coordenada coordenada5 = new Coordenada(3,6);
//		Coordenada coordenada6 = new Coordenada(4,6);
//		Coordenada coordenada7 = new Coordenada(5,6);
//		Coordenada coordenada8 = new Coordenada(5,7);
//		movimiento.add(coordenada0);
//		movimiento.add(coordenada1);
//        movimiento.add(coordenada2);
//        movimiento.add(coordenada3);
//        movimiento.add(coordenada4);
//        movimiento.add(coordenada5);
//        movimiento.add(coordenada6);
//        movimiento.add(coordenada7);
//        movimiento.add(coordenada8);
//                
//		Jugador jugador1 = new JugadorAutobots("Pepito");
//		Jugador jugador2 = new JugadorDecepticons("Pirulo");
//
//		// Se hardcodea un Bumblebee en la posicion (3,1).
//		// Se hardcodean los bonus de acuerdo al mapa adjunto.
//		Partida partida = new Partida(jugador1, jugador2);
//		
//		Transformar transformarBumblebee = new Transformar(coordenada0);
//		partida.jugar(transformarBumblebee);
//		
//		// Solo se utiliza para poder pasar el turno de los Decepticons, ya que no se pueden hacer 2 acciones en el mismo turno. 
//		Transformar transformarMegatron = new Transformar (new Coordenada(10,10));
//		partida.jugar(transformarMegatron);
//		
//		Mover moverBumblebee = new Mover(movimiento);
//		partida.jugar(moverBumblebee);
//
//		Assert.assertTrue(partida.casilleroVacio(coordenada3));
//		Assert.assertTrue(partida.obtenerAlgoformer(coordenada8).tieneBonus("Burbuja"));
//		Assert.assertEquals(partida.obtenerContenido(coordenada8).getNombre(), "Burbuja");
//	}
//	
//	@Test
//	public void test05agarraBonusBurbujaNoSufreDanio() {
//		// TODO
////		Assert.assertTrue(true == false);
//	}
//	
//	@Test
//	public void test06agarraBonusDobleCanonAtacaDoblePotencia() {
////		Assert.assertTrue(true == false);
//	}
//	
//	@Test
//	public void test07agarraBonusFlashPuedeAvanzarDobleDistancia() {
////		Assert.assertTrue(true == false);
//	}
//	
}
