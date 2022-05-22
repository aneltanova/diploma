package com.example.project.Modules;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Faculties")
public class Faculties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "faculty", nullable = false, columnDefinition = "TEXT", unique = true)
    private String faculty;

    @Column(name = "dean", nullable = false, columnDefinition = "TEXT") // full_name
    private String dean;

//    public Faculties(){}

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFaculty() {
//        return faculty;
//    }
//
//    public void setFaculty(String faculty) {
//        this.faculty = faculty;
//    }
//
//    public Faculties(String faculty){
//        this.faculty = faculty;
//    }
}