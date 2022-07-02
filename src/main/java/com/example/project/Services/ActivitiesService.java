package com.example.project.Services;

import com.example.project.Modules.Activities;
import com.example.project.Repositories.ActivitiesRepo;
import com.example.project.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesService {
    @Autowired
    private ActivitiesRepo activitiesRepo;

    @Autowired
    private TeacherRepository teacherRepository;

    public Activities saveFile(MultipartFile file, Long teacherId,
                               String title, String description, String activity,
                               String type, String authors, String publisher){
        String docname = file.getOriginalFilename();
        try {
            Activities activities = new Activities(activity, file.getContentType(), file.getBytes(),teacherId);
            activities.setAuthors(authors);
            activities.setDescription(description);
            activities.setTitle(title);
            activities.setPublisher(publisher);
            activities.setType(type);
            activities.setData(file.getBytes());
            activities.setDocType(file.getContentType());
            activitiesRepo.save(activities);
            return activitiesRepo.save(activities);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Optional<Activities> getFile(Long fileId){
        return activitiesRepo.findById(fileId);
    }

    public List<Activities> getFiles(){
        return activitiesRepo.findAll();
    }
}
