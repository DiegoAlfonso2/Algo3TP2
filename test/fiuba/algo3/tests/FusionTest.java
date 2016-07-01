package fiuba.algo3.tests;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.acciones.Atacar;
import fiuba.algo3.modelo.acciones.Fusionar;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;
import fiuba.algo3.modelo.elementos.ModificadorAgotable;
import fiuba.algo3.modelo.excepciones.AlgoformerInactivoException;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.excepciones.FusionInvalidaException;
import fiuba.algo3.modelo.transformers.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Julian Garate on 6/21/16.
 */
public class FusionTest {

    @Test
    public void testCreaUnSuperion(){

        Superion superion = new Superion(new Optimus (),new Ratchet (),new Bumblebee ());
        Assert.assertTrue (superion.getPuntosDeVida () == 1000);
    }
    @Test
    public void testCrearUnMenasor(){

        Menasor menasor = new Menasor(new Megatron (),new Frenzy (),new Bonecrusher ());
        Assert.assertTrue (menasor.getPuntosDeVida () == 1150);
    }

    @Test(expected = CasilleroVacioException.class)
    public void testNoEmpiezaFusionCasilleroVacio(){

        Jugador jugador1 = new JugadorAutobots("Pepito");
        Jugador jugador2 = new JugadorDecepticons("Pirulo");

        Partida partida = new Partida(jugador1, jugador2);

        Fusionar fusion = new Fusionar (new Coordenada (1,1),new Coordenada (1,2),new Coordenada (2,2));

        partida.jugar (fusion);

    }
    @Test(expected = FusionInvalidaException.class)
    public void testNoEmpiezaFusionDistanciaInvalida(){

        Jugador jugador1 = new JugadorAutobots("Pepito");
        Jugador jugador2 = new JugadorDecepticons("Pirulo");

        Partida partida = new Partida(jugador1, jugador2);

        Fusionar fusion = new Fusionar (new Coordenada (1,1),new Coordenada (1,3),new Coordenada (3,1));

        partida.jugar (fusion);

    }

    @Test
    public void testFusionNoCargandoFalgs(){

        Jugador jugador1 = new JugadorAutobots("Pepito");
        Jugador jugador2 = new JugadorDecepticons("Pirulo");

        Partida partida = new Partida(jugador1, jugador2);

        partida.jugar (new Transformar (new Coordenada (1,1)));
        partida.jugar (new Transformar (new Coordenada (10,10)));


        try{
            Fusionar fusion = new Fusionar (new Coordenada (1,1),new Coordenada (1,3),new Coordenada (3,3));
            partida.jugar (fusion);
        } catch (FusionInvalidaException a){

        }

        Assert.assertFalse (partida.obtenerAlgoformer (new Coordenada (1,1)).tieneBonus ("FlagFusion"));

    }

    @Test
    public void testFusionCargaFalgs() {

        Jugador jugador1 = new JugadorAutobots ("Pepito");
        Jugador jugador2 = new JugadorDecepticons ("Pirulo");

        Partida partida = new Partida (jugador1, jugador2);

        ArrayList<Coordenada> movimientos = new ArrayList<Coordenada> ();
        movimientos.add (new Coordenada (3, 1));
        movimientos.add (new Coordenada (2, 2));
        partida.jugar (new Mover (movimientos));

        partida.jugar (new Transformar (new Coordenada (10, 10)));

        Fusionar fusion = new Fusionar (new Coordenada (1, 1), new Coordenada (1, 3), new Coordenada (2, 2));
        partida.jugar (fusion);

        partida.jugar (new Transformar (new Coordenada (10, 10)));

        Assert.assertTrue (partida.obtenerAlgoformer (new Coordenada (1, 1)).tieneBonus ("FlagFusion"));

    }


    @Test(expected = AlgoformerInactivoException.class)
    public void testNoPuedeAtacarCuandoRecienFusiona(){
        Jugador jugador1 = new JugadorAutobots("Pepito");
        Jugador jugador2 = new JugadorDecepticons("Pirulo");

        Partida partida = new Partida(jugador1, jugador2);
        ArrayList<Coordenada> movimientos = new ArrayList<> ();
        movimientos.add (new Coordenada (3,1));
        movimientos.add (new Coordenada (2,2));
        partida.jugar (new Mover (movimientos));

        partida.jugar (new Transformar (new Coordenada (10,10)));

        Fusionar fusion = new Fusionar (new Coordenada (1,1),new Coordenada (1,3),new Coordenada (2,2));

        partida.jugar (fusion);

        movimientos.clear ();
        movimientos.add (new Coordenada (10,10));
        movimientos.add (new Coordenada (9,9));
        movimientos.add (new Coordenada (8,8));
        movimientos.add (new Coordenada (7,7));
        movimientos.add (new Coordenada (6,6));
        movimientos.add (new Coordenada (5,5));
        movimientos.add (new Coordenada (4,4));
        movimientos.add (new Coordenada (3,3));
        movimientos.add (new Coordenada (2,2));

        Mover moverMegatron = new Mover (movimientos);

        partida.jugar (moverMegatron);

        Atacar unAtaque = new Atacar (new Coordenada (1,1),new Coordenada (2,2));

        partida.jugar (unAtaque);
    }
}
