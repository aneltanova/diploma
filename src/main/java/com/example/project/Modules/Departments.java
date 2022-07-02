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
//    @Column(name="id", nullable = false)  // updatable = false
    private long id;
    private String department_full;
//    @Column(name = "department", nullable = false, columnDefinition = "TEXT", unique = true)
    private String department;

//    @Column(name = "faculty", nullable = false, columnDefinition = "TEXT")
    private String faculty;

//    @Column(name = "head_of_dep", nullable = false, columnDefinition = "TEXT") // full_name
    private String head_of_dep;

}