package iitu.kz.diploma.Models;

import javax.persistence.*;

@Entity
@Table(name = "Faculties")
public class Faculties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "faculty", nullable = false, columnDefinition = "TEXT", unique = true)
    private String faculty;

    public Faculties(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Faculties(String faculty){
        this.faculty = faculty;
    }
}