package algorithms;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Number> implements SortingAlgorithm<T> {

    // the state of the algorithm per round.
    private final List<T> state;

    // in Bubblesort every item after the last swap in each round is basically sorted and we dont need to check it
    // again.
    // we will update this index every round to help us do that.
    private int sortedIndex;

    public BubbleSort(List<T> list) {
        this.state = list;
        this.sortedIndex = list.size() - 1;
    }

    @Override
    public List<T> getCurrentState() {
        return state;
    }

    /**
     * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps
     * through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through
     * the list is repeated until the list is sorted.
     * The algorithm, which is a comparison sort, is named for the way smaller or larger elements "bubble" to the top
     * of the list.
     * <p>
     * This simple algorithm performs poorly in real world use and is used primarily as an educational tool. More
     * efficient algorithms such as quicksort, time sort,
     * or merge sort are used by the sorting libraries built into popular programming languages such as Python and Java.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort Wikipedia</a>
     */
    @Override
    public void round() {

        int currentIndex = sortedIndex;

        for (int i = 0; i < sortedIndex; i++) {
            BigDecimal currentNumber = BigDecimal.valueOf(state.get(i).doubleValue());
            BigDecimal nextNumber = BigDecimal.valueOf(state.get(i + 1).doubleValue());
            if (currentNumber.compareTo(nextNumber) > 0) {
                Collections.swap(state, i, i + 1);
                currentIndex = i;
            }
        }

        sortedIndex = currentIndex;
    }

    @Override
    public boolean isDone() {
        return sortedIndex <= 1;
    }
}
