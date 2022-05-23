package com.example.project.Modules;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Load")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "teacher_id", nullable = false, columnDefinition = "BIGINT")
    private long teacher_id;

    @Type(type = "jsonb")
    @Column(name = "academic_load", columnDefinition = "jsonb")
    private List<LoadContainer> load;
    //@Convert(converter = ListToJsonConverter.class)

//    @Column(name = "discipline", nullable = true, columnDefinition = "TEXT")
//    private String discipline;
//
//    @Column(name = "speciality", nullable = true, columnDefinition = "TEXT") //ЦД
//    private String speciality;
//
//    @Column(name = "group", nullable = true, columnDefinition = "TEXT")
//    private String group;
//
//    @Column(name = "target_activity", nullable = true, columnDefinition = "TEXT")
//    private String target_activity;
//
//    @Column(name = "component", nullable = true, columnDefinition = "TEXT")
//    private String component;

}

