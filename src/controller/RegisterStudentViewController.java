package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.AddRegistrationBO;
import bo.custom.ProgramsBO;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import bo.custom.impl.RegistrationBOImpl;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.RegistrationDAOImpl;
import dto.ProgramDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterStudentViewController {
    public AnchorPane studentContextBord;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public RadioButton genderMale;
    public ToggleGroup Gender;
    public RadioButton genderFemale;
    public RadioButton genderOther;
    public JFXComboBox cmbCourses;
    public Label lblRegNumber;
    public Label lblDate;
    public JFXComboBox cmbProgramId;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public Label lblStudentId;

    ProgramsBO programsBO = BOFactory.getInstance().getBO(BOType.PROGRAMS);
    ObservableList<String> programList= FXCollections.observableArrayList();
    ObservableList<String> programIdList= FXCollections.observableArrayList();
    AddRegistrationBO addRegistrationBO=BOFactory.getInstance().getBO(BOType.ADDREGISTRATION);
    RegistrationBO registrationBO=BOFactory.getInstance().getBO(BOType.REGISTRATION);
    StudentBO studentBO=BOFactory.getInstance().getBO(BOType.STUDENT);


    public void initialize(){
        try {
            loadPrograms();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Syntax Error").show();
            e.printStackTrace();
        }

        try {
            loadProgramsId();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Syntax Error load Programs Id").show();
            e.printStackTrace();
        }

        try {
            generateREINNo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            loadStudentId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDate();
    }

    private void loadStudentId() throws Exception {
        List<StudentDTO> regData=studentBO.getAll();
        String studentId=null;
        for (StudentDTO tmp:regData) {
            studentId=tmp.getId();
        }
        lblStudentId.setText(setNumber(studentId));
    }

    private String setNumber(String studentId) {
        if (studentId!=null){
            int tempId=Integer.parseInt(studentId.split("-")[1]);
            tempId=tempId+1;
            if (tempId<=9){
                return "S-00"+tempId;
            }else if (tempId<=99){
                return "S-0"+tempId;
            }else {
                return "S-"+tempId;
            }
        }else {
            return "S-001";
        }
    }

    private void loadProgramsId() throws Exception {
        List<ProgramDTO> all=null;
        all =programsBO.getAll();
        for (ProgramDTO temp:all) {
            programIdList.add(temp.getId());
        }

        cmbProgramId.setItems(programIdList);
    }

    private void setDate() {
        Date date=new Date();
        SimpleDateFormat f=new SimpleDateFormat("YYYY-MM-dd ");
        lblDate.setText(f.format(date));
    }

    private void generateREINNo() throws Exception {
        List<RegistrationDTO> regData=registrationBO.getAll();
        int regNo=0;
        for (RegistrationDTO tmp:regData) {
            regNo=tmp.getRegNo();
        }
        lblRegNumber.setText(String.valueOf(regNo+1));
    }

    private void loadPrograms() throws Exception {
       List<ProgramDTO> all=null;
       all =programsBO.getAll();
        for (ProgramDTO temp:all) {
            programList.add(temp.getProgram());
        }

        cmbCourses.setItems(programList);
    }

    public void registerStudentOnAction(ActionEvent event) throws Exception {
       try {
           int regNo=Integer.valueOf(lblRegNumber.getText());
           String date=String.valueOf(LocalDate.now());

           String pId= String.valueOf(cmbProgramId.getValue());
           System.out.println(pId);
           String pName= String.valueOf(cmbCourses.getValue());
           String duration=txtDuration.getText();
           double fee=Double.valueOf(txtFee.getText());



           List<ProgramDTO> selectProgramDTOList=new ArrayList<>();
           selectProgramDTOList.add(new ProgramDTO(
                   pId,pName,duration,fee
           ));
           selectStudentDTO();
           List<RegistrationDTO> selectRegDTOList=new ArrayList<>();
           for (ProgramDTO temp:selectProgramDTOList) {
               selectRegDTOList.add(new RegistrationDTO(
                       regNo,
                       date,
                       fee,
                       selectStudentDTO(),
                       temp
               ));
           }
           /*-------------------------------------------------*/

           boolean rest=addRegistrationBO.addRegistration(
                   selectStudentDTO(),
                   selectRegDTOList
           );
           if (rest){
               clearContent();
               new Alert(Alert.AlertType.CONFIRMATION,"Student added..!").show();
               System.out.println("Save");
               generateREINNo();
           }else {
               System.out.println("no");
           }

       }catch (Exception e){
           System.out.println("Exception Error registrationView controller");
       }

    }

    private StudentDTO selectStudentDTO() {
        String sId=lblStudentId.getText();
        String sName=txtName.getText();
        String sAddress=txtAddress.getText();
        int contact=Integer.valueOf(txtContact.getText());
        System.out.println(contact);
        String sGender="Male";

        if (genderFemale.isSelected()){
            sGender="Female";
        }else if(genderOther.isSelected()){
            sGender="other";
        }

        StudentDTO selectStudentDTO=new StudentDTO();
        selectStudentDTO.setId(sId);
        selectStudentDTO.setName(sName);
        selectStudentDTO.setAddress(sAddress);
        selectStudentDTO.setContact(contact);
        selectStudentDTO.setGender(sGender);

        return selectStudentDTO;
    }

    private void clearContent() {
        cmbProgramId.getItems().clear();
        cmbCourses.getItems().clear();
        txtName.clear();
        txtContact.clear();
        txtAddress.clear();
        txtDuration.clear();
        txtFee.clear();
    }
}
