package gui.algorithmscenes;

import algorithms.SortingAlgorithm;

import static gui.SortingSandbox.getIntegers;

public class SceneFactory {

    public static AlgorithmScene getAlgorithmScene(AlgorithmCharts scene, SortingAlgorithm algorithm) {
        switch (scene) {
            case BAR_CHART:
                return new BarChartScene(getIntegers(), algorithm);
            case LINE_CHART:
                return new LineChartScene(getIntegers(), algorithm);
            case SCATTER_CHART:
                return new ScatterChartScene(getIntegers(), algorithm);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
