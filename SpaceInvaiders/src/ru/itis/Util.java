package ru.itis;
import javafx.scene.image.Image;

public final class Util {
    private static final String URL_PREFIX = Util.class.getClassLoader().getResource("images").toExternalForm();

    public static Image createImage(String filename) {
        return new Image(URL_PREFIX + "/" + filename);
    }

    public static Image createImage(String filename, float width, float height) {
        return new Image(URL_PREFIX + "/" + filename, width, height, true, true, false);
    }

    public static final Image IMAGE_SHIP = createImage("ship.gif", 33f, 23f);
    public static final Image IMAGE_ALIEN = createImage("alien.gif", 43f, 29f);
    public static final Image IMAGE_SHOT = createImage("shot.gif", 12f, 23f);

}