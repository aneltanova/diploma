package com.example.project.Repositories;

import com.example.project.Modules.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepo extends JpaRepository<Departments, Long> {
}
