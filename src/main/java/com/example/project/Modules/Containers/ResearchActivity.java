package com.example.project.Modules.Containers;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResearchActivity {
    private String activity_name;

    private Double output;

    private Double time_frame;

    private Double implementation;

    private Integer participation;
}

