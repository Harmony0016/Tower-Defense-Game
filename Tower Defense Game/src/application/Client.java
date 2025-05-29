package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Client extends Application {

    private static final int SCENE_WIDTH = 1920;
    private static final int SCENE_HEIGHT = 1080;
    private static final int GRID_WIDTH = 854;
    private static final int GRID_HEIGHT = 480;
    private static final int CELL_SIZE = 40; // You can change this to control grid spacing

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawGrid(gc);

        root.getChildren().add(canvas);
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setTitle("1920x1080 Plane with 854x480 Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawGrid(GraphicsContext gc) {
        double startX = (SCENE_WIDTH - GRID_WIDTH) / 2.0;
        double startY = (SCENE_HEIGHT - GRID_HEIGHT) / 2.0;
        double endX = startX + GRID_WIDTH;
        double endY = startY + GRID_HEIGHT;

        gc.setStroke(Color.GRAY);
        gc.setLineWidth(1);

        // Vertical grid lines
        for (double x = startX; x <= endX; x += CELL_SIZE) {
            gc.strokeLine(x, startY, x, endY);
        }

        // Horizontal grid lines
        for (double y = startY; y <= endY; y += CELL_SIZE) {
            gc.strokeLine(startX, y, endX, y);
        }

        // Outline of the grid
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeRect(startX, startY, GRID_WIDTH, GRID_HEIGHT);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
