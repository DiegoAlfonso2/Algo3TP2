package fiuba.algo3.tests;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;

import org.junit.Assert;
import org.junit.Test;


public class AlgoFormerIntegracionEntrega2Test {
	
	@Test
	public void test01moverAlgoFormerPorZonaRocosa() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(2,1);
		Coordenada coordenada2 = new Coordenada(2,2);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
        movimiento.add(coordenada2);
                
		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Optimus en la posición (1,1).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Optimus"));

		Mover moverOptimus = new Mover(movimiento);
		partida.jugar(moverOptimus);

		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.casilleroVacio(coordenada1));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada2).equalsIgnoreCase("Optimus"));
	}

	@Test (expected=MovimientoInvalidoException.class)
	public void test02moverHumanoidePorZonaPantano() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(1,2);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);

		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Optimus en la posición (1,1).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Optimus"));

		Mover moverOptimus = new Mover(movimiento);
		partida.jugar(moverOptimus);
	}	

	@Test (expected=MovimientoInvalidoException.class) 
	public void test03moverAlternoTerrestrePorZonaPantano() {
		List<Coordenada> movimiento1 = new ArrayList<Coordenada>();
		List<Coordenada> movimiento2 = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(2,1);
		Coordenada coordenada2 = new Coordenada(2,2);
		Coordenada coordenada3 = new Coordenada(1,2);
		movimiento1.add(coordenada0);
		movimiento1.add(coordenada1);
		movimiento1.add(coordenada2);
		movimiento2.add(coordenada2);
		movimiento2.add(coordenada3);
		movimiento2.add(coordenada0);

		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Optimus en la posición (1,1).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Optimus"));

		Mover moverOptimus = new Mover(movimiento1);
		partida.jugar(moverOptimus);
		
		// Yendo por el camino sin Pantano, optimus puede desplazarse hasta 2 casilleros.
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada2).equalsIgnoreCase("Optimus"));
		
		moverOptimus = new Mover(movimiento2);
		// Al desplazarse por el Pantano, tarda el doble, por lo que por cada casillero que avanza en el Pantano gasta 2 de velocidad.
		// De esta manera, sólo puede desplazarse 1 casillero. Al querer desplazarse 2, lanzara una excepción.
		partida.jugar(moverOptimus);
	}	
		
	@Test 
	public void test04moverAlternoAereoPorZonaPantano() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(9,10);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
         
		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Megatron en la posición (10,10).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Megatron"));

		Transformar transformarMegatron = new Transformar(coordenada0);
		partida.jugar(transformarMegatron);
		
		Mover moverMegatron = new Mover(movimiento);
		partida.jugar(moverMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada1).equalsIgnoreCase("Megatron"));
	}	
		
	@Test 
	public void test05moverHumanoidePorZonaEspinas() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(2,1);
		Coordenada coordenada2 = new Coordenada(2,2);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
        movimiento.add(coordenada2);
        
		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Optimus en la posición (1,1).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Optimus"));
		
		// Se chequea que la vida de Optimus sea de 500.
		Assert.assertTrue(partida.obtenerVidaAlgoFormer(coordenada0) == 500);
		
		Mover moverOptimus = new Mover(movimiento);
		partida.jugar(moverOptimus);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.casilleroVacio(coordenada1));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada2).equalsIgnoreCase("Optimus"));
		
		// Se chequea que al pasar por las espinas pierda un 5% de vida.
		Assert.assertTrue(partida.obtenerVidaAlgoFormer(coordenada2) == 475);	
	}	
		
	@Test 
	public void test06moverAlternoAereoPorZonaEspinas() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(9,9);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
                
		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Megatron en la posición (10,10).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Megatron"));
		
		// Se chequea que la vida de Megatron sea de 550.
		Assert.assertTrue(partida.obtenerVidaAlgoFormer(coordenada0) == 550);
		
		Transformar transformarMegatron = new Transformar(coordenada0);
		partida.jugar(transformarMegatron);
		
		Mover moverMegatron = new Mover(movimiento);
		partida.jugar(moverMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada1).equalsIgnoreCase("Megatron"));
		
		// Se chequea que al pasar por las espinas pierda un 5% de vida.
		Assert.assertTrue(partida.obtenerVidaAlgoFormer(coordenada1) == 550);	
	}	
		
	@Test
	public void test07moverAlternoAereoPorZonaConNubes() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(10,9);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
                
		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Megatron en la posición (10,10).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Megatron"));
		
		Transformar transformarMegatron = new Transformar(coordenada0);
		partida.jugar(transformarMegatron);
		
		Mover moverMegatron = new Mover(movimiento);
		partida.jugar(moverMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada1).equalsIgnoreCase("Megatron"));			
	}	
		
	@Test 
	public void test08moverAlternoAereoPorZonaNebulosaAndromeda() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(9,10);
		Coordenada coordenada2 = new Coordenada(9,9);
		Coordenada coordenada3 = new Coordenada(9,8);
		Coordenada coordenada4 = new Coordenada(9,7);
		Coordenada coordenada5 = new Coordenada(9,6);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
		movimiento.add(coordenada2);
		movimiento.add(coordenada3);
		movimiento.add(coordenada4);
		movimiento.add(coordenada5);
                
		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Megatron en la posición (10,10).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Megatron"));
		
		Transformar transformarMegatron = new Transformar(coordenada0);
		partida.jugar(transformarMegatron);
		
		Mover moverMegatron = new Mover(movimiento);
		partida.jugar(moverMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada5).equalsIgnoreCase("Megatron"));
		
		// TODO Hay que ver el tema de como terminar los turnos e iniciar otros. Recién ahí se puede implementar este test.
		Assert.assertTrue(true == false);
	}	
		
	@Test 
	public void test09moverAlternoAereoPorZonaTormentaPsionica() {
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(10,9);
		Coordenada coordenada2 = new Coordenada(9,9);
		Coordenada coordenada3 = new Coordenada(8,9);
		Coordenada coordenada4 = new Coordenada(7,9);
		Coordenada coordenada5 = new Coordenada(6,9);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
		movimiento.add(coordenada2);
		movimiento.add(coordenada3);
		movimiento.add(coordenada4);
		movimiento.add(coordenada5);
                
		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Megatron en la posición (10,10).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Megatron"));
		
		Transformar transformarMegatron = new Transformar(coordenada0);
		partida.jugar(transformarMegatron);
		
		Mover moverMegatron = new Mover(movimiento);
		partida.jugar(moverMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada5).equalsIgnoreCase("Megatron"));
		
		// Se chequea que al pasar por la Tormenta Psionica perdió un 40% de ataque.
		Assert.assertTrue(partida.obtenerAtaqueAlgoFormer(coordenada5) == 33);
	}	
	
	@Test 
	public void test10moverAlternoAereoPorZonaTormentaPsionicaSegundaVezNoPierdenNuevamenteAtaque() {
		List<Coordenada> movimiento1 = new ArrayList<Coordenada>();
		List<Coordenada> movimiento2 = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(10,9);
		Coordenada coordenada2 = new Coordenada(9,9);
		Coordenada coordenada3 = new Coordenada(8,9);
		Coordenada coordenada4 = new Coordenada(7,9);
		Coordenada coordenada5 = new Coordenada(6,9);
		movimiento1.add(coordenada0);
		movimiento1.add(coordenada1);
		movimiento1.add(coordenada2);
		movimiento1.add(coordenada3);
		movimiento1.add(coordenada4);
		movimiento1.add(coordenada5);
		movimiento2.add(coordenada5);
		movimiento2.add(coordenada4);
		movimiento2.add(coordenada3);
                
		Jugador jugador1 = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Pirulo");

		// Se hardcodea un Megatron en la posición (10,10).
		// Se hardcodean las superficies de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).equalsIgnoreCase("Megatron"));
		
		Transformar transformarMegatron = new Transformar(coordenada0);
		partida.jugar(transformarMegatron);
		
		Mover moverMegatron = new Mover(movimiento1);
		partida.jugar(moverMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada5).equalsIgnoreCase("Megatron"));
		
		// Se chequea que al pasar por la Tormenta Psionica perdió un 40% de ataque.
		Assert.assertTrue(partida.obtenerAtaqueAlgoFormer(coordenada5) == 33);
		
		moverMegatron = new Mover(movimiento2);
		partida.jugar(moverMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada3).equalsIgnoreCase("Megatron"));
		
		// Se chequea que al pasar por la Tormenta Psionica nuevamente no volvió a perder puntos de ataque.
		Assert.assertTrue(partida.obtenerAtaqueAlgoFormer(coordenada3) == 33);
	}	
	
}
