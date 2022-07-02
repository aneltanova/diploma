package com.example.project.Repositories;

import com.example.project.Modules.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepo extends JpaRepository<Groups, Long> {
}
