package gui;

import algorithms.SortingAlgorithm;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;

import java.util.List;

public class ScatterChartScene<T extends Number> extends AlgorithmScene {

    public ScatterChartScene(List<T> list, SortingAlgorithm algorithm) {
        super(new ScatterChart(new NumberAxis(), new NumberAxis()), list, algorithm);
    }

    @Override
    Object xAxisConverter(Integer item) {
        return item;
    }
}
