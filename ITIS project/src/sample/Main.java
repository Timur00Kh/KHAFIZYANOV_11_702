package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Main extends Application  {
    public Stage theStage;
    //Controller controller = new Controller();


    @Override
    public void start(Stage primaryStage) throws Exception{

        Font.loadFont(
                Main.class.getResource("InkyThinPixels.ttf").toExternalForm(),
                10
        );

        theStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 1280, 720);
        //scene.setOnKeyPressed(this);
        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setTheStage(Stage theStage) {
        this.theStage = theStage;
    }

    /*public void handle(KeyEvent event) {
        System.out.println(event.getCode());
        if (event.getCode() == KeyCode.ESCAPE) {
            controller.showMenu();
        }
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}
