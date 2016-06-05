package fiuba.algo3.modelo;

/**
 * Created by Julian Garate on 6/4/16.
 */
public class Optimus extends Autobot{

    public Optimus() {
        this.nombre = "Optimus";
        this.puntosDeVida = 500;
        this.modoActivo = new Modo("Optimus Humanoide", 50, 2, 2);
        this.modoInactivo = new Modo("Peterbilt 379", 15, 4, 5);
    }
}
