package com.example.project.Modules.Containers;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TeachingWorkload {
    private String workload_name;

    private double SIS;

    private double exams;

    public double getTotalhours(){
        return getSIS() + getExams();
    }

}
