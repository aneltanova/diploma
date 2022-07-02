package com.example.project.Repositories;

import com.example.project.Modules.Load;
import com.example.project.Modules.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepo extends JpaRepository<Load, Long> {
    Load findByHeadid(Long id);
}
