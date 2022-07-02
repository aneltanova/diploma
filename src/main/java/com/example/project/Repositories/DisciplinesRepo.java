package com.example.project.Repositories;

import com.example.project.Modules.Disciplines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinesRepo extends JpaRepository<Disciplines, Long>{
}

