package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Client extends Application {

	int [][] tiles = new int [120][256]; //creates grid on the plane
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	GridPane map = new GridPane();
    	
    	getTiles(map);
    	
    	Scene scene = new Scene(map);
    	primaryStage.setScene(scene);
    	primaryStage.show();
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void getTiles(GridPane map) {
    	for (int i = 0; i < 42; i++) { //every section for the tiles 
    		for (int j = 0; j < 24; j++) {
    			int type = tiles[i][j];
    			Tile grid = new Tile(type); //creates the tile object
    			map.add(grid,i,j);
    		}
    	}
    }
}
