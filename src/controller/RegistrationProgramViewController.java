package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.ProgramsBOImpl;
import dto.ProgramDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegistrationProgramViewController {
    public AnchorPane programContent;
    public TextField txtProgramName;
    public TextField txtProgramDuration;
    public TextField txtProgramFee;
    public TextField txtProgramId;

    ProgramsBOImpl programsBO=BOFactory.getInstance().getBO(BOType.PROGRAMS);

    public void registerProgramOnAction(ActionEvent event) {
        String id =txtProgramId.getText();
        String name=txtProgramName.getText();
        String duration=txtProgramDuration.getText();
        double fee=Double.valueOf(txtProgramFee.getText());

        try {
            if (programsBO. add(new ProgramDTO(
                id,
                name,
                duration,
                fee
            ))){
                clearContent();
                new Alert(Alert.AlertType.INFORMATION,"This Program was add..").show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    private void clearContent() {
        txtProgramDuration.clear();
        txtProgramFee.clear();
        txtProgramId.clear();
        txtProgramName.clear();
    }
}
