package gui;

import algorithms.SortingAlgorithm;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;

public class BarChartScene<T extends Number> extends AlgorithmScene<T> {

    private static final String HIGHLIGHT_COLOR = "#CE8F9C";
    private static final String BAR_COLOR = "#FFB99C";

    public BarChartScene(List<T> list, SortingAlgorithm algorithm) {
        super(new BarChart(new CategoryAxis(), new NumberAxis()), list, algorithm);

        chart.getData().addListener((ListChangeListener<XYChart.Series<Object, T>>) c ->
                onChanged((ObservableList<XYChart.Series<Object, T>>) c.getList()));

        onChanged(chart.getData());
    }

    @Override
    Object xAxisConverter(Integer item) {
        return String.valueOf(item + 1);
    }

    private void onChanged(ObservableList<XYChart.Series<Object, T>> list) {
        // the sorting scenes should always work with a single
        list.stream().findFirst().orElseThrow()
                .getData().forEach(this::setBarColor);
    }

    private void setBarColor(XYChart.Data<Object, T> bar) {
        String barColor = algorithm.highlights().contains(Integer.parseInt((String) bar.getXValue()) + 1) ?
                BAR_COLOR : HIGHLIGHT_COLOR;

        bar.getNode().setStyle(String.format("-fx-bar-fill: %s;", barColor));
    }


}
