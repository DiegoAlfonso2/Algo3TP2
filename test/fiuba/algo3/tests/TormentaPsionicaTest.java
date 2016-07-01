package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;

public class TormentaPsionicaTest {
		
	@Test
	public void test01humanoideAtraviesaTormentaNoOcurreNada() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada bumblebeeInicial = new Coordenada(3,1);
		Coordenada bumblebeeMedio = new Coordenada(5,1);
		Coordenada bumblebeeFinal = new Coordenada(7,1);
		Coordenada megatronInicial = new Coordenada(10,10);
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		
		Mover moverBumblebee = new Mover(partida.crearMovimiento(bumblebeeInicial, bumblebeeMedio));
		partida.jugar(moverBumblebee);

		// Pasa el turno Decepticons.
		Transformar transformarMegatron = new Transformar(megatronInicial);
		partida.jugar(transformarMegatron);		
		
		moverBumblebee = new Mover(partida.crearMovimiento(bumblebeeMedio, bumblebeeFinal));
		partida.jugar(moverBumblebee);
		
		Assert.assertEquals(partida.obtenerAlgoformer(bumblebeeFinal).getAtaqueModificado(), 80);
	}
	
	@Test
	public void test02terrestreAtraviesaTormentaNoOcurreNada() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada bumblebeeInicial = new Coordenada(3,1);
		Coordenada bumblebeeFinal = new Coordenada(2,3);
		Coordenada megatronInicial = new Coordenada(10,10);
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		
		Transformar transformarBumblebee = new Transformar(bumblebeeInicial);
		partida.jugar(transformarBumblebee);

		// Pasa el turno Decepticons.
		Transformar transformarMegatron = new Transformar(megatronInicial);
		partida.jugar(transformarMegatron);		
		
		Mover moverBumblebee = new Mover(partida.crearMovimiento(bumblebeeInicial, bumblebeeFinal));
		partida.jugar(moverBumblebee);
		
		Assert.assertEquals(partida.obtenerAlgoformer(bumblebeeFinal).getAtaqueModificado(), 20);
	}
	
	@Test
	public void test03aereoAtraviesaTormentaPierdeAtaque() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada ratchetInicial = new Coordenada(1,3);
		Coordenada ratchetFinal = new Coordenada(4,6);
		Coordenada bonecrusherInicial = new Coordenada(10,8);
		
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		
		Transformar transformarRatchet = new Transformar(ratchetInicial);
		partida.jugar(transformarRatchet);
		
		// Pasa el turno Decepticons.
		Transformar transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);
		
		Mover moverRatchet = new Mover(partida.crearMovimiento(ratchetInicial, ratchetFinal));
		partida.jugar(moverRatchet);
		
		Assert.assertEquals(partida.obtenerAlgoformer(ratchetFinal).getAtaqueModificado(), (int) (35 * 0.6));	
	}
	
	@Test
	public void test04aereoAtraviesaTormentaNoRecuperaAtaqueProximoTurno() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada ratchetInicial = new Coordenada(1,3);
		Coordenada ratchetFinal = new Coordenada(4,6);
		Coordenada bonecrusherInicial = new Coordenada(10,8);
		
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		
		Transformar transformarRatchet = new Transformar(ratchetInicial);
		partida.jugar(transformarRatchet);
		
		// Pasa el turno Decepticons.
		Transformar transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);
		
		// Ratchet entra en la Tormenta Psionica.
		Mover moverRatchet = new Mover(partida.crearMovimiento(ratchetInicial, ratchetFinal));
		partida.jugar(moverRatchet);
		
		Assert.assertEquals(partida.obtenerAlgoformer(ratchetFinal).getAtaqueModificado(), (int) (35 * 0.6));
		
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);
		
		// Ratchet sale de la Tormenta Psionica.
		moverRatchet = new Mover(partida.crearMovimiento(ratchetFinal, ratchetInicial));
		partida.jugar(moverRatchet);
		
		Assert.assertEquals(partida.obtenerAlgoformer(ratchetInicial).getAtaqueModificado(), (int) (35 * 0.6));
	}
	
}
