package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.ProgramsBO;
import bo.custom.StudentBO;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class UpdateStudentViewController {
    public AnchorPane UpdateStudentDashBord;
    public ComboBox cmbSelectStudentId;
    public TextField txtStudentName;
    public TextField txtContact;
    public TextField txtGender;
    public ComboBox cmbSelectCourse;
    public TextField txtAddress;


    ProgramsBO programsBO = BOFactory.getInstance().getBO(BOType.PROGRAMS);
    ObservableList<String> programList= FXCollections.observableArrayList();
    StudentBO studentBO= BOFactory.getInstance().getBO(BOType.STUDENT);
    ObservableList<String> studentList= FXCollections.observableArrayList();

    public void initialize(){
        try {
            loadStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            loadPrograms();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPrograms() throws Exception {
        List<ProgramDTO> all=null;
        all =programsBO.getAll();
        for (ProgramDTO temp:all) {
            programList.add(temp.getProgram());
        }

        cmbSelectCourse.setItems(programList);
    }

    private void loadStudents() throws Exception {
        List<StudentDTO> all=null;
        all =studentBO.getAll();
        for (StudentDTO temp:all) {
            studentList.add(temp.getId());
        }

        cmbSelectStudentId.setItems(studentList);
    }

    public void updateOnAction(ActionEvent event) {

        try {

            if (studentBO.update(new StudentDTO(
                    (String) cmbSelectStudentId.getValue(),
                    txtStudentName.getText(),
                    txtAddress.getText(),
                    Integer.valueOf(txtContact.getText()),
                    txtGender.getText()
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Update fail..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchOnAction(ActionEvent event) throws Exception {
        List<StudentDTO> all=null;
        all =studentBO.getAll();
        for (StudentDTO temp:all) {
            if (temp.getId().equals(cmbSelectStudentId.getValue())){
                txtStudentName.setText(temp.getName());
                txtAddress.setText(temp.getAddress());
                txtContact.setText(String.valueOf(temp.getContact()));
                txtGender.setText(temp.getGender());
            }

        }
    }
}
