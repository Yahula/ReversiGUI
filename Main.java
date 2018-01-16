package TheGame;/**
 * Created by sagi on 13/01/2018.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import TheGame.Board;

public class Main extends Application {
    private Board b = new Board(6,6);
    public static void main(String[] args) {
        launch(args);
    }

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(600,600);

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++) {
                Tile tile = new Tile(i,j,b);

                tile.setTranslateX(j * 100);
                tile.setTranslateY(i * 100);

                root.getChildren().add(tile);
            }
    }
    return root;
    }

    private class Tile extends StackPane {
        int row,column;
        public Tile(int r , int c, Board b) {
            row=r;
            column =c;
            Rectangle border = new Rectangle(100, 100);
            border.setFill(Color.LIGHTGRAY);
            border.setStroke(Color.WHITE);

            setAlignment(Pos.CENTER);
            getChildren().addAll(border);

            setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    System.out.println(b.getCell(row+1,column+1));
                    b.setCell(row,column,-1);
                    System.out.println(b.getCell(row+1,column+1));
                    getChildren().add(blackDisk());
                }
                else if (event.getButton() == MouseButton.SECONDARY) {
                    System.out.println(b.getCell(row+1,column+1));
                    b.setCell(row,column,1);
                    System.out.println(b.getCell(row+1,column+1));
                    getChildren().add(whiteDisk());
                }
            });


        }
        private Circle blackDisk() {return new Circle(25,Color.BLACK);}
        private Circle whiteDisk() {return new Circle(25,Color.WHITE);}
    }





    @Override
    public void start(Stage primaryStage) {

        try {
//            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
//            Scene scene = new Scene(root,400,350);
            Scene scene = new Scene(createContent());
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//            primaryStage.setTitle("FXML Welcome");
            primaryStage.setScene(scene);
            primaryStage.show(); }

            catch(Exception e) {
            e.printStackTrace();
        }
}
}
