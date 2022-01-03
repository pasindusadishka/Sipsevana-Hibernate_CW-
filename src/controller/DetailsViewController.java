package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DetailsViewController {
    public AnchorPane mainDetailsContent;
    public AnchorPane studentDetailContent;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtGender;
    public TableView tblPrograms;
    public TableColumn colProgramsName;
    public AnchorPane changeDetailContent;


    public void selectProgramOnAction(ActionEvent event) throws IOException {
        this.changeDetailContent.getChildren().clear();
        this.changeDetailContent.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ProgramDetailsView.fxml")));
    }

    public void selectStudentOnAction(ActionEvent event) throws IOException {
        this.changeDetailContent.getChildren().clear();
        this.changeDetailContent.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/StudentDetailsView.fxml")));
    }



    public void backOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/DashBordForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage window=(Stage) mainDetailsContent.getScene().getWindow();
        window.setScene(scene);
    }
}
