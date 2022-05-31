package com.example.project.Modules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@Scope("session")
public class LoadContainer {

    private Disciplines discipline;

    private Groups group;

    private Teacher teacher;
}
