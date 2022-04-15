package iitu.kz.diploma.Models;
import javax.persistence.*;

@Entity
@Table(name = "Groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "group", nullable = false, columnDefinition = "TEXT", unique = true)
    private String group;

    @Column(name = "number_of_students", nullable = false, columnDefinition = "NUMERIC")
    private long number_of_students;

    @Column(name = "speciality", nullable = false, columnDefinition = "TEXT")
    private String speciality;

    @Column(name = "semester", nullable = false, columnDefinition = "NUMERIC")
    private long semester;

    @Column(name = "course", nullable = false, columnDefinition = "NUMERIC")
    private long course;


    public Groups(){   }

    public Groups(String group, long number_of_students, String speciality, long semester, long course){
        this.group = group;
        this.number_of_students = number_of_students;
        this.speciality = speciality;
        this.semester = semester;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public long getNumber_of_students() {
        return number_of_students;
    }

    public void setNumber_of_students(long number_of_students) {
        this.number_of_students = number_of_students;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public long getSemester() {
        return semester;
    }

    public void setSemester(long semester) {
        this.semester = semester;
    }

    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }
}
