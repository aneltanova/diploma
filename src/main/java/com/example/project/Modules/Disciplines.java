package com.example.project.Modules;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Disciplines")
public class Disciplines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "discipline", nullable = false, columnDefinition = "TEXT", unique = true)
    private String discipline;

    @Column(name = "lecture_hours", nullable = false, columnDefinition = "NUMERIC")
    private long lecture_hours;

    @Column(name = "practice_hours", nullable = false, columnDefinition = "NUMERIC")
    private long practice_hours;

    @Column(name = "laboratory_hours", nullable = false, columnDefinition = "NUMERIC")
    private long laboratory_hours;

    @Column(name = "SIS", nullable = false, columnDefinition = "NUMERIC")
    private long sis;

    @Column(name = "credits", nullable = false, columnDefinition = "NUMERIC")
    private long credits;

    public long totalhours() {
        return getLecture_hours()+getLaboratory_hours()+getSis()+getPractice_hours();
    }

}
