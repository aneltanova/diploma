package com.example.project.Controllers;

import com.example.project.Modules.Departments;
import com.example.project.Repositories.DepartmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {


    private final DepartmentsRepo departmentsRepo;

    @Autowired
    DepartmentController(DepartmentsRepo departmentsRepo){
        this.departmentsRepo = departmentsRepo;
    }

    @GetMapping("/findall")
    public List<Departments> findAll() {
        return (List<Departments>) departmentsRepo.findAll();
    }

    @PostMapping("/create")
    public Departments add(@RequestBody Departments department) {
        departmentsRepo.save(department);
        return department;
    }

    @GetMapping("/find/{id}")
    public Optional<Departments> find(@PathVariable("id") long id) {
        return departmentsRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        departmentsRepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Departments update(@PathVariable("id") long id, @RequestBody Departments department) {
        department.setId(id);
        departmentsRepo.save(department);
        return department;
    }
}
