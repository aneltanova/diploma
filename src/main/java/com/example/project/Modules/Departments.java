package com.example.project.Modules;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "department", nullable = false, columnDefinition = "TEXT", unique = true)
    private String department;

    @Column(name = "faculty", nullable = false, columnDefinition = "TEXT")
    private String faculty;

    @Column(name = "head_of_dep", nullable = false, columnDefinition = "TEXT") // full_name
    private String head_of_dep;

//    public Departments(){}
//
//    public Departments(String department, String faculty, String head_of_dep){
//        this.department = department;
//        this.faculty = faculty;
//        this.head_of_dep = head_of_dep;
//    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
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
//    public String getHead_of_dep() {
//        return head_of_dep;
//    }
//
//    public void setHead_of_dep(String head_of_dep) {
//        this.head_of_dep = head_of_dep;
//    }
}