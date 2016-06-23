package fiuba.algo3.tests;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.acciones.EmpezarFusion;
import fiuba.algo3.modelo.excepciones.CasilleroVacioException;
import fiuba.algo3.modelo.excepciones.FusionInvalidaException;
import fiuba.algo3.modelo.transformers.*;
import org.junit.Assert;
import org.junit.Test;

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

        EmpezarFusion empezarFusion = new EmpezarFusion (new Coordenada (1,1),new Coordenada (1,2),new Coordenada (1,4));

        partida.jugar (empezarFusion);

    }
    @Test(expected = FusionInvalidaException.class)
    public void testEmpezarFusion(){

        Jugador jugador1 = new JugadorAutobots("Pepito");
        Jugador jugador2 = new JugadorDecepticons("Pirulo");

        Partida partida = new Partida(jugador1, jugador2);

        EmpezarFusion empezarFusion = new EmpezarFusion (new Coordenada (1,1),new Coordenada (1,3),new Coordenada (3,1));

        partida.jugar (empezarFusion);

    }
}
