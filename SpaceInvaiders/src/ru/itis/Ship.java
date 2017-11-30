package ru.itis;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Ship extends Entity {
    private Main game;

    public Ship(Main game, Image ref, int x, int y, Group root){
        super (ref, x, y, root);
        this.game = game;
    }

    public void move (long delta) {
        if ((dx < 0) && (x<10)) {
            return;
        }
        if ((dx > 0) && (x > 750)) {
            return;
        }

        super.move(delta);
    }
    public void collidedWith(Entity other){
        if (other instanceof Alien) {
            game.notifyDeath();
        }
    }
}

