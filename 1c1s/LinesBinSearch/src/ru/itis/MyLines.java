package ru.itis;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class MyLines extends ArrayList<XYChart.Series> {
//    public MyLines(int i) {
//        super(i);
//    }

    public int getLastPoint(int i) {
        if (this.size() == 0) {return 0;}
        int length = this.get(i).getData().size() - 1;
        XYChart.Data y = (XYChart.Data) this.get(i).getData().get(length);
        return (Integer) y.getYValue();
    }

    public void addToNewLine(MyDot dot) {
        int i = this.size() - 1;
        this.get(i).getData().add(new XYChart.Data<>(dot.x, dot.y));
    }
    public void addPoint(int i, MyDot dot) {
        this.get(i).getData().add(new XYChart.Data<>(dot.x, dot.y));
    }
}
