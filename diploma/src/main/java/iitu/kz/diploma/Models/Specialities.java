package iitu.kz.diploma.Models;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Specialities")
public class Specialities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "speciality", nullable = false, columnDefinition = "TEXT", unique = true)
    private String speciality;

    @Column(name = "department", nullable = false, columnDefinition = "TEXT")
    private String department;

//    public Specialities(){}

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
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
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }

//    public Specialities(String speciality, String department){
//        this.speciality = speciality;
//        this.department = department;
//    }

}
