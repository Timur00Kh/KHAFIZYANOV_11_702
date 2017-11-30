package ru.itis;

        import javafx.scene.shape.Rectangle;
        import javafx.scene.Group;
        import javafx.scene.Parent;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;


public abstract class Entity {
    protected double x;
    protected double y;
    protected double dx;
    protected double dy;
    private Rectangle me = new Rectangle();
    private Rectangle him = new Rectangle();
    Image ref;
    Group root;
    ImageView content;

    public Entity(Image ref, int x, int y, Group root) {
        this.ref = ref;
        this.root = root;
        this.x = x;
        this.y = y;
        //получение картинки из хранилища, скалирование и размещение
        content = new ImageView();
        content.setSmooth(true);
        content.setImage(ref);

        content.setScaleX(Main.scalar); //scaling
        content.setScaleY(Main.scalar); //scaling


        content.setTranslateX(this.x);
        content.setTranslateY(this.y);
        content.setRotate(0);

        Main.root.getChildren().add(content);
    }

    public void move(long delta) {
        // метод передвижения объектов
        this.x += (delta * this.dx) / 1000;
        this.y += (delta * this.dy) / 1000;

        content.setTranslateX(this.x);
        content.setTranslateY(this.y);


    }

    public void setHorizontalMovement(double dx) {
        this.dx = dx;
    }

    public void setVerticalMovement(double dy) {
        this.dy = dy;
    }

    public double getHorizontalMovement() {
        return dx;
    }

    public double getVerticalMovement() {
        return dy;
    }

    public void doLogic() {

    }

    public double getX() {
        return (int) this.x;
    }

    public double getY() {
        return (int) this.y;
    }

    //столкновение с другой сущностью. тут происходит проверка координат сущностей, длина и ширина объекта
    public boolean collidesWith(Entity other) {
        me.setBounds((int) this.x, (int) this.y, (int) content.getImage().getWidth(), (int) content.getImage().getHeight());
        him.setBounds((int) other.getX(), (int) other.getY(), (int) other.content.getImage().getWidth(), (int) other.content.getImage().getHeight());

        return me.intersects(him);

    }

    public abstract void collidedWith(Entity other);
}

