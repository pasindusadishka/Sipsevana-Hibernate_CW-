package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.ProgramsBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class ProgramDetailsViewController {
    public AnchorPane programDetailContent;
    public TextField txtProgramName;
    public TextField txtProgramDuration;
    public TextField txtProgramFee;
    public JFXComboBox cmbProgramId;

    ProgramsBO programsBO= BOFactory.getInstance().getBO(BOType.PROGRAMS);
    ObservableList<String> programsId= FXCollections.observableArrayList();

    public void initialize() {
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
            programsId.add(temp.getId());
        }

        cmbProgramId.setItems(programsId);
    }


    public void clearOnAction(ActionEvent event) {
        cmbProgramId.getItems().clear();
        txtProgramDuration.clear();
        txtProgramFee.clear();
        txtProgramName.clear();
    }

    public void searchOnAction(ActionEvent actionEvent) throws Exception {
        List<ProgramDTO> all=null;
        all =programsBO.getAll();
        for (ProgramDTO temp:all) {
           if (temp.getId().equals(cmbProgramId.getValue())){
               txtProgramName.setText(temp.getProgram());
               txtProgramDuration.setText(temp.getDuration());
               txtProgramFee.setText(String.valueOf(temp.getFee()));
           }
        }
    }
}
