package iitu.kz.diploma.Models;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")  // updatable = false
    private Long id;

    @Column(name = "full_name", nullable = false, columnDefinition = "TEXT", unique = true)
    private String fullname;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name = "role", nullable = false, columnDefinition = "TEXT")
    private String role;

    public Teachers() {
    }

    public Teachers(String email, String password, String role) {

    }

}
