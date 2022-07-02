package com.example.project.Repositories;

import com.example.project.Modules.Plan;
import com.example.project.Modules.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepo extends JpaRepository<Report, Long> {
    @Query("SELECT u FROM Report u WHERE u.report_id = ?1")
    Report findReportById(long id);

    @Query("SELECT u FROM Report u WHERE u.teacher.id = ?1")
    List<Report> findReportByTeacherId(long id);
}
