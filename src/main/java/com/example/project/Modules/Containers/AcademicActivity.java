package com.example.project.Modules.Containers;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AcademicActivity {

    private String activity_name;

    private Double time_frame;

    private Double implementation;
}
