package algorithms;

import java.util.List;

public interface SortingAlgorithm<T extends Number> {


    /**
     * Returns the current state of the algorithm for the specified list.
     */
    List<T> getCurrentState();

    /**
     * The steps that each round the algorithm goes through.
     */
    void round();

    /**
     * If the algorithm is done sorting or has next steps.
     */
    boolean isDone();

    /**
     * The items the algorithm is looking at/is interested in right now.
     */
    List<Highlight> highlights();

    /**
     * Runs the next loop of the algorithm and returns the new state.
     * If the algorithm is done sorting the final state is returned instead without running anything.
     */
    default List<T> executeNextRound() {
        if (!isDone()) {
            round();
        }
        return getCurrentState();
    }

}
