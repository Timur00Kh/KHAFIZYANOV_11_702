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
    public ArrayList<MyArray> lines;
    public ArrayList<XYChart.Series> liness = new ArrayList();
    public ArrayList<MyDot> lastDotInLine = new ArrayList<>();

    public DifficultyCounter dC = new DifficultyCounter();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner scanner = new Scanner(System.in);
        LineChart chart = new LineChart(new NumberAxis(), new NumberAxis());
        int n = scanner.nextInt();
        dots = new MyArray(n);
//        lines = new ArrayList<>();

//        Считываем значения с консоли.
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            dots.add(new MyDot(x, y));
        }

        dots.sort();
        dots.print();

//        Довавляем точки в линии
        for (int i = 0; i < n; i++) {
            addToLine(dots.getDot(i));
            dC.binSearchCallCount++;
        }

//        Добавляем линии на график
        for (int i = 0; i < liness.size(); i++) {
            chart.getData().add(liness.get(i));
        }

        System.out.println("BinSearchCallCount: " + dC.getBinSearchCallCount());


//      Выводим все на экран
        VBox vBox = new VBox();
        vBox.getChildren().add(chart);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();
    }

    static int find(ArrayList<MyDot> a, int lower, int higher, MyDot x, DifficultyCounter dC) {
        dC.binSearchCallCount++;
        int mid = lower + (higher - lower) / 2;
        int delta = higher - lower;

        if (x.y < a.get(mid).y && delta > 1 && x.y < a.get(mid - 1).y) {
            return find(a, mid, higher, x, dC);
        } else if (x.y > a.get(mid).y && delta > 1 && x.y > a.get(mid - 1).y) {
            return find(a, lower, mid, x, dC);
        } else if (x.y > a.get(mid).y) {
            return mid;
        } else if (x.y >= a.get(lower).y) {
            return lower;
        } else if (x.y >= a.get(higher).y) {
                return higher;
        } else {
            return -1;
        }
    }



    public void addToLine(MyDot dot) {
        dC.binSearchCallCount++;
        if (liness.size() == 0) {
            liness.add(new XYChart.Series());
            liness.get(0).getData().add(new XYChart.Data<>(dot.x, dot.y));
            lastDotInLine.add(dot);
            return;
        }
        int i = find(lastDotInLine, 0, lastDotInLine.size() - 1, dot, dC);
        if (i != -1) {
            lastDotInLine.set(i, dot);
            liness.get(i).getData().add(new XYChart.Data<>(dot.x, dot.y));
        } else {
            liness.add(new XYChart.Series());
            liness.get(liness.size() - 1).getData().add(new XYChart.Data<>(dot.x, dot.y));
            lastDotInLine.add(dot);
        }
    }
}

/*
10 1 1 1 7 5 2 2 3 3 4 8 6 9 8 5 11 7 2 10 3
11 1 1  7 8 1 7 5 2 2 3 3 4 8 6 9 8 5 11 7 2 10 3
6 1 4 3 8 4 5 7 4 9 6 5 1
5 2 1 1 2 8 3 10 8 11 7
30 11 22 3 6 1 6 8 9 34 5 67 7 1 2 3 89 65 4 6 1 55 31 57 84 3 5 81 22 41 75 34 67 34 65 23 93 72 7 89 3 6 66 4 87 3 66 3 57 4 25 6 45 34 23 78 24 48 24 87 34
*/