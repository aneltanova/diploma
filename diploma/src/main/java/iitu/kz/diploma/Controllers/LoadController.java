package iitu.kz.diploma.Controllers;

import iitu.kz.diploma.Models.Load;
import iitu.kz.diploma.Repos.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/load")
public class LoadController {

    private final LoadRepo loadRepo;

    @Autowired
    LoadController(LoadRepo loadRepo){
        this.loadRepo = loadRepo;
    }

    @GetMapping("/findall")
    public List<Load> findAll() {
        return (List<Load>) loadRepo.findAll();
    }

    @PostMapping("/create")
    public Load add(@RequestBody Load load) {
        loadRepo.save(load);
        return load;
    }

    @GetMapping("/find/{id}")
    public Optional<Load> find(@PathVariable("id") long id) {
        return loadRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        loadRepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Load update(@PathVariable("id") long id, @RequestBody Load load) {
        load.setId(id);
        loadRepo.save(load);
        return load;
    }
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