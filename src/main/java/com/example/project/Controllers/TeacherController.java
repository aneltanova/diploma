package com.example.project.Controllers;

import com.example.project.Modules.Groups;
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

    @GetMapping("/users/list")
    public String getUsersList(Model model){
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "users_list";
    }

    @GetMapping("/users/edit")
    public String getUsersPage(Model model){
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "users_edit";
    }

    @GetMapping("/users/delete")
    public String delete(@RequestParam long id) {
        teacherRepository.deleteById(id);
        return "redirect:/users/edit";
    }

//    @PostMapping("/users/edit")
//    public String update(@ModelAttribute Teacher teacher) {
//         if (role.getRolename().equals("ADMIN")){
//                role.setRole_id(1L);
//            }
//                else if (role.getRolename().equals("HEAD_OF_DEP")){
//                role.setRole_id(2L);
//            }
//                else
//                        role.setRole_id(3L);
//        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
//        teacherRepository.save(teacher);
//        return "redirect:/users/edit";
//    }

}
