package entity;

import javax.persistence.*;

@Entity
public class Registration implements SuperEntity{
    @Id
    private int regNo;
    private String date;
    private double fee;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_Id", referencedColumnName = "id" , nullable = false)
    private Student student;


    @ManyToOne
    @JoinColumn(name = "program_Id" , referencedColumnName = "id" , nullable = false)
    private Programs programs;

    public Registration() {
    }

    public Registration(int regNo, String date, double fee) {
        this.setRegNo(regNo);
        this.setDate(date);
        this.setFee(fee);
    }

    public Registration(int regNo, String date, double fee, Student student, Programs programs) {
        this.setRegNo(regNo);
        this.setDate(date);
        this.setFee(fee);
        this.setStudent(student);
        this.setPrograms(programs);
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Programs getPrograms() {
        return programs;
    }

    public void setPrograms(Programs programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNo=" + regNo +
                ", date='" + date + '\'' +
                ", fee='" + fee + '\'' +
                ", student=" + student +
                ", programs=" + programs +
                '}';
    }
}
