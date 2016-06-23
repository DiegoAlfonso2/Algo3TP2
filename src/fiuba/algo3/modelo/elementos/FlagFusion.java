package fiuba.algo3.modelo.elementos;


/**
 * Created by Julian Garate on 6/22/16.
 */
public class FlagFusion extends Bonus {

    public FlagFusion() {
        this.nombre = "FlagFusion";
        this.activo = false;
    }


    @Override
    public FlagFusion definirFlagFusion() {
        return this;
    }


    @Override
    public int modificarAtaque(int ataqueParcial) {
        return ataqueParcial;
    }

    @Override
    public int modificarDefensa(int ataqueRecibido) {
        return ataqueRecibido;
    }

    @Override
    public int modificarVelocidad(int velocidadParcial) {
        return velocidadParcial;
    }

    @Override
    public boolean algoformerDisponible() {
        if(this.activo) return false;
        return true;
    }

    public void inicializarTurnos() {
        if (this.activo)
            this.turnosRestantes = 2;
    }

    @Override
    public boolean modificarFusionable(){
        if (this.turnosRestantes == 0)
            return true;
        return false;
    }
}
