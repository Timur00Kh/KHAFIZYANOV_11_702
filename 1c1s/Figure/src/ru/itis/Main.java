package ru.itis;

public class Main {

    public static void main(String[] args) {
        Quadrat quad1 = new Quadrat(5);
        Ellipse ell1 = new Ellipse( 4, 3);
        Circle cir1 = new Circle(1);
        Rectangle rec1 = new Rectangle(4,5);
        Figure figures[] = {ell1, cir1, rec1, quad1};
        //System.out.println(figures[1].perimetr);
        for (Figure figure: figures){
            System.out.println(figures.perimetr + " " + figures.square);
        }
    }
}