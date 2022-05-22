package com.example.project.Controllers;

import com.example.project.Modules.Departments;
import com.example.project.Modules.Disciplines;
import com.example.project.Modules.Groups;
import com.example.project.Modules.Load;
import com.example.project.Repositories.DepartmentsRepo;
import com.example.project.Repositories.DisciplinesRepo;
import com.example.project.Repositories.GroupsRepo;
import com.example.project.Repositories.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class LoadController {

    @Autowired
    private LoadRepo loadRepo;

    @Autowired
    private GroupsRepo groupRepo;
    private DepartmentsRepo departmentsRepo;
    private DisciplinesRepo disciplinesRepo;


//    @GetMapping("/findall")
//    public List<Load> findAll() {
//        return (List<Load>) loadRepo.findAll();
//    }

    @GetMapping("/load")
    public String getLoadPage(Model model){
        List<Groups> groups = groupRepo.findAll();
        List<Departments> departments = departmentsRepo.findAll();
        List<Disciplines> disciplines = disciplinesRepo.findAll();

        model.addAttribute("groups", groups);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("departments", departments);




        return "load";
    }

    @PostMapping("/createLoad")
    public Load add(@RequestBody Load load) {
        loadRepo.save(load);
        return load;
    }



//    @GetMapping("/find/{id}")
//    public Optional<Load> find(@PathVariable("id") long id) {
//        return loadRepo.findById(id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable("id") long id) {
//        loadRepo.deleteById(id);
//    }
//
//    @PutMapping("/update/{id}")
//    public Load update(@PathVariable("id") long id, @RequestBody Load load) {
//        load.setId(id);
//        loadRepo.save(load);
//        return load;
//    }
}


//{
//        "id": 2,
//        "teacher_id": 2,
//        "academic_load": [
//        {
//        "discipline": "Java Advanced 2",
//        "speciality": "CS",
//        "groups": [
//        "cs-1801",
//        "cs-1802",
//        "cs-1803",
//        "cs-1804"
//        ],
//        "target_activity": "no",
//        "component": "ok"
//        },
//        {
//        "discipline": "Java Advanced 2",
//        "speciality": null,
//        "groups": null,
//        "target_activity": "no",
//        "component": "ok"
//        }
//        ]
//        }