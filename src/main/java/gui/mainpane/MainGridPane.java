package gui.mainpane;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class MainGridPane extends GridPane {
    public MainGridPane(Node mainView) {
        add(new AlgoMenuBar(), 0, 0);
        add(mainView, 0, 1);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        getColumnConstraints().add(column1);

        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(100);
        getRowConstraints().addAll(new RowConstraints(), row2);
    }

}
