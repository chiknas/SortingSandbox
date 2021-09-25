package algorithms;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * In computer science, selection sort is an in-place comparison sorting algorithm. It has an O(n2) time complexity,
 * which makes it inefficient on large lists, and generally performs worse than the similar insertion sort. Selection
 * sort is noted for its simplicity and has performance advantages over more complicated algorithms in certain
 * situations, particularly where auxiliary memory is limited.
 * <p>
 * The algorithm divides the input list into two parts: a sorted sublist of items which is built up from left to
 * right at the front (left) of the list and a sublist of the remaining unsorted items that occupy the rest of the
 * list. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm
 * proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist,
 * exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist
 * boundaries one element to the right.
 * <p>
 * The time efficiency of selection sort is quadratic, so there are a number of sorting techniques which have better
 * time complexity than selection sort. One thing which distinguishes selection sort from other sorting algorithms is
 * that it makes the minimum possible number of swaps, n − 1 in the worst case.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection Sort Wikipedia</a>
 */
public class SelectionSort<T extends Number> implements SortingAlgorithm<T> {

    // the state of the algorithm per round.
    private final List<T> state;

    // the item we are looking at each step
    private int index = 0;

    // up to which item we have sorted this list.
    private int sortedIndex = 0;

    // the latest min index for the sublist we are checking
    private int currentMinIndex = 0;

    public SelectionSort(List<T> state) {
        this.state = state;
    }

    @Override
    public List<T> getCurrentState() {
        return state;
    }

    @Override
    public void round() {
        BigDecimal currentNumber = BigDecimal.valueOf(state.get(index).doubleValue());
        BigDecimal currentMinNumber = BigDecimal.valueOf(state.get(currentMinIndex).doubleValue());
        if (currentNumber.compareTo(currentMinNumber) < 0) {
            currentMinIndex = index;
        }

        if (index < state.size() - 1) {
            index++;
        } else {
            Collections.swap(state, currentMinIndex, sortedIndex);
            index = sortedIndex + 1;
            currentMinIndex = index;
            sortedIndex++;
        }
    }

    @Override
    public boolean isDone() {
        return sortedIndex == state.size() - 1;
    }

    @Override
    public List<Highlight> highlights() {
        return List.of(Highlight.of(index, "#CE8F9C"),
                Highlight.of(sortedIndex, "YELLOW"),
                Highlight.of(currentMinIndex, "RED"));
    }
}
