package com.example.project.Controllers;

import com.example.project.Modules.Groups;
import com.example.project.Modules.Specialities;
import com.example.project.Repositories.SpecialitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SpecialityController {

    private final SpecialitiesRepo specialitiesRepo;

    @Autowired
    SpecialityController(SpecialitiesRepo specialitiesRepo){
        this.specialitiesRepo = specialitiesRepo;
    }

    @GetMapping("/specialities/edit")
    public String getSpecialitiesPage(Model model){
        List<Specialities> specialities = specialitiesRepo.findAll();
        model.addAttribute("specialities", specialities);
        return "specialities_edit";
    }

    @GetMapping("/specialities")
    public String getGroupsList(Model model){
        List<Specialities> specialities = specialitiesRepo.findAll();
        model.addAttribute("specialities", specialities);
        return "specialities_list";
    }

    @GetMapping("/specialities/add")
    public String addGroup(){
        return "specialities_edit";
    }

    @PostMapping("/specialities/add")
    public String add(Specialities speciality) {
        specialitiesRepo.save(speciality);
        return "redirect:/specialities/edit";
    }

    @GetMapping("/specialities/delete")
    public String delete(@RequestParam long id) {
        specialitiesRepo.deleteById(id);
        return "redirect:/specialities/edit";
    }

    @PostMapping("/specialities/edit")
    public String update(@ModelAttribute Specialities speciality) {
        specialitiesRepo.save(speciality);
        return "redirect:/specialities/edit";
    }
}
