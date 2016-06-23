package fiuba.algo3.modelo.elementos;

public abstract class ModificadorAgotable extends Bonus {
	
	private int turnosRestantes;
	
	protected ModificadorAgotable(int cantTurnosDuracion) {
		turnosRestantes = cantTurnosDuracion;
	}
	
	@Override
	public void descontarTurno() {
		if (estaActivo()) {
			turnosRestantes--;
		}
	}

	@Override
	public boolean estaActivo() {
		return super.estaActivo() && turnosRestantes > 0;
	}
}
