package com.example.project.Controllers;

import com.example.project.Modules.Activities;
import com.example.project.Modules.Containers.AcademicActivity;
import com.example.project.Modules.Containers.LoadContainer;
import com.example.project.Modules.Containers.TeachingWorkload;
import com.example.project.Modules.Load;
import com.example.project.Modules.Report;
import com.example.project.Modules.Teacher;
import com.example.project.Repositories.ActivitiesRepo;
import com.example.project.Repositories.LoadRepo;
import com.example.project.Repositories.ReportRepo;
import com.example.project.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private LoadRepo loadRepo;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ActivitiesRepo activitiesRepo;

    @Autowired
    private ReportRepo reportRepo;

    List<TeachingWorkload> workload = new ArrayList<>();

    List<AcademicActivity> educationalActivities = new ArrayList<>();

    List<AcademicActivity> methodActivities = new ArrayList<>();

    List<LoadContainer> loadContainer;

    @GetMapping("/report")
    public String getReportPage(Authentication authentication, Model model){

        Double sumofMethActivityframe = 0.0;
        Double sumofMethActivityimp = 0.0;

        Double sumofEduActivityframe = 0.0;
        Double sumofEduActivityimp = 0.0;



        List<Load> load = loadRepo.findAll();

        Teacher teacher = teacherRepository.findTeacherByEmail(authentication.getName());
        Load userload = new Load();
        for(Load temp : load){
            if (teacherRepository.findTeacherById(temp.getHeadid()).getDepartment_id().equals( teacher.getDepartment_id())){
                userload.setAcademic_load(temp.getAcademic_load());
            }
        }
        loadContainer = userload.getAcademic_load();
        List<Activities> researchActivities = activitiesRepo.findActivitiesByTeacherId(teacher.getId());



        loadContainer.removeIf(loadContainer1 -> (!loadContainer1.getTeacher().getEmail().equals(authentication.getName())));

        if(!methodActivities.isEmpty()) {
            sumofMethActivityframe = methodActivities.stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofMethActivityimp = methodActivities.stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofMethActivtyframe", sumofMethActivityframe);
        model.addAttribute("sumofMethActivtyimp", sumofMethActivityimp);

        if(!educationalActivities.isEmpty()) {
            sumofEduActivityframe = educationalActivities.stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofEduActivityimp = educationalActivities.stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofEduActivtyframe", sumofEduActivityframe);
        model.addAttribute("sumofEduActivtyimp", sumofEduActivityimp);

        model.addAttribute("loadContainer", loadContainer);
        model.addAttribute("workloads", workload);
        model.addAttribute("researchActivities", researchActivities);
        model.addAttribute("methActivities", methodActivities);
        model.addAttribute("eduActivities", educationalActivities);
        model.addAttribute("teacher", teacher);
        return "report";
    }




    @PostMapping("/saveReport")
    public String saveReport(@RequestParam(name = "doc_date") String date, Authentication authentication, Report temp){
        Report report = new Report();
        Teacher teacher = teacherRepository.findTeacherByEmail(authentication.getName());
        report.setTeacher(teacher);
        report.setDate(date);
        report.setDiploma_management(temp.getDiploma_management());
        report.setMaster_theses(temp.getMaster_theses());
        report.setMaster_theses_second(temp.getMaster_theses_second());
        report.setElectives(temp.getElectives());
        report.setSeminars(temp.getSeminars());
        report.setScientific_project(temp.getScientific_project());
        report.setSertificates_awards(temp.getSertificates_awards());
        report.setBudgetary_research(temp.getBudgetary_research());
        report.setGrants(temp.getGrants());
        report.setJoint(temp.getJoint());
        report.setInternship(temp.getInternship());
        report.setPartnership(temp.getPartnership());
        report.setWorkload(workload);
        report.setEdu_activity(educationalActivities);
        report.setMethod_activity(methodActivities);
        report.setLoad(loadContainer);
        report.setStatus("waiting");

        reportRepo.save(report);

        return "redirect:/report_list";
    }

    @GetMapping("/report_list")
    public String listReport(Model model){
        List<Report> reports = reportRepo.findAll();

        model.addAttribute("reportlist", reports);

        return "report_list";
    }

    @GetMapping("/myreports")
    public String MylistReport(Model model, Authentication authentication){
        Teacher teacher = teacherRepository.findTeacherByEmail(authentication.getName());
        List<Report> reports = reportRepo.findReportByTeacherId(teacher.getId());
        model.addAttribute("reportlist", reports);
        return "report_list";
    }

    @PostMapping("/report_accept")
    public String AcceptReport(@RequestParam Long id){
        Report report = reportRepo.findReportById(id);
        report.setStatus("accepted");
        reportRepo.save(report);
        return "redirect:/report_list";
    }

    @PostMapping("/report_decline")
    public String DeclineReport(@RequestParam Long id){
        Report report = reportRepo.findReportById(id);
        report.setStatus("declined");
        reportRepo.save(report);
        return "redirect:/report_list";
    }

    @GetMapping("/report_disp/{id}")
    public String dispReport(@PathVariable Long id, Model model){
        Report report = reportRepo.findReportById(id);

        Double sumofMethActivityframe = 0.0;
        Double sumofMethActivityimp = 0.0;

        Double sumofEduActivityframe = 0.0;
        Double sumofEduActivityimp = 0.0;


        if(!methodActivities.isEmpty()) {
            sumofMethActivityframe = methodActivities.stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofMethActivityimp = methodActivities.stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofMethActivtyframe", sumofMethActivityframe);
        model.addAttribute("sumofMethActivtyimp", sumofMethActivityimp);

        if(!educationalActivities.isEmpty()) {
            sumofEduActivityframe = educationalActivities.stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofEduActivityimp = educationalActivities.stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofEduActivtyframe", sumofEduActivityframe);
        model.addAttribute("sumofEduActivtyimp", sumofEduActivityimp);


        model.addAttribute("report", report);


        return "report_disp";
    }

    @PostMapping("/report/addTeach")
    public String addAcadem(TeachingWorkload teachingWorkload) {
        if(!workload.contains(teachingWorkload)){
            workload.add(teachingWorkload);
        }

        return "redirect:/report";
    }

    @PostMapping("/report/addMeth")
    public String addMeth(AcademicActivity academicActivity) {
        if(!methodActivities.contains(academicActivity)){
            methodActivities.add(academicActivity);
        }

        return "redirect:/report";
    }

    @PostMapping("/report/addEdu")
    public String addEdu(AcademicActivity academicActivity) {
        if(!educationalActivities.contains(academicActivity)){
            educationalActivities.add(academicActivity);
        }

        return "redirect:/report";
    }

    @GetMapping("/report/deleteMeth")
    public String deleteMeth(String activity_name) {
        methodActivities.removeIf(activity -> activity.getActivity_name().equals(activity_name));
        return "redirect:/report";
    }
    @GetMapping("/report/deleteEdu")
    public String deleteEdu(String activity_name) {
        educationalActivities.removeIf(activity -> activity.getActivity_name().equals(activity_name));
        return "redirect:/report";
    }
    @GetMapping("/report/deleteTeach")
    public String deleteAcadem(String activity_name) {
        workload.removeIf(activity -> activity.getWorkload_name().equals(activity_name));
        return "redirect:/report";
    }
}
