package iitu.kz.diploma.Models;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import iitu.kz.diploma.ListToJsonConverter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@TypeDefs({

        @TypeDef(name = "json", typeClass = JsonBinaryType.class)
})

@Entity
@Table(name = "Load")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "teacher_id", nullable = false, columnDefinition = "BIGINT")
    private long teacher_id;

    @Column(name = "academic_load", columnDefinition = "json")
    @Convert(converter = ListToJsonConverter.class)
    private List<String> academic_load;


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


    public Load() {
    }

    public Load(long teacher_id, List<String> academic_load) {
        this.teacher_id = teacher_id;
        this.academic_load = academic_load;
    }

    //    public Load(long teacher_id, String discipline, String speciality, String group, String target_activity, String component) {
//        this.teacher_id = teacher_id;
//        this.discipline = discipline;
//        this.speciality = speciality;
//        this.group = group;
//        this.target_activity = target_activity;
//        this.component = component;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public List<String> getAcademic_load() {
        return academic_load;
    }

    public void setAcademic_load(List<String> academic_load) {
        this.academic_load = academic_load;
    }
//    public String getDiscipline() {
//        return discipline;
//    }
//
//    public void setDiscipline(String discipline) {
//        this.discipline = discipline;
//    }
//
//    public String getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(String speciality) {
//        this.speciality = speciality;
//    }
//
//    public String getGroup() {
//        return group;
//    }
//
//    public void setGroup(String group) {
//        this.group = group;
//    }
//
//    public String getTarget_activity() {
//        return target_activity;
//    }
//
//    public void setTarget_activity(String target_activity) {
//        this.target_activity = target_activity;
//    }
//
//    public String getComponent() {
//        return component;
//    }
//
//    public void setComponent(String component) {
//        this.component = component;
//    }
}