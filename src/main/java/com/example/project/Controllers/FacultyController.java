package com.example.project.Controllers;

import com.example.project.Modules.Departments;
import com.example.project.Modules.Faculties;
import com.example.project.Modules.Teacher;
import com.example.project.Repositories.DepartmentsRepo;
import com.example.project.Repositories.FacultiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FacultyController {

    @Autowired
    private DepartmentsRepo departmentsRepo;
    @Autowired
    private FacultiesRepo facultiesRepo;

    @PostMapping("/faculty/add")
    public Faculties add(@RequestBody Faculties faculty) {
        facultiesRepo.save(faculty);
        return faculty;
    }
    @GetMapping("/faculties")
    public String getFacultiesPage(Model model){
        List<Faculties> faculty = facultiesRepo.findAll();
        List<Departments> department = departmentsRepo.findAll();
        model.addAttribute("departments", department);
        model.addAttribute("faculties", faculty);
        return "faculties_list";
    }

    @DeleteMapping("/faculty/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        facultiesRepo.deleteById(id);
    }

    @PutMapping("/faculty/update/{id}")
    public Faculties update(@PathVariable("id") long id, @RequestBody Faculties faculty) {
        faculty.setId(id);
        facultiesRepo.save(faculty);
        return faculty;
    }
}
