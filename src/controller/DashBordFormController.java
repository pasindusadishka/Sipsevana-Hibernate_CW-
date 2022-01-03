package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBordFormController {

    public AnchorPane dashboardFormDescription;

    public void registerClickOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/RegisterView.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage window=(Stage) dashboardFormDescription.getScene().getWindow();
        window.setScene(scene);
    }

    public void showDetailsClickOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/DetailsView.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage window=(Stage) dashboardFormDescription.getScene().getWindow();
        window.setScene(scene);
    }

    public void updateClickOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/UpdateView.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage window=(Stage) dashboardFormDescription.getScene().getWindow();
        window.setScene(scene);
    }
}
