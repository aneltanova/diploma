package com.example.project.Controllers;

import com.example.project.Modules.Departments;
import com.example.project.Modules.Faculties;
import com.example.project.Repositories.DepartmentsRepo;
import com.example.project.Repositories.FacultiesRepo;
import com.example.project.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentsRepo departmentsRepo;
    @Autowired
    private FacultiesRepo facultiesRepo;

    @PostMapping("/departments/add")
    public Departments add(Departments department) {
        departmentsRepo.save(department);
        return department;
    }

    @GetMapping("/departments")
    public String getDepartmentsPage(Model model){
        List<Faculties> faculty = facultiesRepo.findAll();
        List<Departments> department = departmentsRepo.findAll();
        model.addAttribute("departments", department);
        model.addAttribute("faculties", faculty);
        return "departments_list";
    }

    @DeleteMapping("/departments/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        departmentsRepo.deleteById(id);
    }

    @PutMapping("/departments/update/{id}")
    public Departments update(@PathVariable("id") long id, @RequestBody Departments department) {
        department.setId(id);
        departmentsRepo.save(department);
        return department;
    }
}
