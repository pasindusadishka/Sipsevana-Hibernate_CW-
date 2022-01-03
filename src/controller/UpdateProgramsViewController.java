package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.ProgramsBO;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class UpdateProgramsViewController {
    public ComboBox cmbProgramsId;
    public TextField txtProgramName;
    public TextField txtProgramDuration;
    public TextField txtProgramFee;
    public AnchorPane programUpdateView;

    ProgramsBO programsBO = BOFactory.getInstance().getBO(BOType.PROGRAMS);
    ObservableList<String> programIdList= FXCollections.observableArrayList();

    public void initialize(){
        try {
            loadProgramsId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadProgramsId() throws Exception {
        List<ProgramDTO> all=null;
        all =programsBO.getAll();
        for (ProgramDTO temp:all) {
            programIdList.add(temp.getId());
        }

        cmbProgramsId.setItems(programIdList);
    }

    public void updateCourseOnAction(ActionEvent event) {
        try {

            if (programsBO.update(new ProgramDTO(
                    (String) cmbProgramsId.getValue(),
                    txtProgramName.getText(),
                    txtProgramDuration.getText(),
                    Double.valueOf(txtProgramFee.getText())
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                clearContent();
            }else {
                new Alert(Alert.AlertType.ERROR,"Update fail..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearContent() {
        txtProgramName.clear();
        txtProgramDuration.clear();
        txtProgramFee.clear();
        cmbProgramsId.getItems().clear();
    }

    public void searchProgramOnAction(ActionEvent actionEvent) {
        try {
            List<ProgramDTO> programDetails=programsBO.getAll();
            for (ProgramDTO temp:programDetails) {
                if (temp.getId().equals(cmbProgramsId.getValue()))
                txtProgramName.setText(temp.getProgram());
                txtProgramDuration.setText(temp.getDuration());
                txtProgramFee.setText(String.valueOf(temp.getFee()));
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Exception Error updateProgram").show();
            e.printStackTrace();
        }
    }
}
