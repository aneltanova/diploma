package com.example.project.Modules;

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
//    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    private String speciality_full;
//    @Column(name = "speciality", nullable = false, columnDefinition = "TEXT", unique = true)
    private String speciality;

//    @Column(name = "department", nullable = false, columnDefinition = "TEXT")
    private String department;

}
