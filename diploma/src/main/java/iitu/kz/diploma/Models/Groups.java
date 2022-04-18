package iitu.kz.diploma.Models;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "group_name", nullable = false, columnDefinition = "TEXT", unique = true)
    private String group_name;

    @Column(name = "number_of_students", nullable = false, columnDefinition = "NUMERIC")
    private long number_of_students;

    @Column(name = "speciality", nullable = false, columnDefinition = "TEXT")
    private String speciality;

    @Column(name = "course", nullable = false, columnDefinition = "NUMERIC")
    private long course;

    @Column(name = "semester", nullable = false, columnDefinition = "NUMERIC")
    private long semester;

//    public Groups(){   }
//
//    public Groups(String group_name, long number_of_students, String speciality, long course, long semester){
//        this.group_name = group_name;
//        this.number_of_students = number_of_students;
//        this.speciality = speciality;
//        this.course = course;
//        this.semester = semester;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getGroup_name() {
//        return group_name;
//    }
//
//    public void setGroup_name(String group) {
//        this.group_name = group;
//    }
//
//    public long getNumber_of_students() {
//        return number_of_students;
//    }
//
//    public void setNumber_of_students(long number_of_students) {
//        this.number_of_students = number_of_students;
//    }
//
//    public String getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(String speciality) {
//        this.speciality = speciality;
//    }
//
//    public long getCourse() {
//        return course;
//    }
//
//    public void setCourse(long course) {
//        this.course = course;
//    }
//
//    public long getSemester() {
//        return semester;
//    }
//
//    public void setSemester(long semester) {
//        this.semester = semester;
//    }
}
