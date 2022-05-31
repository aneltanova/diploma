package com.example.project.Controllers;

import com.example.project.Modules.Groups;
import com.example.project.Modules.Teacher;
import com.example.project.Repositories.GroupsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String getGroupsPage(Model model){
        List<Groups> groups = groupsRepo.findAll();
        model.addAttribute("groups", groups);
        return "groups_edit";
    }

    @GetMapping("/groups/add")
    public String addGroup(){
        return "groups_edit";
    }

    @PostMapping("/groups/add")
    public String add(Groups group) {
        groupsRepo.save(group);
        return "redirect:/groups";
    }

    @GetMapping("/groups/delete")
    public String delete(@RequestParam long id) {
        groupsRepo.deleteById(id);
        return "redirect:/groups";
    }

    @PostMapping("/groups/edit")
    public String update(@ModelAttribute Groups group) {
        groupsRepo.save(group);
        return "redirect:/groups";
    }

}
