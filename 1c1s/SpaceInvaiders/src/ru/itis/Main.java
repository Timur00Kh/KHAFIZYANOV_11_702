package ru.itis;

import javafx.geometry.VPos;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


//import static sample.Util.*;


public class Main extends Application {
    Text screentext, waitingForKey, message;
    private int pressCount = 1;
    //все сущности, существующие в игре
    private ArrayList entities = new ArrayList();
    //лист сущностей, которых нужно убрать из игры
    private ArrayList removeList = new ArrayList();
    //скорость объектов
    private double moveSpeed = 300;
    //время последнего выстрела
    private long lastFire = 0;
    //интервал последнего выстрела
    private long firingInterval = 400;
    //инопланетяне
    private int alienCount;
    //сообщение на экране
    private String messageString = "";
    //ожидание нажатие клавиши
    private boolean waitingForKeyPress = true;
    //левая и правая клавиши нажаты
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean firePressed = false;
    private boolean logicRequiredThisLoop = false;



    public static double scalar = 1.0;
    private int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
    public static void main (String[]args){
        Application.launch(Main.class, args);
    }

    Text text = new Text();

    public static Group root = new Group();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Space Invaders");
        root = new Group();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT, Color.LIGHTGREEN);

        startGame();

        initContent(root);

        primaryStage.setScene(scene);
        primaryStage.setVisible(true);
        initTimeline();
        timeline.play();
    }

    private void startGame() {
        // инициализировать сущности и удалить предыдущие
        entities.clear();
        initEntities();

        // очистить нажатые клавиши
        leftPressed = false;
        rightPressed = false;
        firePressed = false;
    }

    private void initEntities(){
        Ship = new Ship(this, IMAGE_SHIP, 370, 550, root);
        entities.add(Ship);

        alienCount = 0;
        for (int row=0;row<5;row++) {
            for (int x=0;x<12;x++) {
                //опять проверить конструктор
                Entity alien = new Alien(this, IMAGE_ALIEN, 100+(x*50),(50)+row*30, root);
                entities.add(alien);
                alienCount++;
            }
        }
    }

    public void updateLogic() {
        logicRequiredThisLoop = true;
    }

    public void removeEntity(Entity entity) {
        removeList.add(entity);
    }

    public void notifyDeath(){
        messageString = "Oh no! You died, deal with it!";
        //ожидание нажатие клавиши
        waitingForKeyPress = true;
    }

    public void notifyWin(){
        messageString = "Well done! You won!";
        //ожидание нажатие клавиши
        waitingForKeyPress = true;
        for(int i=0;i<entities.size();i++){
            Entity e = (Entity) entities.get(i);
            e.content.setVisible(false);
        }

        entities.removeAll(entities);

    }




    public void notifyAlienKilled(){
        alienCount--;
        if (alienCount == 0) {
            notifyWin();
        }
        for (int i = 0; i< entities.size(); i++){
            Entity entity = (Entity ) entities.get(i);
            if (entity instanceof Alien) {
                //увеличить скорость на 2%
                entity.setHorizontalMovement(entity.getHorizontalMovement() *1.02);
            }
        }
    }
    public void tryToFire() {
        // проверьте как долго мы ждали для выстрела
        if (System.currentTimeMillis() - lastFire < firingInterval) {
            return;
        }

        // если мы подождали, то создаем выстрел
        lastFire = System.currentTimeMillis();
        //проверить конструктор
        Shot shot = new Shot (Ship.getX()+10,Ship.getY()-10, root);
        entities.add(shot);
    }

    private Timeline timeline;
    public static final Duration ANIMATION_TIME = Duration.valueOf("20");
    // время анимации


    private void initTimeline() {
        timeline = new Timeline();
        // это будет происходить до тех пор, пока игра не закончится
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(ANIMATION_TIME, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                screentext.setContent("Entities size: " + entities.size());



                // цикл, который говорит сущностям передвигаться
                if (!waitingForKeyPress) {
                    for (int i=0;i<entities.size();i++) {
                        Entity entity = (Entity) entities.get(i);
                        entity.move(20);
                    }
                }





                //коллизии с другими сущностями
                for (int p=0;p<entities.size();p++) {
                    for (int s=p+1;s<entities.size();s++) {
                        Entity me = (Entity) entities.get(p);
                        Entity him = (Entity) entities.get(s);

                        if (me.collidesWith(him)) {
                            me.collidedWith(him);
                            him.collidedWith(me);

                        }
                    }
                }

                // remove any entity that has been marked for clear up
                root.getChildren().remove(removeList.get(alienCount));

                entities.removeAll(removeList);
                removeList.clear();
                //убирает сущность


                // применение логики объекта в игровом цикле
                if (logicRequiredThisLoop) {
                    for (int i=0;i<entities.size();i++) {
                        Entity entity = (Entity) entities.get(i);
                        entity.doLogic();
                    }

                    logicRequiredThisLoop = false;
                }

                // if we're waiting for an "any key" press then draw the
                // current message
                if (waitingForKeyPress) {
                    waitingForKey.setContent(" Press \nany key");
                    message.setContent(messageString);
                }
                else{
                    waitingForKeyString = "";
                    waitingForKey.setContent("");

                    messageString= "";
                    message.setContent("");
                }

                if(!waitingForKeyPress){
                    Ship.setHorizontalMovement(0);
                }
                if(leftPressed && !rightPressed){Ship.setHorizontalMovement(-moveSpeed);}//moving=-400;
                if(rightPressed && !leftPressed){Ship.setHorizontalMovement(moveSpeed);}

                // попытка стрелять
                if (firePressed && !waitingForKeyPress) {
                    tryToFire();
                }
            }
        });
        timeline.getKeyFrames().add(kf);
    }

    Ship Ship;
    String waitingForKeyString= "  Press\n"+  "Any Key", messageString="";




    public void initContent(Group root){
        ImageView background = new ImageView();
        background.setFocusTraversable(true);

        background.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.LEFT) {
                    leftPressed=true;
                }
                if (ke.getCode() == KeyCode.RIGHT){
                    rightPressed=true;
                }
                if (ke.getCode() == KeyCode.SPACE) {
                    firePressed = true;
                }
                if (ke.getCode() == KeyCode.A) {
                    scalar=1.8;
                }
                if (ke.getCode() == KeyCode.S) {
                    scalar=0.5;
                }

            }
        });
        background.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(ke.getCode() == KeyCode.LEFT){
                    leftPressed=false;
                }
                if (ke.getCode() == KeyCode.RIGHT){
                    rightPressed=false;
                }
                if (ke.getCode() == KeyCode.SPACE) {
                    firePressed = false;
                }

            }});


        background.setOnKeyTyped(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {

                //тут веселая ситуация, игра ожидает нажатие клавиши
                if (waitingForKeyPress) {
                    if (pressCount == 1) {
                        // если игра получила клавишу, то игра начинается
                        waitingForKeyPress = false;
                        startGame();
                        pressCount = 0;
                    } else {
                        pressCount++;
                    }
                }

                // эскейп выход системы
                if (ke.getCode() == KeyCode.ESCAPE) {
                    System.exit(0);
                }
            }
        });
    }
}


