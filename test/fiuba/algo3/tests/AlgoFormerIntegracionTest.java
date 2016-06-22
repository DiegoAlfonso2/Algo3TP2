package fiuba.algo3.tests;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;

import org.junit.Assert;
import org.junit.Test;

/*
Jugabilidad

Hay 2 jugadores, cada uno debe elegir un equipo antes de iniciar una partida.
Cada jugador comienza la partida con sus 3 algoformers.
Es un juego por turnos. En cada turno el jugador debe elegir UN algoformer y solicitarle que realice una actividad
(moverse, transformarse, atacar, combinarse, capturar chispa, etc…).
Luego pasará el turno al contrincante y así sucesivamente hasta la captura de la chispa suprema.
El juego elige al azar qué jugador comienza.
Cada jugador inicia en el extremo opuesto al otro con sus 3 algoformers juntos.

TODOS LOS SUPUESTOS SON VARIABLES

SUPONGO:
1 - Cuando se crea al AF, se crea en modo HUMANOIDE.
*/


public class AlgoFormerIntegracionTest {

	@Test
	public void test01moverAlgoFormer() {

		List<Coordenada> movimiento = new ArrayList<Coordenada>();
		Coordenada coordenada0 = new Coordenada(1,1);
		Coordenada coordenada1 = new Coordenada(2,2);
		Coordenada coordenada2 = new Coordenada(3,2);
		movimiento.add(coordenada0);
		movimiento.add(coordenada1);
        movimiento.add(coordenada2);
                
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");

		Partida partida = new Partida(jugador1, jugador2);

		Assert.assertTrue(partida.obtenerAlgoformer(coordenada0).getNombre().equalsIgnoreCase("Optimus"));

		Mover muevoAOptimus = new Mover(movimiento);
		partida.jugar(muevoAOptimus);

		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.casilleroVacio(coordenada1));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada2).getNombre().equalsIgnoreCase("Optimus"));
	}

	@Test
	public void test02TransformarAlgoFormerAFormaAlterna() {

		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");

		Partida partida = new Partida(jugador1, jugador2);

        Coordenada unaCoordenada = new Coordenada(1,1);
		Assert.assertTrue(partida.obtenerAlgoformer(unaCoordenada).getNombre().equalsIgnoreCase("Optimus"));
        Assert.assertTrue(partida.obtenerModoAlgoformer(unaCoordenada).equalsIgnoreCase("Optimus Humanoide"));

        Transformar transformoOptimusHumanoideEnPeterbilt = new Transformar(unaCoordenada);
		partida.jugar(transformoOptimusHumanoideEnPeterbilt);

		
        Assert.assertTrue(partida.obtenerModoAlgoformer(unaCoordenada).equalsIgnoreCase("Peterbilt 379"));
        
		// Solo se utiliza para poder pasar el turno de los Decepticons, ya que no se pueden hacer 2 acciones en el mismo turno. 
		Transformar transformarMegatron = new Transformar (new Coordenada(10,10));
		partida.jugar(transformarMegatron);

        Transformar transformoOptimusPeterbiltEnHumanoide = new Transformar(unaCoordenada);
		partida.jugar(transformoOptimusPeterbiltEnHumanoide);
        Assert.assertTrue(partida.obtenerModoAlgoformer(unaCoordenada).equalsIgnoreCase("Optimus Humanoide"));

	}

    @Test
    public void test03moverAlgoFormerAlterno(){

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
		
		Assert.assertTrue(partida.casilleroVacio(coordenada0));
		Assert.assertTrue(partida.casilleroVacio(coordenada1));
		Assert.assertTrue(partida.casilleroVacio(coordenada2));
		Assert.assertTrue(partida.obtenerAlgoformer(coordenada3).getNombre().equalsIgnoreCase("Optimus"));
        Assert.assertTrue(partida.obtenerModoAlgoformer(coordenada3).equalsIgnoreCase("Peterbilt 379"));
    }


	@Test
	public void test04inicializarJuego() {

	/*
	Es un test SIMPLE que prueba que al crearse se inicialice la partida correctamente
	en un MAPA de 10x10.
	*/

	Jugador jugador1 = new JugadorAutobots("Pepito");
	Jugador jugador2 = new JugadorDecepticons("Pirulo");

	Partida partida = new Partida(jugador1, jugador2);


    Assert.assertTrue(partida.obtenerAlgoformer(new Coordenada(1,1)).getNombre().equalsIgnoreCase("Optimus"));
    Assert.assertTrue(partida.obtenerAlgoformer(new Coordenada(3,1)).getNombre().equalsIgnoreCase("Bumblebee"));
    Assert.assertTrue(partida.obtenerAlgoformer(new Coordenada(1,3)).getNombre().equalsIgnoreCase("Ratchet"));
    Assert.assertTrue(partida.obtenerAlgoformer(new Coordenada(10,10)).getNombre().equalsIgnoreCase("Megatron"));
    Assert.assertTrue(partida.obtenerAlgoformer(new Coordenada(10,8)).getNombre().equalsIgnoreCase("Bonecrusher"));
    Assert.assertTrue(partida.obtenerAlgoformer(new Coordenada(8,10)).getNombre().equalsIgnoreCase("Frenzy"));
    Assert.assertTrue(partida.obtenerContenido(new Coordenada(6,5)).getNombre().equalsIgnoreCase("Chispa Suprema"));

}
    /*

    @Test
    public void test05unPosicionamientoYAtaque() {

    List<Coordenada> desdeHasta = new ArrayList<Coordenada>();

    List<Coordenada> movimiento = new ArrayList<Coordenada>();

    movimiento.add(new Coordenada(8,9));
    movimiento.add(new Coordenada(7,8));
    movimiento.add(new Coordenada(6,7));


    Jugador jugador1 = new Jugador("Nombre1");
    Jugador jugador2 = new Jugador("Nombre2");

    *//*
    En un mapa de 15x15 pruebo, sobre lo inicializado, ataque valido e invalido.
    *//*


    Partida partida = new Partida(jugador1, jugador2);

        Assert.assertEquals( partida.devolverAlgoformer(new Coordenada(2,3)).getPuntosDeVida() , 400 );
        //Tiene que tener los mismos puntos de vida porque fue atacado sin exito.



        Mover muevoFrenzy = new Mover(movimiento);
    partida.jugar(muevoFrenzy);




    Coordenada coordenada0 = new Coordenada(1,1);
    Coordenada coordenada1 = new Coordenada(2,3);
    Coordenada coordenada2 = new Coordenada(3,2);
    Coordenada coordenada3 = new Coordenada(10,10);
    Coordenada coordenada4 = new Coordenada(8,9);
    Coordenada coordenada5 = new Coordenada(9,8);


    *//*
    Atacar Frenzy(6,7) al (2,3)
    *//*

    AssertEquals( ((AlgoFormer) partida.obtenerContenido(coordenada0)).getPuntosDeVida() , OPTIMUS.getPuntosDeVida() );
    //Tiene que tener la vida completa, dado que el atacante esta muy lejos.

    desdeHasta.clear();

    partida.jugar(Atacar, coordenada1,coordenada2);

    *//*
    Bumblebee(2,3) ataca a Frenzy(3,4)
    *//*

    AssertNotEquals( ((AlgoFormer) partida.obtenerContenido(coordenada4)).getPuntosDeVida() , FRENZY.getPuntosDeVida() );
    //NO tiene que tener los mismos puntos de vida porque fue atacado con exito.

    }

*/
	
	
	

}
