package com.example.project.Controllers;

import com.example.project.Modules.Activities;
import com.example.project.Repositories.ActivitiesRepo;
import com.example.project.Repositories.TeacherRepository;
import com.example.project.Services.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivitiesService activitiesService;

    @Autowired
    private ActivitiesRepo activitiesRepo;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/activity/add")
    public String getArticlePage(Model model){
        List<Activities> activitiesList = activitiesService.getFiles();
        model.addAttribute("activities", activitiesList);
        return "activity";
    }

    @GetMapping("/activities")
    public String getArticlesList(Model model){
        List<Activities> activitiesList = activitiesService.getFiles();
        model.addAttribute("activities", activitiesList);
        return "activities_list";
    }

    @GetMapping("/activities/edit")
    public String editArticlesList(Model model){
        List<Activities> activitiesList = activitiesService.getFiles();
        model.addAttribute("activities", activitiesList);
        return "activities_edit";
    }

    @GetMapping("/activities/delete")
    public String delete(@RequestParam long id) {
        activitiesRepo.deleteById(id);
        return "redirect:/activities/edit";
    }


    @PostMapping("/activity/upload")
    public String uploadArticle(MultipartFile file, Authentication authentication,
                                @RequestParam(name = "title") String title, @RequestParam(name = "authors") String authors,
                                @RequestParam(name = "publisher") String publisher, @RequestParam(name = "activity") String activity,
                                @RequestParam(name = "type") String type,  @RequestParam(name = "description") String description) throws IOException {
        Long teacherId = teacherRepository.findTeacherByEmail(authentication.getName()).getId();

        activitiesService.saveFile(file,teacherId,title,description,activity, type, authors, publisher);
        return "redirect:/activity/add";
    }

    @GetMapping("/activity/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId){
        Activities activities = activitiesService.getFile(fileId).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(activities.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\"" + activities.getActivityName() + "\"")
                .body(new ByteArrayResource(activities.getData()));
    }

}
