package dto;

public class ProgramDTO {
    private String id;
    private String program;
    private String duration;
    private double fee;

    public ProgramDTO() {
    }

    public ProgramDTO(String id, String program, String duration, double fee) {
        this.id = id;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
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

    @Override
    public String toString() {
        return "ProgramDTO{" +
                "id='" + id + '\'' +
                ", program='" + program + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
