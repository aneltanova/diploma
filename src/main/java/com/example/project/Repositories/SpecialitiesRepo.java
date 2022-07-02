package com.example.project.Repositories;

import com.example.project.Modules.Specialities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialitiesRepo extends JpaRepository<Specialities, Long> {
}
