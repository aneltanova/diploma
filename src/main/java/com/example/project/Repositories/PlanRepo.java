package com.example.project.Repositories;

import com.example.project.Modules.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Long> {

    @Query("SELECT u FROM Plan u WHERE u.plan_id = ?1")
    Plan findPlanById(long id);

    @Query("SELECT u FROM Plan u WHERE u.teacher.id = ?1")
    List<Plan> findPlanByTeacherId(long id);
}
