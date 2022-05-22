package com.example.project.Controllers;

import com.example.project.Modules.Role;
import com.example.project.Modules.Teacher;
import com.example.project.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "user_add";
    }

    @PostMapping("/signUp")
    public String signUpUser(Teacher teacher, Role role){
        if (role.getRolename().equals("ADMIN")){
            role.setRole_id(1L);
        }
        else if (role.getRolename().equals("HEAD_OF_DEP")){
            role.setRole_id(2L);
        }
        else
            role.setRole_id(3L);
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacher.setRole(role);
        teacherRepository.save(teacher);
        return "home";
        //redirect:/signUp
    }
}
