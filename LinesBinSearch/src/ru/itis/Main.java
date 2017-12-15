package ru.itis;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public MyArray dots;
    public ArrayList<MyDot> lines = new ArrayList();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner scanner = new Scanner(System.in);
        LineChart chart = new LineChart(new NumberAxis(), new NumberAxis());
        int n = scanner.nextInt();
        dots = new MyArray(n);
        int callCount = 0;

//        Считываем значения с консоли.
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            dots.add(new MyDot(x, y));
        }

        dots.sort();
        dots.print();
        System.out.println("============");

        for (int i = 0; i < n; i++) {
            addToLine(dots.getDot(i));
        }

//      Выводим все на экран
        VBox vBox = new VBox();
        vBox.getChildren().add(chart);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();
    }

    static int find(ArrayList<MyDot> a, int lower, int higher, MyDot x) {
        int mid = lower + (higher - lower) / 2;
        int delta = Math.abs(higher - lower);

        if (x.y >= a.get(lower).y && delta > 1) {
            return lower;
        }
        if (x.y >= a.get(higher).y && delta > 1) {
            return higher;
        }

        if (x.y < a.get(mid).y && delta > 1) {
            return find(a, mid, higher, x);
        } else if (x.y > a.get(mid).y && delta > 1) {
            return find(a, lower, mid, x);
        } else if (x.y > a.get(mid).y && delta == 1) {
            return mid;
        } else {
            return -1;
        }
//        return new MyDot(1, 1);
    }



    public void addToLine(MyDot dot) {
        if (lines.size() == 0) {
            lines.add(dot);
            return;
        }
        int i = find(lines, 0, lines.size() - 1, dot);
        if (i != -1) {
            lines.set(i, dot);
            System.out.println(i);
            dot.print();
        } else {
            lines.add(dot);
            System.out.println(lines.size() - 1);
            dot.print();
        }
    }
}

// 6 1 4 3 8 4 5 7 4 9 6 5 1
// 10 1 1 1 7 5 2 2 3 3 4 8 6 9 8 5 11 7 2 10 3
//5 1 1 1 2 8 3 10 8 11 7
//30 11 22 3 6 1 6 8 9 34 5 67 7 1 2 3 89 65 4 6 1 55 31 57 84 3 5 81 22 41 75 34 6t7 34 65 23 93 72 7 89 3 6 66 4 87 3 66 3 57 4 25 6 45 34 23 78 24 48 24 87 34