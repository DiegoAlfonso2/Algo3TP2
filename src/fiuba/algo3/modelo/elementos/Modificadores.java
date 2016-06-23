package fiuba.algo3.modelo.elementos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.modelo.excepciones.BonusYaAgregadoException;

public class Modificadores {
	
	private List<Bonus> bonus;
	
	public Modificadores() {
		this.bonus = new ArrayList<Bonus>();
	}

	public void agregar(Bonus bonusNuevo) {
		for (Bonus unBonus : this.bonus) {
			if (unBonus.getNombre() == bonusNuevo.getNombre())
				throw new BonusYaAgregadoException();
			}
		bonus.add(bonusNuevo);
	}

	public boolean tieneBonus(String bonusNuevo) {
		Iterator<Bonus> iterador = this.bonus.iterator();
		while (iterador.hasNext()){
			if (iterador.next().getNombre() == bonusNuevo){
				return true;
			}
		}
		return false;
	}

	public int modificarAtaque(int ataque) {
		int ataqueParcial = ataque;
		for (Bonus unBonus : bonus) {
			ataqueParcial = unBonus.modificarAtaque(ataqueParcial);
		}
		return ataqueParcial;
	}

	public int modificarDefensa(int ataqueRecibido) {
		int ataqueRecibidoParcial = ataqueRecibido;
		for (Bonus unBonus : bonus) {
			ataqueRecibidoParcial = unBonus.modificarDefensa(ataqueRecibidoParcial);
		}
		return ataqueRecibidoParcial;
	}

	public int modificarVelocidad(int velocidad) {
		int velocidadParcial = velocidad;
		for (Bonus unBonus : bonus) {
			velocidadParcial = unBonus.modificarVelocidad(velocidadParcial);
		}
		return velocidadParcial;
	}

	public void descontarTurnos() {
		for (Bonus unBonus : bonus) {
			unBonus.descontarTurno();
		}
	}

	public void activarBonus() {
		for (Bonus unBonus : bonus) {
			unBonus.activar();
		}
	}

}
