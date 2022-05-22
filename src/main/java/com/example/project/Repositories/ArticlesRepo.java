package com.example.project.Repositories;

import com.example.project.Modules.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepo extends JpaRepository<Articles, Long>{
}
