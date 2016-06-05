package fiuba.algo3.modelo;

/**
 * Created by Julian Garate on 6/4/16.
 */
public class Ratchet extends Autobot{

    public Ratchet() {
        this.nombre = "Ratchet";
        this.puntosDeVida = 150;
        this.modoActivo = new Modo("Ratchet Humanoide", 5, 5, 1);
        this.modoInactivo = new Modo("F22 raptor", 35, 2, 8);
    }
}
