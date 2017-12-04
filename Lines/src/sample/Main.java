package sample;

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

    public ArrayList<MyDot> dots = new ArrayList<MyDot>();
//    public ArrayList<int> dotsX = new ArrayList<int>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scanner scanner = new Scanner(System.in);
        LineChart chart = new LineChart(new NumberAxis(), new NumberAxis());
        int n = scanner.nextInt();
        MyDot dot = new MyDot(0,0);
//        MyDot[] dots = new MyDot[n];
//        int[] x = new  int[n];
//        int[] y = new int[n];
        for (int i= 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            dots.add(new MyDot(x, y));
        }
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<i; j++) {
                if (dots.get(j).x > dots.get(j+1).x) {
                    MyDot c = dots.get(j+1);
                    dots.set(j+1, dots.get(j));
                    dots.set(j, c);
                }
            }
        }
//        Сортировка по у
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<i; j++) {
                if (dots.get(j).y > dots.get(j+1).y && dots.get(j+1).x == dots.get(j).x) {
                    MyDot c = dots.get(j+1);
                    dots.set(j+1, dots.get(j));
                    dots.set(j, c);
                }
            }

        }
        for (int i=0; i<n; i++) {
            System.out.println(dots.get(i).x + " " + dots.get(i).y);
        }
       while (dots.size() > 0) {
            int maxY = dots.get(0).y;
            int maxX = dots.get(0).x;
            int j;
            XYChart.Series tempLine = new XYChart.Series();
//           FXCollections fxCollections = new FXCollections();
//           5 1 4 3 8 4 5 7 4 9 6
//          10 1 1 1 7 5 2 4 3 3 4 8 6 9 8 5 0 7 2 10 1
           tempLine.getData().add(new XYChart.Data<>(dots.get(0).x, dots.get(0).y));
           dots.remove(0);

           for (int i=0; i < dots.size() ; i++){
                if (dots.get(i).y >= maxY && dots.get(i).x > maxX){
                    maxY = dots.get(i).y;
                    maxX = dots.get(i).x;
                    j = i;
                    tempLine.getData().add(new XYChart.Data<>(dots.get(i).x, dots.get(i).y));
                    dots.remove(i);
//                    i++;
                }
            }
           chart.getData().add(tempLine);

       }


        VBox vBox = new VBox();
//        chart.getData().add(new XYChart.Series<>("Temp2", FXCollections.observableArrayList(new XYChart.Data<Object, Object>(5, 2), new XYChart.Data<Object, Object>(3, 3), new XYChart.Data<Object, Object>(4, 5))));
//        chart.getData().add(new XYChart.Series<>("Temp1", FXCollections.observableArrayList(new XYChart.Data<Object, Object>(1, 1), new XYChart.Data<Object, Object>(2, 2), new XYChart.Data<Object, Object>(3, 4))));
        vBox.getChildren().add(chart);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();
//        ((XYChart.Series) chart.getData().get(0)).getData().addAll(new XYChart.Data<>(5, 5));


//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
    }

    public void createNewLine() {

    }


    public static void main(String[] args) {
        launch(args);
    }
}
