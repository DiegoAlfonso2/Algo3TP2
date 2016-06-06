package fiuba.algo3.tests;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.*;


import org.junit.Assert;
import org.junit.Test;


public class AlgoFormerEntrega2Test {
	
	@Test
	public void test01moverAlgoFormerPorZonaRocosa() {

		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(2,1);
		Coordenada coordenada2 = new Coordenada(2,2);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
        movimiento.add(coordenada2);
                
		Jugador jugador1 = new Jugador("Nombre1");
		Jugador jugador2 = new Jugador("Nombre2");

		//al crear la partida, tener en cuenta una zona Rocosa en el casillero
		// (2,1) y un Optimus en (1,1)
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0) 
				.equalsIgnoreCase("Optimus"));

		Mover muevoAOptimus = new Mover(movimiento);
		partida.jugar(muevoAOptimus);

		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.casilleroVacio(coordenada1));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada2) 
				.equalsIgnoreCase("Optimus"));
	}

	@Test (expected=MovimientoInvalidoException.class)
	public void test02moverHumanoideTerrestrePorZonaPantano() {

		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(1,2);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);

		Jugador jugador1 = new Jugador("Nombre1");
		Jugador jugador2 = new Jugador("Nombre2");

		//al crear la partida, tener en cuenta una zona Pantano en el casillero
		// (1,2) y un Optimus en (1,1)
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0) 
				.equalsIgnoreCase("Optimus"));

		Mover muevoAOptimus = new Mover(movimiento);
		partida.jugar(muevoAOptimus);
	}	

	@Test 
	public void test03moverAlternoTerrestrePorZonaPantano() {
		Assert.assertTrue(true == false);
	}	

	@Test 
	public void test04moverHumanoideAereoPorZonaPantano() {

		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(9,10);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
         
		Jugador jugador1 = new Jugador("Nombre1");
		Jugador jugador2 = new Jugador("Nombre2");

		//al crear la partida se coloca una zona Pantano en el casillero
		// (9,10) y un Megatron en (10,10)
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0) 
				.equalsIgnoreCase("Megatron"));

		Mover muevoAMegatron = new Mover(movimiento);
		partida.jugar(muevoAMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada1) 
				.equalsIgnoreCase("Megatron"));
	}	
	
	@Test 
	public void test05moverHumanoideTerrestrePorZonaEspinas() {
		
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(2,1);
		Coordenada coordenada2 = new Coordenada(2,2);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
        movimiento.add(coordenada2);
        
		Jugador jugador1 = new Jugador("Nombre1");
		Jugador jugador2 = new Jugador("Nombre2");

		//al crear la partida se coloca una zona Espinas en el casillero
		// (2,1) y un Optimus en (1,1)
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0) 
				.equalsIgnoreCase("Optimus"));
		
		//se valida que la vida de Optimus sea de 500
		Assert.assertTrue(partida.obtenerVidaAlgoFormer(coordenada0) == 500);
		
		Mover muevoAOptimus = new Mover(movimiento);
		partida.jugar(muevoAOptimus);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.casilleroVacio(coordenada1));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada2) 
				.equalsIgnoreCase("Optimus"));
		//se valida que al pasar por espinas le quite un 5% de vida
		Assert.assertTrue(partida.obtenerVidaAlgoFormer(coordenada2) == 475);
		
	}	
	
	@Test 
	public void test06moverHumanoideAereoPorZonaEspinas() {
		
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(9,9);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
                
		Jugador jugador1 = new Jugador("Nombre1");
		Jugador jugador2 = new Jugador("Nombre2");

		//al crear la partida se coloca una zona Espinas en el casillero
		// (9,9) y un Megatron en (10,10)
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0) 
				.equalsIgnoreCase("Megatron"));
		
		//se valida que la vida de Megatron sea de 550
		Assert.assertTrue(partida.obtenerVidaAlgoFormer(coordenada0) == 550);
		
		Mover muevoAMegatron = new Mover(movimiento);
		partida.jugar(muevoAMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada1) 
				.equalsIgnoreCase("Megatron"));
		//se valida que al pasar por espinas mantiene los mismos puntos de vida
		Assert.assertTrue(partida.obtenerVidaAlgoFormer(coordenada1) == 550);
		
	}	
	
	@Test
	public void test07moverHumanoideAereoPorZonaConNubes() {
		
		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(10,10);
		Coordenada coordenada1 = new Coordenada(10,9);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
                
		Jugador jugador1 = new Jugador("Nombre1");
		Jugador jugador2 = new Jugador("Nombre2");

		//al crear la partida se coloca una zona con Nubes en el casillero
		// (10,9) y un Megatron en (10,10)
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0) 
				.equalsIgnoreCase("Megatron"));
		
		Mover muevoAMegatron = new Mover(movimiento);
		partida.jugar(muevoAMegatron);
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada1) 
				.equalsIgnoreCase("Megatron"));
				
	}	
}
