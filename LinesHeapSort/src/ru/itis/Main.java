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

//    public ArrayList<MyDot> dots = new ArrayList<MyDot>();
    public MyArray dots;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scanner scanner = new Scanner(System.in);
        LineChart chart = new LineChart(new NumberAxis(), new NumberAxis());
        int n = scanner.nextInt();
        dots = new MyArray(n);

//        Считываем значения с консоли.
        for (int i= 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            dots.add(new MyDot(x, y));
        }

        dots.sort();
        dots.print();

/*
//        Добавляем точки в линии
        while (dots.size() >= dots.getRemovedCount()) {
            int maxY = dots.getY(0);
            int maxX = dots.getX(0);
            int j;
            XYChart.Series tempLine = new XYChart.Series();
            // 6 1 4 3 8 4 5 7 4 9 6 5 1
            // 10 1 1 1 7 5 2 2 3 3 4 8 6 9 8 5 11 7 2 10 3
            tempLine.getData().add(new XYChart.Data<>(dots.getX(0), dots.getY(0)));
            dots.remove(0);

            for (int i=0; i < dots.size() ; i++){
                if (dots.getY(i) >= maxY && dots.getX(i) >= maxX && !dots.isRemoved(i)){
                    maxY = dots.getY(i);
                    maxX = dots.getX(i);
                    j = i;
                    tempLine.getData().add(new XYChart.Data<>(dots.getX(i), dots.getY(i)));
                    dots.remove(i);
                    i--;
                }
            }
            chart.getData().add(tempLine);

        }

//      Выводим все на экран
        VBox vBox = new VBox();
        vBox.getChildren().add(chart);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();*/
    }

    public static void main(String[] args) {
        launch(args);
    }

}

