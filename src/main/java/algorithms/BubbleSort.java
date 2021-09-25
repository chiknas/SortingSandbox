package algorithms;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

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
public class BubbleSort<T extends Number> implements SortingAlgorithm<T> {

    // the state of the algorithm per round.
    private final List<T> state;

    // in Bubblesort every item after the last swap in each round is basically sorted and we dont need to check it
    // again.
    // we will update this index every round to help us do that.
    private int sortedIndex;

    // the current index that the algorithm is looking at. it will reset when it reaches the sortedIndex.
    private int index = 0;

    // keeps track of the position where the last swap happened for each run through of the list.
    // this will update the sortedIndex and reset for the next loop of the list.
    private int roundMaxSwapIndex = 0;

    public BubbleSort(List<T> list) {
        this.state = list;
        this.sortedIndex = list.size() - 1;
    }

    @Override
    public List<T> getCurrentState() {
        return state;
    }

    @Override
    public void round() {

        // check the pair of the current index and the next item (index + 1) and if they are not in order switch them.
        BigDecimal currentNumber = BigDecimal.valueOf(state.get(index).doubleValue());
        BigDecimal nextNumber = BigDecimal.valueOf(state.get(index + 1).doubleValue());
        if (currentNumber.compareTo(nextNumber) > 0) {
            Collections.swap(state, index, index + 1);
            roundMaxSwapIndex = index;
        }

        // checking if we are at the end of the list to reset our indexes
        if (index == sortedIndex - 1) {
            sortedIndex = roundMaxSwapIndex;
            index = 0;
            roundMaxSwapIndex = 0;
        } else {
            index++;
        }
    }

    @Override
    public List<Highlight> highlights() {
        return List.of(Highlight.of(index, "#CE8F9C"),
                Highlight.of(index + 1, "#CE8F9C"));
    }

    @Override
    public boolean isDone() {
        return sortedIndex <= 1;
    }
}
