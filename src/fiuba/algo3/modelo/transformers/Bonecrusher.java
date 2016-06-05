package fiuba.algo3.modelo;

/**
 * Created by Julian Garate on 6/4/16.
 */
public class Bonecrusher extends Decepticon{

    public Bonecrusher() {
        this.nombre = "Bonecrusher";
        this.puntosDeVida = 200;
        this.modoActivo = new Modo("Bonecrusher Humanoide", 30, 3, 1);
        this.modoInactivo = new Modo("Jet Cibertroniano", 30, 3, 8);
    }


}
