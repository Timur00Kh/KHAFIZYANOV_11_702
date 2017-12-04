package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.effect.*;

public class Main extends Application implements EventHandler<KeyEvent> {
    public Stage theStage;
    public VBox menu;
    public VBox menuEl;
//  Stage mainStage;
//    MainStageController mainStageController;
    //Controller controller = new Controller();


    @Override
    public void start(Stage primaryStage) throws Exception{

        //Подгрузка шрифтов что-то не работает...
        Font.loadFont(Main.class.getResource("InkyThinPixels.ttf").toExternalForm(),10);

        theStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        menu = (VBox) root.lookup("#menu");
        menuEl = (VBox) root.lookup(".menuEl");
        menuController();


        Scene scene = new Scene(root, 1280, 720);
        scene.setOnKeyPressed(this);
        theStage.setResizable(false);
        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void menuController() {
        menuEl.setOnMouseClicked(event -> {
            menu.setVisible(false);
            Label label = (Label) menuEl.lookup(".buttonText");
            label.setText("Continue");
            //gameStart() or gameContinue()
        });
        VBox exitButton = (VBox) menu.lookup("#exitButton");
        exitButton.setOnMouseClicked(event -> {
            theStage.close();
        });
    }

    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            menu.setVisible(true);
            //seGameOnPause() что-то такое
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
