package com.example.project.Modules;


import javax.persistence.*;
import java.util.List;

import com.example.project.ListToStringConverter;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Articles")
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;

    @Column(name = "authors", nullable = true, columnDefinition = "TEXT[]")
    @Convert(converter = ListToStringConverter.class)
    private List<String> authors;

    @Column(name = "publisher", nullable = true, columnDefinition = "TEXT[]")
    @Convert(converter = ListToStringConverter.class)
    private List<String> publisher;
}