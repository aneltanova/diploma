package com.example.project.Controllers;

import com.example.project.Modules.Disciplines;
import com.example.project.Repositories.DisciplinesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DisciplinesController {

    private final DisciplinesRepo disciplinesRepo;

    @Autowired
    DisciplinesController(DisciplinesRepo disciplinesRepo){
        this.disciplinesRepo = disciplinesRepo;
    }

    @GetMapping("/disciplines/add")
    public String getDisciplinesPage(){
        return "discipline_add";
    }

    @PostMapping("/disciplines")
    public String add(Disciplines discipline) {
        disciplinesRepo.save(discipline);
        return "disciplines_list";
    }

//    @GetMapping("/find/{id}")
//    public Optional<Disciplines> find(@PathVariable("id") long id) {
//        return disciplinesRepo.findById(id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable("id") long id) {
//        disciplinesRepo.deleteById(id);
//    }
//
//    @PutMapping("/update/{id}")
//    public Disciplines update(@PathVariable("id") long id, @RequestBody Disciplines discipline) {
//        discipline.setId(id);
//        disciplinesRepo.save(discipline);
//        return discipline;
//    }
}
