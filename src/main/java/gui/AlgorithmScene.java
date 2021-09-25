package gui;

import algorithms.SortingAlgorithm;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AlgorithmScene<T extends Number> extends Scene {

    protected final SortingAlgorithm<T> algorithm;
    private final ObservableList<XYChart.Series<Object, T>> observableList = FXCollections.observableArrayList();

    protected XYChart<Object, T> chart;

    public AlgorithmScene(XYChart<Object, T> chart, List<T> list, SortingAlgorithm<T> algorithm) {
        super(chart, 800, 600);
        this.algorithm = algorithm;
        this.chart = chart;
        chart.getYAxis().setTickLabelsVisible(false);
        chart.getYAxis().setOpacity(0);
        chart.getXAxis().setOpacity(0);
        chart.setAnimated(false);
        chart.setLegendVisible(false);

        observableList.setAll(convertToSeries(list));
        chart.setData(observableList);
        start();
    }

    /**
     * Converts the index of an item in the list at the proper object type to be used with each Chart.
     * For example, Bar charts need string on the x axis but line charts need Integers.
     *
     * @param item - the index number of the array of the list we are processing
     */
    abstract Object xAxisConverter(Integer item);

    /**
     * Converts the list we are rendering into series that can be used in an XYChart.
     */
    protected XYChart.Series<Object, T> convertToSeries(List<T> list) {
        XYChart.Series<Object, T> series = new XYChart.Series<>();
        for (int i = 0; i < list.size(); i++) {
            series.getData().add(new XYChart.Data<>(xAxisConverter(i), list.get(i)));
        }
        return series;
    }

    private void start() {
        int sortingSpeed = 50;

        Thread fxThread = Thread.currentThread();

        // separate non-FX thread
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (!algorithm.isDone() && fxThread.isAlive()) {
                Platform.runLater(() -> {
                    List<T> numbers = algorithm.executeNextRound();
                    XYChart.Series<Object, T> stringTSeries = convertToSeries(numbers);
                    observableList.setAll(stringTSeries);
                });
            } else {
                executor.shutdown();
            }

        }, sortingSpeed, sortingSpeed, TimeUnit.MILLISECONDS);
    }
}
