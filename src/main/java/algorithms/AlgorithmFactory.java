package algorithms;

import static gui.SortingSandbox.getIntegers;

public class AlgorithmFactory {

    public static SortingAlgorithm<Integer> getAlgorithm(Algorithm algorithm) {
        switch (algorithm) {
            case BUBBLE_SORT:
                return new BubbleSort(getIntegers());
            case SELECTION_SORT:
                return new SelectionSort(getIntegers());
            default:
                throw new UnsupportedOperationException();
        }
    }
}
