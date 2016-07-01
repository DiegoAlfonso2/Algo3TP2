package fiuba.algo3.tests;

import org.junit.Test;

import fiuba.algo3.modelo.Coordenada;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.JugadorAutobots;
import fiuba.algo3.modelo.JugadorDecepticons;
import fiuba.algo3.modelo.Partida;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;
import fiuba.algo3.modelo.excepciones.AlgoformerInactivoException;

public class NebulosaAndromedaTest {

	@Test
	public void test01humanoideAtraviesaNebulosaNoOcurreNada() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada bumblebeeInicial = new Coordenada(3,1);
		Coordenada bumblebeeFinal = new Coordenada(4,2);
		Coordenada bonecrusherInicial = new Coordenada(10,8);
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);
		
		Mover moverBumblebee = new Mover(partida.crearMovimiento(bumblebeeInicial, bumblebeeFinal));
		partida.jugar(moverBumblebee);
		
		// Pasa el turno Decepticons.
		Transformar transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);		
		
		// Puedo utilizar a Bumblebee.
		Transformar transformarBumblebee = new Transformar(bumblebeeFinal);
		partida.jugar(transformarBumblebee);
	}
	
	@Test
	public void test02terrestreAtraviesaNebulosaNoOcurreNada() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada bumblebeeInicial = new Coordenada(3,1);
		Coordenada bumblebeeFinal = new Coordenada(4,2);
		Coordenada bonecrusherInicial = new Coordenada(10,8);
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);

		Transformar transformarBumblebee = new Transformar(bumblebeeInicial);
		partida.jugar(transformarBumblebee);
		
		// Pasa el turno Decepticons.
		Transformar transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);
		
		// Muevo a Bumblebee a la Nebulosa
		Mover moverBumblebee = new Mover(partida.crearMovimiento(bumblebeeInicial, bumblebeeFinal));
		partida.jugar(moverBumblebee);
		
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);		
		
		// Puedo utilizar a Bumblebee.
		transformarBumblebee = new Transformar(bumblebeeFinal);
		partida.jugar(transformarBumblebee);		
	}
	
	@Test(expected=AlgoformerInactivoException.class)
	public void test03aereoAtraviesaNebulosaQuedaInactivoPrimerTurno() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada ratchetInicial = new Coordenada(1,3);
		Coordenada ratchetFinal = new Coordenada(4,2);
		Coordenada bonecrusherInicial = new Coordenada(10,8);
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);

		Transformar transformarRatchet = new Transformar(ratchetInicial);
		partida.jugar(transformarRatchet);
		
		// Pasa el turno Decepticons.
		Transformar transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);
		
		// Muevo a Ratchet a la Nebulosa.
		Mover moverBumblebee = new Mover(partida.crearMovimiento(ratchetInicial, ratchetFinal));
		partida.jugar(moverBumblebee);
		
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);		
		
		// No puedo utilizar a Ratchet.
		transformarRatchet = new Transformar(ratchetFinal);
		partida.jugar(transformarRatchet);		
	}
	
	@Test(expected=AlgoformerInactivoException.class)
	public void test04aereoAtraviesaNebulosaQuedaInactivoSegundoTurno() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada ratchetInicial = new Coordenada(1,3);
		Coordenada ratchetFinal = new Coordenada(4,2);
		Coordenada bonecrusherInicial = new Coordenada(10,8);
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);

		Transformar transformarRatchet = new Transformar(ratchetInicial);
		partida.jugar(transformarRatchet);
		
		// Pasa el turno Decepticons.
		Transformar transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);
		
		// Muevo a Ratchet a la Nebulosa.
		Mover moverBumblebee = new Mover(partida.crearMovimiento(ratchetInicial, ratchetFinal));
		partida.jugar(moverBumblebee);
		
		// Pasa el turno Decepticons.
		transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);		
		
		// Pasa el primer turno Autobots (transformo a Optimus).
		partida.jugar(new Transformar(new Coordenada(1,1)));
		
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);
		
		// No puedo utilizar a Ratchet.
		transformarRatchet = new Transformar(ratchetFinal);
		partida.jugar(transformarRatchet);		
	}
	
	@Test(expected=AlgoformerInactivoException.class)
	public void test05aereoAtraviesaNebulosaQuedaInactivoTercerTurno() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada ratchetInicial = new Coordenada(1,3);
		Coordenada ratchetFinal = new Coordenada(4,2);
		Coordenada bonecrusherInicial = new Coordenada(10,8);
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);

		Transformar transformarRatchet = new Transformar(ratchetInicial);
		partida.jugar(transformarRatchet);
		
		// Pasa el turno Decepticons.
		Transformar transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);
		
		// Muevo a Ratchet a la Nebulosa.
		Mover moverBumblebee = new Mover(partida.crearMovimiento(ratchetInicial, ratchetFinal));
		partida.jugar(moverBumblebee);
		
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);		
		
		// Pasa el primer turno Autobots (transformo a Optimus).
		partida.jugar(new Transformar(new Coordenada(1,1)));
				
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);

        // Pasa el segundo turno Autobots (transformo a Optimus).
        partida.jugar(new Transformar(new Coordenada(1,1)));

        // Pasa el turno Decepticons.
        partida.jugar(transformarBonecrusher);

        // No puedo utilizar a Ratchet.
		transformarRatchet = new Transformar(ratchetFinal);
		partida.jugar(transformarRatchet);		
	}
	
	@Test
	public void test06aereoAtraviesaNebulosaQuedaActivoCuartoTurno() {
		Jugador jugador1 = new JugadorAutobots("Pepito");
		Jugador jugador2 = new JugadorDecepticons("Pirulo");
		Coordenada ratchetInicial = new Coordenada(1,3);
		Coordenada ratchetFinal = new Coordenada(4,2);
		Coordenada bonecrusherInicial = new Coordenada(10,8);
		
		// Se hardcodean los elementos de acuerdo al mapa adjunto.
		Partida partida = new Partida(jugador1, jugador2);

		Transformar transformarRatchet = new Transformar(ratchetInicial);
		partida.jugar(transformarRatchet);
		
		// Pasa el turno Decepticons.
		Transformar transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);
		
		// Muevo a Ratchet a la Nebulosa.
		Mover moverBumblebee = new Mover(partida.crearMovimiento(ratchetInicial, ratchetFinal));
		partida.jugar(moverBumblebee);
		
		// Pasa el turno Decepticons.
		transformarBonecrusher = new Transformar(bonecrusherInicial);
		partida.jugar(transformarBonecrusher);		
		
		// Pasa el primer turno Autobots (transformo a Optimus).
		partida.jugar(new Transformar(new Coordenada(1,1)));
				
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);
				
		// Pasa el segundo turno Autobots (transformo a Optimus).
		partida.jugar(new Transformar(new Coordenada(1,1)));
				
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);
		
		// Pasa el tercer turno Autobots (transformo a Optimus).
		partida.jugar(new Transformar(new Coordenada(1,1)));
				
		// Pasa el turno Decepticons.
		partida.jugar(transformarBonecrusher);		
			
		// Puedo utilizar a Ratchet.
		transformarRatchet = new Transformar(ratchetFinal);
		partida.jugar(transformarRatchet);		
	}

}
