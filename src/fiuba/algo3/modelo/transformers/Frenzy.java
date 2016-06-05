package fiuba.algo3.modelo;

/**
 * Created by Julian Garate on 6/4/16.
 */
public class Frenzy extends Decepticon{

    public Frenzy() {
        this.nombre = "Frenzy";
        this.puntosDeVida = 400;
        this.modoActivo = new Modo("Frenzy Humanoide", 10, 5, 2);
        this.modoInactivo = new Modo("Renault Duster", 25, 2, 6);
    }


}