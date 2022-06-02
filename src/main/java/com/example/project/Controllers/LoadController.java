package com.example.project.Controllers;

import com.example.project.Modules.*;
import com.example.project.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoadController {

    @Autowired
    private LoadRepo loadRepo;
    @Autowired
    private GroupsRepo groupRepo;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DisciplinesRepo disciplinesRepo;

    private List<LoadContainer> loadContainer = new ArrayList<LoadContainer>();

    @GetMapping("/load_create")
    public String addLoadPage(Model model){
        List<Groups> groups = groupRepo.findAll();
        List<Disciplines> disciplines = disciplinesRepo.findAll();
        List<Teacher> teachers = teacherRepository.findAll();

        model.addAttribute("groups", groups);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("teachers", teachers);

        return "load_create";
    }

    @PostMapping("/load")
    public String addLoadContent(Model model, LoadContainer load){
        if(loadContainer.contains(load)){
        }
        else {
            loadContainer.add(load);
        }
        model.addAttribute("loadContainer", loadContainer);
        return "load";
    }

    @GetMapping("/load")
    public String getLoadPage(Model model){
        model.addAttribute("loadContainer", loadContainer);
        return "load";
    }


    @PostMapping("/createLoad")
    public String add(Authentication authentication) {
        Load load = new Load();
        load.setAcademic_load(loadContainer);
        load.setHeadid(teacherRepository.findTeacherByEmail(authentication.getName()).getId());
        loadRepo.save(load);
        return "load";
    }

    @GetMapping("/load_disp")
    public String displayLoad(Model model, Authentication authentication){
        List<Load> load = loadRepo.findAll();
        Load userload = new Load();
        for(Load temp : load){
            if (teacherRepository.findTeacherById(temp.getHeadid()).getDepartment_id().equals( teacherRepository.findTeacherByEmail(authentication.getName()).getDepartment_id())){
                userload.setAcademic_load(temp.getAcademic_load());
            }
        }
        List<LoadContainer> loadContainer = userload.getAcademic_load();
        System.out.println(loadContainer);
        model.addAttribute("loadlist", loadContainer);
        return "load_list";
    }

}

