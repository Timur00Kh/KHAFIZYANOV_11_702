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
//    public ArrayList<MyDot> dots = new ArrayList<MyDot>();

    public MyArray dots;
//    public ArrayList lines = new

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

//        Добавляем точки в линии
        for (int g = 0; g < dots.size(); g++) {
            if (dots.isNotRemoved(g)) {
                int maxY = dots.getY(g);
                int maxX = dots.getX(g);
                int j;
                XYChart.Series tempLine = new XYChart.Series();
                // 6 1 4 3 8 4 5 7 4 9 6 5 1
                // 10 1 1 1 7 5 2 2 3 3 4 8 6 9 8 5 11 7 2 10 3
                tempLine.getData().add(new XYChart.Data<>(dots.getX(g), dots.getY(g)));
                dots.remove(g);
                for (int i = 0; i < dots.size(); i++) {
                    if (dots.getY(i) >= maxY && dots.getX(i) >= maxX && dots.isNotRemoved(i)) {
                        maxY = dots.getY(i);
                        maxX = dots.getX(i);
                        j = i;
                        tempLine.getData().add(new XYChart.Data<>(dots.getX(i), dots.getY(i)));
                        dots.remove(i);
                    }
                }
                chart.getData().add(tempLine);
            }
        }

//      Выводим все на экран
        VBox vBox = new VBox();
        vBox.getChildren().add(chart);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();
    }

    static MyDot find(MyArray a, int lower, int higher, MyDot x) {
        int mid = lower + (higher - lower) / 2;
        if (a.isNotRemoved(mid)) {
            if (a.getDot(mid).isGreater(x)) {
                return find(a, lower, mid, x);
            } else if (x.isGreater(a.getDot(mid))) {
                return find(a, mid, higher, x);
            } else if (a.getY(mid) == x.y && a.getX(mid) == x.x) {
                return a.getDot(mid);
            } else {
                return a.getDot(mid);
            }
        }
        return new MyDot(1, 1);
    }
}


//5 1 1 1 2 8 3 10 8 11 7
//30 11 22 3 6 1 6 8 9 34 5 67 7 1 2 3 89 65 4 6 1 55 31 57 84 3 5 81 22 41 75 34 67 34 65 23 93 72 7 89 3 6 66 4 87 3 66 3 57 4 25 6 45 34 23 78 24 48 24 87 34