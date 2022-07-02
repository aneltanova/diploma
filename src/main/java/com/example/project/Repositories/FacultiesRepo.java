package com.example.project.Repositories;

import com.example.project.Modules.Faculties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultiesRepo extends JpaRepository<Faculties, Long>{
}
