package com.example.project.Repositories;

import com.example.project.Modules.Plan;
import com.example.project.Modules.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findTeacherByEmail(String email);

    Teacher findTeacherById(Long id);

//    @Query("SELECT u FROM Teacher u WHERE u.role = 'HEAD_OF_DEP' or u.role = 'TEACHER'")
//    Teacher findTeacherByRole();
}
