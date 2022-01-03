package view.Tm;

public class StudentDeatilsTm {
    private String programs;

    public StudentDeatilsTm(String programs) {
        this.setPrograms(programs);
    }

    public StudentDeatilsTm() {
    }

    public String getPrograms() {
        return programs;
    }

    public void setPrograms(String programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "StudentDeatilsTm{" +
                "programs='" + programs + '\'' +
                '}';
    }
}
