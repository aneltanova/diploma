package com.example.project.Repositories;

import com.example.project.Modules.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivitiesRepo extends JpaRepository<Activities, Long> {
    List<Activities> findActivitiesByTeacherId(Long id);
}
