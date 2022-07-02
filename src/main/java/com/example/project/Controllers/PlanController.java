package com.example.project.Controllers;

import com.example.project.Modules.Containers.AcademicActivity;
import com.example.project.Modules.Containers.LoadContainer;
import com.example.project.Modules.Containers.ResearchActivity;
import com.example.project.Modules.Load;
import com.example.project.Modules.Plan;
import com.example.project.Modules.Teacher;
import com.example.project.Repositories.LoadRepo;
import com.example.project.Repositories.PlanRepo;
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
public class PlanController {

    @Autowired
    LoadRepo loadRepo;

    @Autowired
    TeacherRepository teacherRepository;

    List<AcademicActivity> academicActivities = new ArrayList<>();

    List<AcademicActivity> methodActivities = new ArrayList<>();

    List<AcademicActivity> eduActivities = new ArrayList<>();

    List<ResearchActivity> researchActivities = new ArrayList<>();

    List<LoadContainer> loadContainer;

    @Autowired
    PlanRepo planRepo;


    @GetMapping("/plan")
    public String getPlan(Model model, Authentication authentication){

        Double sumofacademicActivityframe = 0.0;
        Double sumofacademicActivityimp = 0.0;

        Double sumofResActivityoutput = 0.0;
        Double sumofResActivityframe = 0.0;
        Double sumofResActivityimp = 0.0;

        Double sumofMethActivityframe = 0.0;
        Double sumofMethActivityimp = 0.0;

        Double sumofEduActivityframe = 0.0;
        Double sumofEduActivityimp = 0.0;


        Teacher teacher = teacherRepository.findTeacherByEmail(authentication.getName());
        List<Load> load = loadRepo.findAll();
        Load userload = new Load();
            for(Load temp : load){
                if (teacherRepository.findTeacherById(temp.getHeadid()).getDepartment_id().equals(teacher.getDepartment_id())){
                    userload.setAcademic_load(temp.getAcademic_load());
                }
            }
        loadContainer = userload.getAcademic_load();

        loadContainer.removeIf(loadContainer1 -> (!loadContainer1.getTeacher().getEmail().equals(authentication.getName())));

        model.addAttribute("loadContainer", loadContainer);
        model.addAttribute("teacher", teacher);

        model.addAttribute("academicActivities", academicActivities);
        model.addAttribute("researchActivities", researchActivities);
        model.addAttribute("methActivities", methodActivities);
        model.addAttribute("eduActivities", eduActivities);


        if(!academicActivities.isEmpty()) {
            sumofacademicActivityframe = academicActivities.stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofacademicActivityimp = academicActivities.stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofacademicActivtyframe", sumofacademicActivityframe);
        model.addAttribute("sumofacademicActivtyimp", sumofacademicActivityimp);

        if(!researchActivities.isEmpty()) {
            sumofResActivityframe = researchActivities.stream().mapToDouble(ResearchActivity::getTime_frame).sum();
            sumofResActivityimp = researchActivities.stream().mapToDouble(ResearchActivity::getImplementation).sum();
            sumofResActivityoutput = researchActivities.stream().mapToDouble(ResearchActivity::getOutput).sum();
        }
        model.addAttribute("sumofresActivtyframe", sumofResActivityframe);
        model.addAttribute("sumofresActivtyimp", sumofResActivityimp);
        model.addAttribute("sumofresActivityout", sumofResActivityoutput);

        if(!methodActivities.isEmpty()) {
            sumofMethActivityframe = methodActivities.stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofMethActivityimp = methodActivities.stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofMethActivtyframe", sumofMethActivityframe);
        model.addAttribute("sumofMethActivtyimp", sumofMethActivityimp);

        if(!eduActivities.isEmpty()) {
            sumofEduActivityframe = eduActivities.stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofEduActivityimp = eduActivities.stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofEduActivtyframe", sumofEduActivityframe);
        model.addAttribute("sumofEduActivtyimp", sumofEduActivityimp);

            return "plan";
    }

    @PostMapping("/savePlan")
    public String savePlan(@RequestParam(name = "doc_date") String date, Authentication authentication){
        Plan plan = new Plan();

        plan.setDate(date);
        plan.setLoad(loadContainer);
        plan.setAcademic_activity(academicActivities);
        plan.setResearch_activity(researchActivities);
        plan.setEdu_activity(eduActivities);
        plan.setMethod_activity(methodActivities);
        Teacher teacher = teacherRepository.findTeacherByEmail(authentication.getName());
        plan.setTeacher(teacher);
        plan.setStatus("waiting");
        planRepo.save(plan);
        return "redirect:/plan_list";
    }


    @GetMapping("/plan_list")
    public String listPlan(Model model){
        List<Plan> planList = planRepo.findAll();

        model.addAttribute("planlist", planList);

        return "plan_list";
    }

    @GetMapping("/myplans")
    public String mylistPlan(Model model, Authentication authentication){
        Teacher teacher = teacherRepository.findTeacherByEmail(authentication.getName());
        List<Plan> planList = planRepo.findPlanByTeacherId(teacher.getId());
        model.addAttribute("planlist", planList);
        return "plan_list";
    }

    @PostMapping("/plan_accept")
    public String AcceptPlan(@RequestParam Long id){
        Plan plan = planRepo.findPlanById(id);
        plan.setStatus("accepted");
        planRepo.save(plan);
        return "redirect:/plan_list";
    }

    @PostMapping("/plan_decline")
    public String DeclinePlan(@RequestParam Long id){
        Plan plan = planRepo.findPlanById(id);
        plan.setStatus("declined");
        planRepo.save(plan);
        return "redirect:/plan_list";
    }


    @GetMapping("/plan_disp/{id}")
    public String dispPlan(@PathVariable Long id,Model model){
        Plan plan = planRepo.findPlanById(id);

        Double sumofacademicActivityframe = 0.0;
        Double sumofacademicActivityimp = 0.0;

        Double sumofResActivityoutput = 0.0;
        Double sumofResActivityframe = 0.0;
        Double sumofResActivityimp = 0.0;

        Double sumofMethActivityframe = 0.0;
        Double sumofMethActivityimp = 0.0;

        Double sumofEduActivityframe = 0.0;
        Double sumofEduActivityimp = 0.0;

        if(!plan.getAcademic_activity().isEmpty()) {
            sumofacademicActivityframe = plan.getAcademic_activity().stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofacademicActivityimp = plan.getAcademic_activity().stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofacademicActivtyframe", sumofacademicActivityframe);
        model.addAttribute("sumofacademicActivtyimp", sumofacademicActivityimp);

        if(!plan.getResearch_activity().isEmpty()) {
            sumofResActivityframe = plan.getResearch_activity().stream().mapToDouble(ResearchActivity::getTime_frame).sum();
            sumofResActivityimp = plan.getResearch_activity().stream().mapToDouble(ResearchActivity::getImplementation).sum();
            sumofResActivityoutput = plan.getResearch_activity().stream().mapToDouble(ResearchActivity::getOutput).sum();
        }
        model.addAttribute("sumofresActivtyframe", sumofResActivityframe);
        model.addAttribute("sumofresActivtyimp", sumofResActivityimp);
        model.addAttribute("sumofresActivityout", sumofResActivityoutput);

        if(!plan.getMethod_activity().isEmpty()) {
            sumofMethActivityframe = plan.getMethod_activity().stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofMethActivityimp = plan.getMethod_activity().stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofMethActivtyframe", sumofMethActivityframe);
        model.addAttribute("sumofMethActivtyimp", sumofMethActivityimp);

        if(!plan.getEdu_activity().isEmpty()) {
            sumofEduActivityframe = plan.getEdu_activity().stream().mapToDouble(AcademicActivity::getTime_frame).sum();
            sumofEduActivityimp = plan.getEdu_activity().stream().mapToDouble(AcademicActivity::getImplementation).sum();
        }
        model.addAttribute("sumofEduActivtyframe", sumofEduActivityframe);
        model.addAttribute("sumofEduActivtyimp", sumofEduActivityimp);


        model.addAttribute("plan", plan);


        return "plan_disp";
    }


    @PostMapping("/plan/addAcadem")
    public String addAcadem(AcademicActivity academicActivity) {
        if(!academicActivities.contains(academicActivity)){
            academicActivities.add(academicActivity);
        }

        return "redirect:/plan";
    }

    @PostMapping("/plan/addMeth")
    public String addMeth(AcademicActivity academicActivity) {
        if(!methodActivities.contains(academicActivity)){
            methodActivities.add(academicActivity);
        }

        return "redirect:/plan";
    }

    @PostMapping("/plan/addEdu")
    public String addEdu(AcademicActivity academicActivity) {
        if(!eduActivities.contains(academicActivity)){
            eduActivities.add(academicActivity);
        }

        return "redirect:/plan";
    }

    @PostMapping("/plan/addRes")
    public String addRes(ResearchActivity academicActivity) {
        if(!researchActivities.contains(academicActivity)){
            researchActivities.add(academicActivity);
        }

        return "redirect:/plan";
    }

    @GetMapping("/plan/deleteMeth")
    public String deleteMeth(String activity_name) {
        methodActivities.removeIf(activity -> activity.getActivity_name().equals(activity_name));
        return "redirect:/plan";
    }
    @GetMapping("/plan/deleteEdu")
    public String deleteEdu(String activity_name) {
        eduActivities.removeIf(activity -> activity.getActivity_name().equals(activity_name));
        return "redirect:/plan";
    }
    @GetMapping("/plan/deleteAcadem")
    public String deleteAcadem(String activity_name) {
        academicActivities.removeIf(activity -> activity.getActivity_name().equals(activity_name));
        return "redirect:/plan";
    }
    @GetMapping("/plan/deleteRes")
    public String deleteRes(String activity_name) {
        System.out.println(activity_name);
        researchActivities.removeIf(activity -> activity.getActivity_name().equals(activity_name));
        return "redirect:/plan";
    }



}
