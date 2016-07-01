package fiuba.algo3.interfaz;

import java.awt.Font;
import java.util.List;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.acciones.Atacar;
import fiuba.algo3.modelo.acciones.Mover;
import fiuba.algo3.modelo.acciones.Transformar;
import fiuba.algo3.modelo.excepciones.FinalException;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.modelo.superficies.Superficie;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Vista extends Application {
	public static final int TAM_CASILLERO = 60;
    public static final int ANCHO = 10;
    public static final int ALTO = 10;
	    
    private CasilleroVista[][] tablero = new CasilleroVista[ANCHO][ALTO];

    private Group casilleros  = new Group();
    private Group algoformers = new Group();
    private Group bonuss      = new Group();
    public static Stage secondStage;
    
    public static Partida partida;
    
    private long diff;
    private long time1;
    private long time2;
    

	@Override
	public void start(Stage primaryStage) {
		                
		JugadorAutobots jugador1 = new JugadorAutobots("Pepito");
		JugadorDecepticons jugador2 = new JugadorDecepticons("Pirulo");
		partida = new Partida(jugador1, jugador2);
		
		Scene scene = new Scene(crearContenido());
        primaryStage.setTitle("Algoformers");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
    public static int posTablero(double pixel) {
        return (int)(pixel + TAM_CASILLERO / 2) / TAM_CASILLERO;
    }
	
    private Parent crearContenidoVentana(int unX, int unY, AlgoformerVista algoformer) {
    	Pane root = new Pane();
        root.setPrefSize(205, 100);
        root.setBorder(null);
        Coordenada coord = new Coordenada (unX+1, unY+1);
        String nombre = partida.obtenerModoAlgoformer(coord);
        
        int vida = partida.obtenerVidaAlgoFormer(coord);
        String strVida = "" + vida;
        int ataque = partida.obtenerAtaqueAlgoFormer(coord);
        String strAtaque = "" + ataque;
        int velocidad = partida.obtenerVelocidadAlgoFormer(coord);
        String strVelocidad = "" + velocidad;
        
                
        Label etiqueta = new Label(nombre);
        
        Label ptosVida = new Label("Puntos de Vida: ".concat(strVida));
        Label ptosAtaque   = new Label("Capacidad de Ataque: ".concat(strAtaque));
        Label ptosVelocidad = new Label("Velocidad: ".concat(strVelocidad));
      
        VBox contenedorPrincipal = new VBox(etiqueta, ptosVida, ptosAtaque, ptosVelocidad);
                
        root.getChildren().addAll(contenedorPrincipal);
        
        return root;
    }
    
    private Parent crearContenido() {
    	int x;
    	int y;
    	String nombreAlgoformer;
    	
        Pane root = new Pane();
        root.setPrefSize(ANCHO * TAM_CASILLERO, ALTO * TAM_CASILLERO);
        root.getChildren().addAll(casilleros, algoformers, bonuss);
               
        for (y = 0; y < ALTO; y++) {
            for (x = 0; x < ANCHO; x++) {
            	Coordenada coordenada = new Coordenada(x+1,y+1);
            	
            	Superficie aerea = partida.obtenerSuperficieAerea(coordenada);
            	Superficie tierra = partida.obtenerSuperficieTerrestre(coordenada);
                CasilleroVista casillero = new CasilleroVista(x, y, aerea, tierra);
                tablero[x][y] = casillero;
                casilleros.getChildren().add(casillero);
                
                AlgoformerVista algoformer = null;
                
                //Agregar Bonus y Chispa
                try {
                	String tipoBonus = partida.obtenerContenido(coordenada).getNombre();
                	BonusVista bonus = new BonusVista(x, y, tipoBonus);
                	bonuss.getChildren().add(bonus);
                	casillero.agregarBonus(bonus);
                } catch (Exception s){
                	
                }
                
                //Agregar Algoformers
                try {
                	nombreAlgoformer = partida.obtenerModoAlgoformer(coordenada);
                	algoformer = crearAlgoformer(x, y, nombreAlgoformer);
                	casillero.agregarAlgoformer(algoformer);
                }
                	catch (Exception s){
                		
                	}
          
                if (algoformer != null) {
                    algoformers.getChildren().add(algoformer);
                }
      
            }
        }

        return root;
    }
	
    
	private AlgoformerVista crearAlgoformer(int x, int y, String nombre) {
		
		AlgoformerVista algoformer = new AlgoformerVista (x, y, nombre);
		
		algoformer.setOnMouseEntered(e ->{
			int newX = posTablero(algoformer.getLayoutX());
            int newY = posTablero(algoformer.getLayoutY());
			Scene scene = new Scene(crearContenidoVentana(newX, newY, algoformer));
			secondStage = new Stage();
			secondStage.setTitle("Algoformers");
	        secondStage.setScene(scene);
	        secondStage.setX(e.getScreenX()+10);
	        secondStage.setY(e.getScreenY()+10);
	        secondStage.show();
		});
		
		algoformer.setOnMouseExited(e ->{
			secondStage.close();
		});
		
		algoformer.setOnMouseReleased(e -> {
			int newX = posTablero(algoformer.getLayoutX());
			int newY = posTablero(algoformer.getLayoutY());
			if (e.getButton()==MouseButton.PRIMARY){
				algoformer.movimiento = (partida.crearMovimiento(new Coordenada(x+1,y+1), new Coordenada(newX+1, newY+1)));	
				Mover move = new Mover(algoformer.movimiento);
				try {
					partida.jugar(move);
					this.borrarBonus(algoformer.movimiento);
					algoformer.mover(newX, newY);
					CasilleroVista casillero = tablero[algoformer.posX][algoformer.posY];
					casillero.borrarAlgoformer();
					casillero = tablero[newX][newY];
					casillero.agregarAlgoformer(algoformer);
				} 	catch (MovimientoInvalidoException cve) {
						algoformer.mover(algoformer.posX, algoformer.posY);
						
					}
					catch (FinalException a){
					//termina el Juego
						 
					}
					catch (Exception c){
						algoformer.mover(algoformer.posX, algoformer.posY);
					}
			}else if (e.getButton()==MouseButton.SECONDARY){
				Coordenada coordAtaque = new Coordenada (algoformer.posX+1, algoformer.posY+1); 
				Coordenada coordDefensor = new Coordenada (newX+1, newY+1); 
				Atacar atacar = new Atacar(coordAtaque, coordDefensor);
				try {
					int vida = partida.obtenerVidaAlgoFormer(coordDefensor);
					int ataque = partida.obtenerAtaqueAlgoFormer(coordAtaque);
					partida.jugar(atacar);
					algoformer.mover(algoformer.posX, algoformer.posY);
					if (vida<= ataque){
						CasilleroVista casillero = tablero[newX][newY];
						algoformers.getChildren().remove(casillero.obtenerAlgoformer());
						casillero.borrarAlgoformer();
					}
					
				}	catch (FinalException a){
					//termina el Juego
					}
					catch (Exception s){
						algoformer.mover(algoformer.posX, algoformer.posY);						
					}
					
				}
			
        });

        algoformer.setOnMousePressed(e -> {

        	algoformer.mouseX = e.getSceneX();
            algoformer.mouseY = e.getSceneY();
            
            diff = 0;
                      
            if(time1==0)
             time1=System.currentTimeMillis();
            else
            time2=System.currentTimeMillis();
            if(time1!=0 && time2!=0){
            diff=time2-time1;
            time1 = System.currentTimeMillis();
            time2 = 0;
            }
            if(diff>0 && diff<200){
            // TRANSFORMAR ----------------------------------------------------------
            	if (e.getButton()==MouseButton.PRIMARY){
            		try {
            			Coordenada coord = new Coordenada (algoformer.posX+1, algoformer.posY+1);
            			Transformar transforma = new Transformar(coord);
            			partida.jugar(transforma);
            			String modo = partida.obtenerModoAlgoformer(coord);
            			algoformers.getChildren().remove(algoformer);
            			CasilleroVista casillero = tablero[algoformer.posX][algoformer.posY];
            			casillero.borrarAlgoformer();
            			int newX = posTablero(algoformer.getLayoutX());
            			int newY = posTablero(algoformer.getLayoutY());
            			AlgoformerVista algof = this.crearAlgoformer(newX, newY, modo);
            			casillero.agregarAlgoformer(algof);
            			algoformers.getChildren().add(algof);
            		} 	catch (Exception a){
        			
        				}
        		
            	}
        	}else {
        		//MOVER-----------------------------------------------------------------
        		if (e.getButton()==MouseButton.PRIMARY){
        			algoformer.movimiento.removeAll(algoformer.movimiento);
        			Coordenada coord = new Coordenada (algoformer.posX+1, algoformer.posY+1);   
        			algoformer.movimiento.add(coord);
        		}
        	}
		});
       
		return algoformer;
	}
	
	private void borrarBonus(List<Coordenada> movimiento) {
		
		for (Coordenada otraCoord : movimiento) {
			int x = otraCoord.obtenerX()-1;
			int y = otraCoord.obtenerY()-1;
			CasilleroVista casillero = tablero[x][y];
			try{
				BonusVista bonus = casillero.obtenerBonus();
				bonuss.getChildren().remove(bonus);
			} catch (Exception c){
				
			}
		}	

	}

	public static void main(String[] args) {
		launch(args);
	}
}
