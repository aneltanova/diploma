package com.example.project.Controllers;

import com.example.project.Modules.Role;
import com.example.project.Modules.Teacher;
import com.example.project.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;


    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "users_edit";
    }

    @GetMapping("/users/delete")
    public String delete(@RequestParam long id) {
        teacherRepository.deleteById(id);
        return "redirect:/users";
    }
    @PutMapping("/users/update/{id}")
    public Teacher update(@PathVariable("id") long id, @RequestBody Teacher teacher, @RequestBody Role role){
        teacher.setRole(role);
        teacherRepository.save(teacher);
        return teacher;
    }

}
