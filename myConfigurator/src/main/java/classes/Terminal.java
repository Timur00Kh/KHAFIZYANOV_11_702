package classes;

public class Terminal {
    private Printer printer;

    public Terminal(Printer printer) {
        this.printer = printer;
    }

    @Override
    public String toString() {
        return "Terminal@" + Integer.toHexString(this.hashCode()) + "{" +
                "printer=" + printer +
                '}';
    }

}
