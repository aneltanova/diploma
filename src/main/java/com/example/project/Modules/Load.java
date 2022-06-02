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

    @Column(name = "headid", nullable = false, columnDefinition = "BIGINT")
    private long headid;


    @Type(type = "jsonb")
    @Column(name = "academic_load", columnDefinition = "jsonb")
    private List<LoadContainer> academic_load;
}

