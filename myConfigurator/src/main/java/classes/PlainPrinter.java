package classes;

public class PlainPrinter implements Printer {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
