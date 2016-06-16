
package fiuba.algo3.tests;



import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.transformers.Optimus;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class AlgoFormerTest {

	@Test
	public void test01EmpiezaEnModoHumanoide() {
		Optimus optimus = new Optimus();
		Assert.assertEquals(optimus.getAvatar(), "Optimus Humanoide");
	}

	@Test
	public void test02TransformarAModoAlterno() {
	    Optimus optimus = new Optimus();

		Assert.assertEquals(optimus.getAvatar(), "Optimus Humanoide");
		optimus.cambiarModo();
		Assert.assertEquals(optimus.getAvatar(), "Peterbilt 379");
	}

	@Test
	public void test03TransformarDeVueltaAHumanoide() {

        Optimus optimus = new Optimus();

		Assert.assertEquals(optimus.getAvatar(), "Optimus Humanoide");
		optimus.cambiarModo();
		Assert.assertEquals(optimus.getAvatar(), "Peterbilt 379");
		optimus.cambiarModo();
		Assert.assertEquals(optimus.getAvatar(), "Optimus Humanoide");
	}
	
	@Test (expected=MovimientoInvalidoException.class)
	public void test04moverAlgoFormer() {

		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(2,2);
		Coordenada coordenada2 = new Coordenada(3,2);
		Coordenada coordenada3 = new Coordenada(3,3);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
        movimiento.add(coordenada2);
        movimiento.add(coordenada3);
                
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");

		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).getNombre().equalsIgnoreCase("Optimus"));

		Mover muevoAOptimus = new Mover(movimiento);
		partida.jugar(muevoAOptimus);

	}
	
    @Test (expected=MovimientoInvalidoException.class)
    public void test04moverAlgoFormerAlterno(){

		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(2,2);
		Coordenada coordenada2 = new Coordenada(3,2);
		Coordenada coordenada3 = new Coordenada(3,3);
		Coordenada coordenada4 = new Coordenada(3,4);
		Coordenada coordenada5 = new Coordenada(3,5);
		Coordenada coordenada6 = new Coordenada(3,6);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
        movimiento.add(coordenada2);
        movimiento.add(coordenada3);
        movimiento.add(coordenada4);
        movimiento.add(coordenada5);
        movimiento.add(coordenada6);

		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		
		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).getNombre().equalsIgnoreCase("Optimus"));
        Assert.assertTrue(partida.obtenerModoAlgoformer(coordenada0).equalsIgnoreCase("Optimus Humanoide"));
		Assert.assertTrue(partida.casilleroVacio(coordenada1));
		Assert.assertTrue(partida.casilleroVacio(coordenada2));
		Assert.assertTrue(partida.casilleroVacio(coordenada3));

        Transformar transformoOptimusHumanoideEnPeterbilt = new Transformar(coordenada0);
		partida.jugar(transformoOptimusHumanoideEnPeterbilt);
		
		// Solo se utiliza para poder pasar el turno de los Decepticons, ya que no se pueden hacer 2 acciones en el mismo turno. 
		Transformar transformarMegatron = new Transformar (new Coordenada(10,10));
		partida.jugar(transformarMegatron);
		
		Mover muevoAOptimusEnEjeY = new Mover(movimiento);
		partida.jugar(muevoAOptimusEnEjeY);
    }

}
