package algorithms;

public enum Algorithm {
    BUBBLE_SORT("Bubble Sort"), SELECTION_SORT("Selection Sort");

    private final String name;

    Algorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
