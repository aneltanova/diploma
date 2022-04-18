package iitu.kz.diploma.Controllers;

import iitu.kz.diploma.Models.Faculties;
import iitu.kz.diploma.Repos.FacultiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultiesRepo facultiesRepo;

    @Autowired
    FacultyController(FacultiesRepo facultiesRepo){
        this.facultiesRepo = facultiesRepo;
    }

    @GetMapping("/findall")
    public List<Faculties> findAll() {
        return (List<Faculties>) facultiesRepo.findAll();
    }

    @PostMapping("/create")
    public Faculties add(@RequestBody Faculties faculty) {
        facultiesRepo.save(faculty);
        return faculty;
    }

    @GetMapping("/find/{id}")
    public Optional<Faculties> find(@PathVariable("id") long id) {
        return facultiesRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        facultiesRepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Faculties update(@PathVariable("id") long id, @RequestBody Faculties faculty) {
        faculty.setId(id);
        facultiesRepo.save(faculty);
        return faculty;
    }
}
