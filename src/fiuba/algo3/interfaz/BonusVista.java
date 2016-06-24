package fiuba.algo3.interfaz;

import java.util.ArrayList;

import fiuba.algo3.modelo.Coordenada;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class BonusVista extends StackPane {
	
	private Image icon;
    private String imagen;
	
	public BonusVista(int x, int y, String nombre) {
		  
		  imagen = null;
		  if (nombre != null) {
			  if (nombre == "Chispa Suprema"){
				  imagen = nombre.concat(".gif");
			  }else
			  imagen = nombre.concat(".png");
		  	  icon = new Image(imagen, 50, 50, false, false);
		  	  setAlignment(Pos.CENTER);
		  	  getChildren().add(new ImageView(icon));
		  	  relocate(x * Vista.TAM_CASILLERO, y * Vista.TAM_CASILLERO);
		  	
		  	  	
	      }
	}
}
