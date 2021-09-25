package gui.algorithmscenes;

import algorithms.SortingAlgorithm;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

import java.util.List;

public class LineChartScene<T extends Number> extends AlgorithmScene {

    public LineChartScene(List<T> list, SortingAlgorithm algorithm) {
        super(new LineChart(new NumberAxis(), new NumberAxis()), list, algorithm);
    }

    @Override
    Object xAxisConverter(Integer item) {
        return item + 1;
    }
}
