import classes.Terminal;
import context.ApplicationContextImpl;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("src\\main\\java\\classes");

        ApplicationContextImpl applicationContext = ApplicationContextImpl.getContext();
        applicationContext.addResources(file1);

        Terminal terminal1 = applicationContext.getComponent(Terminal.class);
        System.out.println(terminal1);
        Terminal terminal2 = applicationContext.getComponent(Terminal.class);
        System.out.println(terminal2);
    }
}
