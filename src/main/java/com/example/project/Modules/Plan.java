package com.example.project.Modules;

import com.example.project.Modules.Containers.AcademicActivity;
import com.example.project.Modules.Containers.LoadContainer;
import com.example.project.Modules.Containers.ResearchActivity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})

@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long plan_id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id")
    private Teacher teacher;

    private String date;

    @Type(type = "jsonb")
    @Column(name = "load", columnDefinition = "jsonb")
    private List<LoadContainer> load;

    @Type(type = "jsonb")
    @Column(name = "academic_activity", columnDefinition = "jsonb")
    private List<AcademicActivity> academic_activity;

    @Type(type = "jsonb")
    @Column(name = "research_activity", columnDefinition = "jsonb")
    private List<ResearchActivity> research_activity;

    @Type(type = "jsonb")
    @Column(name = "method_activity", columnDefinition = "jsonb")
    private List<AcademicActivity> method_activity;

    @Type(type = "jsonb")
    @Column(name = "edu_activity", columnDefinition = "jsonb")
    private List<AcademicActivity> edu_activity;
}

