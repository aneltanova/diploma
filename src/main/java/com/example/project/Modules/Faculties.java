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
//    @Column(name="id", nullable = false)  // updatable = false
    private long id;
    private String faculty_full;
//    @Column(name = "faculty", nullable = false, columnDefinition = "TEXT", unique = true)
    private String faculty;

//    @Column(name = "dean", nullable = false, columnDefinition = "TEXT") // full_name
    private String dean;

}