package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * 03.05.2018
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {


    @Parameter(names = "-classFolder")
    private String classFolder;

    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        try {
            main.run();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void run() throws Exception {
        URL url = new URL(new File(this.classFolder).toURI().toString());
        URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url}, getClass().getClassLoader());

        Files
                .list(Paths.get(this.classFolder))
                .forEach(file -> {
                    try {
                        String className = file.getFileName().toString().substring(0, file.getFileName().toString().length() - 6);
                        Class newClass = loader.loadClass(className);
                        System.out.println("Класс: " + className);
                        System.out.println();

                        Field[] fields = newClass.getFields();
                        Constructor[] constructors = newClass.getConstructors();
                        Method[] methods = newClass.getMethods();

                        System.out.println("Конструкторы:");
                        for (Constructor constructor: constructors)
                            System.out.println(constructor);
                        System.out.println();

                        System.out.println("Поля:");
                        for (Field field : fields)
                            System.out.println(field);
                        System.out.println();

                        System.out.println("Методы: ");
                        for(Method method: methods)
                            System.out.println(method);
                        System.out.println();

                        System.out.println("____________________________________");

                        System.out.println();

                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                });
    }
}
//C:\Users\Timur Kh\Desktop\KHAFIZYANOV_11_702\carsAndUsers\out\production\carsAndUsers\ru\itis