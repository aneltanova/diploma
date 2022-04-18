package iitu.kz.diploma.Controllers;

import iitu.kz.diploma.Models.Groups;
import iitu.kz.diploma.Repos.GroupsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupsRepo groupsRepo;

    @Autowired
    GroupController(GroupsRepo groupsRepo){
        this.groupsRepo = groupsRepo;
    }

    @GetMapping("/findall")
    public List<Groups> findAll() {
        return (List<Groups>) groupsRepo.findAll();
    }

    @PostMapping("/create")
    public Groups add(@RequestBody Groups speciality) {
        groupsRepo.save(speciality);
        return speciality;
    }

    @GetMapping("/find/{id}")
    public Optional<Groups> find(@PathVariable("id") long id) {
        return groupsRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        groupsRepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Groups update(@PathVariable("id") long id, @RequestBody Groups group) {
        group.setId(id);
        groupsRepo.save(group);
        return group;
    }
}
