package entity;

import dto.ProgramDTO;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Programs extends ProgramDTO implements SuperEntity {
    @Id
    private String id;
    private String program;
    private String duration;
    private double fee;

    @OneToMany(mappedBy = "programs",cascade = CascadeType.ALL)
    private List<Registration> registrations=new ArrayList();



    public Programs(String id, String program, String duration, double fee, List<Registration> registrations) {
        this.id = id;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
        this.registrations = registrations;
    }

    public Programs() {
    }

    public Programs(String id, String program, String duration, double fee) {
        this.setId(id);
        this.setProgram(program);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    @Override
    public String toString() {
        return "Programs{" +
                "id='" + id + '\'' +
                ", program='" + program + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", registrations=" + registrations +
                '}';
    }
}
