package com.example.project.Controllers;

import com.example.project.Modules.Groups;
import com.example.project.Modules.Teacher;
import com.example.project.Repositories.GroupsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/groups/add")
    public String addGroup(){
        return "groups_edit";
    }

    @GetMapping("/groups")
    public String getGroupsPage(Model model){
        List<Groups> groups = groupsRepo.findAll();
        model.addAttribute("groups", groups);
        return "groups_edit";
    }

    @PostMapping("/groups/add")
    public String add(Groups speciality) {
        groupsRepo.save(speciality);
        return "redirect:/groups";
    }

//    @GetMapping("/groups/edit")


    @GetMapping("/groups/delete")
    public String delete(@RequestParam long id) {
        groupsRepo.deleteById(id);
        return "redirect:/groups";
    }
//    @PutMapping("/update/{id}")
//    public Groups update(@PathVariable("id") long id, @RequestBody Groups group) {
//        group.setId(id);
//        groupsRepo.save(group);
//        return group;
//    }

//    @GetMapping("/find/{id}")
//    public Optional<Groups> find(@PathVariable("id") long id) {
//        return groupsRepo.findById(id);
//    }
//
//

}
