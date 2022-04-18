package iitu.kz.diploma.Controllers;

import iitu.kz.diploma.Models.Disciplines;
import iitu.kz.diploma.Models.Groups;
import iitu.kz.diploma.Repos.DisciplinesRepo;
import iitu.kz.diploma.Repos.GroupsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/discipline")
public class DisciplinesController {

    private final DisciplinesRepo disciplinesRepo;

    @Autowired
    DisciplinesController(DisciplinesRepo disciplinesRepo){
        this.disciplinesRepo = disciplinesRepo;
    }

    @GetMapping("/findall")
    public List<Disciplines> findAll() {
        return (List<Disciplines>) disciplinesRepo.findAll();
    }

    @PostMapping("/create")
    public Disciplines add(@RequestBody Disciplines discipline) {
        disciplinesRepo.save(discipline);
        return discipline;
    }

    @GetMapping("/find/{id}")
    public Optional<Disciplines> find(@PathVariable("id") long id) {
        return disciplinesRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        disciplinesRepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Disciplines update(@PathVariable("id") long id, @RequestBody Disciplines discipline) {
        discipline.setId(id);
        disciplinesRepo.save(discipline);
        return discipline;
    }
}
