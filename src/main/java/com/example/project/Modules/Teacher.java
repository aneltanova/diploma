package com.example.project.Modules;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String position;
    private String degree;
    private String department_id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public String fullName(){
        return getSurname() + " " + getName();
    }
}


