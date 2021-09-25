module gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens gui to javafx.fxml;
    exports gui;
    exports gui.algorithmscenes;
    opens gui.algorithmscenes to javafx.fxml;
    exports gui.mainpane;
    opens gui.mainpane to javafx.fxml;
}