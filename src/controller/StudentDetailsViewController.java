package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import dto.RegistrationDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.Tm.StudentDeatilsTm;

import java.util.List;

public class StudentDetailsViewController {

    public AnchorPane StudentDetailContent;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtGender;
    public TableView<StudentDeatilsTm> tblPrograms;
    public TableColumn colProgramsName;
    public JFXComboBox cmbStudent;
    public Label lblRegNumber;


    StudentBO studentBO= BOFactory.getInstance().getBO(BOType.STUDENT);
    RegistrationBO registrationBO=BOFactory.getInstance().getBO(BOType.REGISTRATION);
    ObservableList<String> studentList= FXCollections.observableArrayList();
    ObservableList<StudentDeatilsTm> obList= FXCollections.observableArrayList();

    public void initialize() {

        colProgramsName.setCellValueFactory(new PropertyValueFactory<>("programs"));

        try {
            loadStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadStudents() throws Exception {
        List<StudentDTO> all=null;
        all =studentBO.getAll();
        for (StudentDTO temp:all) {
            studentList.add(temp.getId());
        }

        cmbStudent.setItems(studentList);
    }

    public void clearOnAction(ActionEvent event) {
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtGender.clear();
        lblRegNumber.setText("-");
        tblPrograms.getItems().clear();
        cmbStudent.getItems().clear();
    }



    public void searchOnAction(ActionEvent actionEvent) {
        try {
            loadStudentData((String)cmbStudent.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            getRegistrationDetails((String)cmbStudent.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getRegistrationDetails(String value) throws Exception {
        List<RegistrationDTO> regData=registrationBO.getAll();

        for (RegistrationDTO temp:regData) {
            if (temp.getStudentDTO().getId().equals(cmbStudent.getValue())){
                lblRegNumber.setText(String.valueOf(temp.getRegNo()));
                obList.add(new StudentDeatilsTm(temp.getProgramDTO().getProgram()));
            }
        }
        tblPrograms.setItems(obList);
    }

    private void loadStudentData(String value) throws Exception {
        List<StudentDTO> all =studentBO.getAll();
        for (StudentDTO temp:all) {
            if (temp.getId().equals(cmbStudent.getValue())){
                txtName.setText(temp.getName());
                txtAddress.setText(temp.getAddress());
                txtContact.setText(String.valueOf(temp.getContact()));
                txtGender.setText(temp.getGender());
            }

        }
    }
}
