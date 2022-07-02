package com.example.project.Modules;

import com.example.project.Modules.Containers.AcademicActivity;
import com.example.project.Modules.Containers.LoadContainer;
import com.example.project.Modules.Containers.TeachingWorkload;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long report_id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id")
    private Teacher teacher;

    private String date;

    @Type(type = "jsonb")
    @Column(name = "load", columnDefinition = "jsonb")
    private List<LoadContainer> load;

    private String diploma_management;

    private String master_theses;

    private String master_theses_second;

    private String electives;

    private String seminars;

    private String scientific_project;

    private String sertificates_awards;

    private String budgetary_research;

    private String grants;

    private String joint;

    private String internship;

    private String partnership;

    @Type(type = "jsonb")
    @Column(name = "workload", columnDefinition = "jsonb")
    private List<TeachingWorkload> workload;

    @Type(type = "jsonb")
    @Column(name = "research_activity", columnDefinition = "jsonb")
    private List<Activities> research_activity;

    @Type(type = "jsonb")
    @Column(name = "method_activity", columnDefinition = "jsonb")
    private List<AcademicActivity> method_activity;

    @Type(type = "jsonb")
    @Column(name = "edu_activity", columnDefinition = "jsonb")
    private List<AcademicActivity> edu_activity;


}
