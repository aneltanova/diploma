package com.example.project.Modules;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String type;

    private String authors;

    private String publisher;

    private String activityName;

    private String docType;

    private Long teacherId;

    @Lob
    private byte[] data;


    public Activities(String docname, String contentType, byte[] bytes, Long teacherId) {
        super();
        activityName = docname;
        docType = contentType;
        data = bytes;
        teacherId = teacherId;
    }
}
