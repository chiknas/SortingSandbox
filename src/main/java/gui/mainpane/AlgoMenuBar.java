package gui.mainpane;

import algorithms.Algorithm;
import algorithms.AlgorithmFactory;
import algorithms.SortingAlgorithm;
import gui.algorithmscenes.AlgorithmCharts;
import gui.algorithmscenes.SceneFactory;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlgoMenuBar extends VBox {

    public AlgoMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu algorithmMenu = getAlgorithmsMenu("Algorithms");
        menuBar.getMenus().add(algorithmMenu);

        getChildren().add(menuBar);
    }

    private void switchScene(SortingAlgorithm algorithm, AlgorithmCharts scene) {
        Stage stage = (Stage) AlgoMenuBar.super.getScene().getWindow();
        stage.setScene(SceneFactory.getAlgorithmScene(scene, algorithm));
    }

    private Menu getAlgorithmsMenu(String name) {
        Menu menu = new Menu(name);
        List<Menu> subMenus = Arrays.stream(Algorithm.values()).map(algo -> {
            // for each algo generate subMenu of all the available scenes for it.
            List<MenuItem> algoMenuItems =
                    Arrays.stream(AlgorithmCharts.values()).map(chart -> radioMenuItem(algo, chart)).collect(Collectors.toList());
            Menu algoMenu = new Menu(algo.getName());
            algoMenu.getItems().addAll(algoMenuItems);
            return algoMenu;
        }).collect(Collectors.toList());
        menu.getItems().addAll(subMenus);
        return menu;
    }

    private MenuItem radioMenuItem(Algorithm algorithm, AlgorithmCharts scene) {
        MenuItem menuItem = new RadioMenuItem(scene.getName());
        menuItem.setOnAction(event -> switchScene(AlgorithmFactory.getAlgorithm(algorithm), scene));
        return menuItem;
    }

}
