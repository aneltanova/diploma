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

//    public Disciplines(){   }
//
//    public Disciplines(String discipline, long lecture_hours, long practice_hours, long laboratory_hours, long sis, long credits){
//        this.discipline = discipline;
//        this.lecture_hours = lecture_hours;
//        this.practice_hours = practice_hours;
//        this.laboratory_hours = laboratory_hours;
//        this.sis = sis;
//        this.credits = credits;
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
//    public String getDiscipline() {
//        return discipline;
//    }
//
//    public void setDiscipline(String discipline) {
//        this.discipline = discipline;
//    }
//
//    public long getLecture_hours() {
//        return lecture_hours;
//    }
//
//    public void setLecture_hours(long lecture_hours) {
//        this.lecture_hours = lecture_hours;
//    }
//
//    public long getPractice_hours() {
//        return practice_hours;
//    }
//
//    public void setPractice_hours(long practice_hours) {
//        this.practice_hours = practice_hours;
//    }
//
//    public long getLaboratory_hours() {
//        return laboratory_hours;
//    }
//
//    public void setLaboratory_hours(long laboratory_hours) {
//        this.laboratory_hours = laboratory_hours;
//    }
//
//    public long getSis() {
//        return sis;
//    }
//
//    public void setSis(long sis) {
//        this.sis = sis;
//    }
//
//    public long getCredits() {
//        return credits;
//    }
//
//    public void setCredits(long credits) {
//        this.credits = credits;
//    }
}
