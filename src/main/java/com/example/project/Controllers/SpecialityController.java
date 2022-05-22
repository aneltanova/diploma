package com.example.project.Controllers;

import com.example.project.Modules.Specialities;
import com.example.project.Repositories.SpecialitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/specialities")
public class SpecialityController {

    private final SpecialitiesRepo specialitiesRepo;

    @Autowired
    SpecialityController(SpecialitiesRepo specialitiesRepo){
        this.specialitiesRepo = specialitiesRepo;
    }

    @GetMapping("/findall")
    public List<Specialities> findAll() {
        return (List<Specialities>) specialitiesRepo.findAll();
    }

    @PostMapping("/createSpeaciality")
    public Specialities add(@RequestBody Specialities speciality) {
        specialitiesRepo.save(speciality);
        return speciality;
    }

    @GetMapping("/group/{id}")
    public Optional<Specialities> find(@PathVariable("id") long id) {
        return specialitiesRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        specialitiesRepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Specialities update(@PathVariable("id") long id, @RequestBody Specialities speciality) {
        speciality.setId(id);
        specialitiesRepo.save(speciality);
        return speciality;
    }
}
