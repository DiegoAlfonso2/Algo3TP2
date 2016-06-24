package fiuba.algo3.interfaz;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.superficies.Superficie;
import javafx.geometry.Pos;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class CasilleroVista extends Rectangle {
	
	private BonusVista bonus;
	private AlgoformerVista algoformer;
	
	public CasilleroVista(int x, int y, Superficie aerea, Superficie tierra) {
		
		String aire = aerea.getClass().getSimpleName();
		String terrestre = tierra.getClass().getSimpleName();
		Image img = new Image(terrestre.concat(aire).concat(".jpg"), 50, 50, false, false);
    	setFill(new ImagePattern(img));
    	
    	setStroke(Color.BLACK);
    	
        setWidth(Vista.TAM_CASILLERO);
        setHeight(Vista.TAM_CASILLERO);
                        
        relocate(x * Vista.TAM_CASILLERO, y * Vista.TAM_CASILLERO);
                       
    }
	
	public void agregarBonus (BonusVista bonus){
		this.bonus = bonus;
	}
	
	public BonusVista obtenerBonus() {
		return this.bonus;
	}
	
	public AlgoformerVista obtenerAlgoformer(){
		return this.algoformer;
	}
	
	public void agregarAlgoformer(AlgoformerVista algoformer){
		this.algoformer = algoformer;
	}
	
	public void borrarAlgoformer(){
		this.algoformer = null;
	}

}
    
        
    
