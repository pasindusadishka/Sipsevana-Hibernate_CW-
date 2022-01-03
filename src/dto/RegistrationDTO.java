package dto;

public class RegistrationDTO {
    private int regNo;
    private String date;
    private double fee;
    private StudentDTO studentDTO;
    private ProgramDTO programDTO;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int regNo, String date, double fee, StudentDTO studentDTO, ProgramDTO programDTO) {
        this.setRegNo(regNo);
        this.setDate(date);
        this.setFee(fee);
        this.setStudentDTO(studentDTO);
        this.setProgramDTO(programDTO);
    }


    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public ProgramDTO getProgramDTO() {
        return programDTO;
    }

    public void setProgramDTO(ProgramDTO programDTO) {
        this.programDTO = programDTO;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "regNo=" + regNo +
                ", date='" + date + '\'' +
                ", fee=" + fee +
                ", studentDTO=" + studentDTO +
                ", programDTO=" + programDTO +
                '}';
    }
}
