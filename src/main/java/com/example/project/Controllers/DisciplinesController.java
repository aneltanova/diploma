package com.example.project.Controllers;

import com.example.project.Modules.Disciplines;
import com.example.project.Repositories.DisciplinesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DisciplinesController {

    private final DisciplinesRepo disciplinesRepo;

    @Autowired
    DisciplinesController(DisciplinesRepo disciplinesRepo){
        this.disciplinesRepo = disciplinesRepo;
    }

    @GetMapping("/disciplines/edit")
    public String getDisciplinesPage(Model model){
        List<Disciplines> disciplines = disciplinesRepo.findAll();
        model.addAttribute("disciplines", disciplines);
        return "disciplines_edit";
    }

    @GetMapping("/disciplines")
    public String getDisciplinesList(Model model){
        List<Disciplines> disciplines = disciplinesRepo.findAll();
        model.addAttribute("disciplines", disciplines);
        return "disciplines_list";
    }

    @GetMapping("/disciplines/add")
    public String addDiscipline(){
        return "disciplines_edit";
    }

    @PostMapping("/disciplines/add")
    public String add(Disciplines discipline) {
        disciplinesRepo.save(discipline);
        return "redirect:/disciplines";
    }

    @GetMapping("/disciplines/delete")
    public String delete(@RequestParam long id) {
        disciplinesRepo.deleteById(id);
        return "redirect:/disciplines/edit";
    }

    @PostMapping("/disciplines/edit")
    public String update(@ModelAttribute Disciplines discipline) {
        disciplinesRepo.save(discipline);
        return "redirect:/disciplines/edit";
    }
}
