package com.example.project.Modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicLoad implements Serializable {
    private String discipline;
    private String speciality;
    private List<String> groups;
    private String target_activity;
    private String component;

}
