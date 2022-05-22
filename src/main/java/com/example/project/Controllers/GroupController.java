package com.example.project.Controllers;

import com.example.project.Modules.Groups;
import com.example.project.Repositories.GroupsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class GroupController {

    private final GroupsRepo groupsRepo;

    @Autowired
    GroupController(GroupsRepo groupsRepo){
        this.groupsRepo = groupsRepo;
    }

    @GetMapping("/groups")
    public String getGroupsPage(){
        return "group_add";
    }

    @GetMapping("/groupsFindAll")
    public List<Groups> findAll() {
        return (List<Groups>) groupsRepo.findAll();
    }

    @PostMapping("/groupCreate")
    public String add(Groups speciality) {
        groupsRepo.save(speciality);
        return "home";
    }

//    @GetMapping("/find/{id}")
//    public Optional<Groups> find(@PathVariable("id") long id) {
//        return groupsRepo.findById(id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable("id") long id) {
//        groupsRepo.deleteById(id);
//    }
//
//    @PutMapping("/update/{id}")
//    public Groups update(@PathVariable("id") long id, @RequestBody Groups group) {
//        group.setId(id);
//        groupsRepo.save(group);
//        return group;
//    }
}
