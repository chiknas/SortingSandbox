package gui;

import algorithms.SelectionSort;
import gui.algorithmscenes.AlgorithmScene;
import gui.algorithmscenes.BarChartScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SortingSandbox extends Application {

    public static List<Integer> getIntegers(){
        return new ArrayList<>(List.of(1, 9, 4, 2, 5, 7, 1, 13, 3, 6, 8, 16, 3, 2, 10));
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        final AlgorithmScene<Integer> scene = new BarChartScene<>(getIntegers(), new SelectionSort(getIntegers()));

        primaryStage.setTitle("Sorting Sandbox");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
