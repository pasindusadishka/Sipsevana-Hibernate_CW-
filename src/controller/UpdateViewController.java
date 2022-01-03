package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class UpdateViewController {

    public AnchorPane updateDashBord;
    public AnchorPane changeContent;


    public void backOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/DashBordForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage window=(Stage) updateDashBord.getScene().getWindow();
        window.setScene(scene);
    }

    public void studentToChangeOnAction(ActionEvent event) throws IOException {
        this.changeContent.getChildren().clear();
        this.changeContent.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/UpdateStudentView.fxml")));
    }

    public void programeToOnAction(ActionEvent event) throws IOException {
        this.changeContent.getChildren().clear();
        this.changeContent.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/UpdateProgramsView.fxml")));
    }
}
