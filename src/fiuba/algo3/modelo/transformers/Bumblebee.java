package fiuba.algo3.modelo;

/**
 * Created by Julian Garate on 6/4/16.
 */
public class Bumblebee extends Autobot{

    public Bumblebee() {
        this.nombre = "Bumblebee";
        this.puntosDeVida = 350;
        this.modoActivo = new Modo("Bumblebee Humanoide", 40, 1, 2);
        this.modoInactivo = new Modo("Chevrolet Camaro Concept", 20, 3, 15);
    }
}
