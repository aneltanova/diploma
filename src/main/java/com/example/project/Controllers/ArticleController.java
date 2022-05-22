package com.example.project.Controllers;

import com.example.project.Modules.Articles;
import com.example.project.Repositories.ArticlesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticlesRepo articlesRepo;

    @Autowired
    ArticleController(ArticlesRepo articlesRepo){
        this.articlesRepo = articlesRepo;
    }

    @GetMapping("/findall")
    public List<Articles> findAll() {
        return (List<Articles>) articlesRepo.findAll();
    }

    @PostMapping("/create")
    public Articles add(@RequestBody Articles article) {
        articlesRepo.save(article);
        return article;
    }

    @GetMapping("/find/{id}")
    public Optional<Articles> find(@PathVariable("id") long id) {
        return articlesRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        articlesRepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Articles update(@PathVariable("id") long id, @RequestBody Articles article) {
        article.setId(id);
        articlesRepo.save(article);
        return article;
    }
}
