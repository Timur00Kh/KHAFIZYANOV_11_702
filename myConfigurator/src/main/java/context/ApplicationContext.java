package context;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationContext {
    void addResources(ArrayList<File> files);
    public <T> T getComponent (Class<T> componentClass);
}
