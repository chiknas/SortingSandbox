package gui;

import algorithms.SortingAlgorithm;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

import java.util.List;

public class BarChartScene<T extends Number> extends AlgorithmScene<T> {

    public BarChartScene(List<T> list, SortingAlgorithm algorithm) {
        super(new BarChart(new CategoryAxis(), new NumberAxis()), list, algorithm);
    }

    @Override
    Object xAxisConverter(Integer item) {
        return String.valueOf(item);
    }
}
