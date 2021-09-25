package gui.algorithmscenes;

public enum AlgorithmCharts {
    BAR_CHART("Bar Chart"), LINE_CHART("Line Chart"), SCATTER_CHART("Scatter Chart");

    private final String name;

    AlgorithmCharts(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
