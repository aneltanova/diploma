package iitu.kz.diploma.Models;

import iitu.kz.diploma.ListToStringConverter;

import javax.persistence.*;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Teachers")
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "full_name", nullable = false, columnDefinition = "TEXT")
    private String full_name;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;

    @Column(name = "position", nullable = false, columnDefinition = "TEXT")
    private String position;

    @Column(name = "degree", nullable = false, columnDefinition = "TEXT")
    private String degree;

    @Column(name = "department", nullable = false, columnDefinition = "TEXT")
    private String department;

    @Column(name = "articles", nullable = true, columnDefinition = "TEXT[]")
    @Convert(converter = ListToStringConverter.class)
    private List<String> articles;

    @Column(name = "load", nullable = true, columnDefinition = "NUMERIC")
    private long load;

//    public Teachers() {
//    }
//
//    public Teachers(String full_name, String email, String position, String degree, String department, List<String> articles, long load) {
//        this.full_name = full_name;
//        this.email = email;
//        this.position = position;
//        this.degree = degree;
//        this.department = department;
//        this.articles = articles;
//        this.load = load;
//    }
//
//    public long getLoad() {
//        return load;
//    }
//
//    public void setLoad(long load) {
//        this.load = load;
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
//    public String getFull_name() {
//        return full_name;
//    }
//
//    public void setFull_name(String full_name) {
//        this.full_name = full_name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public String getDegree() {
//        return degree;
//    }
//
//    public void setDegree(String degree) {
//        this.degree = degree;
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
//    public List<String> getArticles() {
//        return articles;
//    }
//
//    public void setArticles(List<String> articles) {
//        this.articles = articles;
//    }

}
