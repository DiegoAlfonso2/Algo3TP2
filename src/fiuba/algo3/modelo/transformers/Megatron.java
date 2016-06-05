package fiuba.algo3.modelo;

/**
 * Created by Julian Garate on 6/4/16.
 */
public class Megatron extends Decepticon{

    public Megatron() {
        this.nombre = "Megatron";
        this.puntosDeVida = 550;
        this.modoActivo = new Modo("Megatron Humanoide", 10, 3, 1);
        this.modoInactivo = new Modo("Jet Cibertroniano", 55, 2, 8);
    }


}
