package ru.itis;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Shot extends Entity {
    private double moveSpeed = -300;
    private Main game;
    private boolean used = false;

    public Shot(Main game, int x, int y, Group root, Image ref){
        super (ref, x, y, root);
        this.game = game;
        dy = moveSpeed;
    }

    public void move (long delta){
        super.move(delta);
        if (y<-100){
            game.removeEntity(this);
        }
    }

    public void collidedWith (Entity other){
        if (used) {
            return;
        }
        if (other instanceof Alien){
            this.content.setVisible(false);
            game.removeEntity(this);
            other.content.setVisible(false);
            game.removeEntity(other);
            game.notifyAlienKilled();
            used = true;
        }
    }
}