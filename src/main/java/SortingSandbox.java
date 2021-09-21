import algorithms.BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class SortingSandbox {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(1, -160, 4, 2, 5, -130, 1));
//        List<Double> doubles = new ArrayList<>(List.of(1.15d, -160d, 4.2d, 2d, 5d, -130d, 1.19d));

        System.out.println("Starting sorting of list: " + integers);


        BubbleSort bubbleSort = new BubbleSort(integers);
        while (!bubbleSort.isDone()) {
            System.out.println(bubbleSort.executeNextRound());
        }


        System.out.println("Done!");
    }
}
