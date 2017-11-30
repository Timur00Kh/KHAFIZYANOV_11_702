package ru.itis;

import javafx.scene.Group;
import javafx.scene.image.Image;

public class Alien extends Entity {
    private double moveSpeed = 75;
    private Main game;

    public Alien(Image ref, int x, int y, Group root) {
        super(ref, x, y, root);
        this.game = game;
        dx = -moveSpeed;
    }

    public void move(long delta) {
        if ((dx < 0) && (x < 10)) {
            game.updateLogic();
        }
        if ((dx > 0) && (x > 750)) {
            game.updateLogic();
        }
        super.move(delta);
    }

    public void doLogic() {
        dx = -dx;
        y += 10;

        if (y > 570) {
            game.notifyDeath();
        }
    }

    public void collidedWith(Entity other) {
    }
}
