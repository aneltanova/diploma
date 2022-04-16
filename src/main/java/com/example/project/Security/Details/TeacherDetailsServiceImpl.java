package com.example.project.Security.Details;

import com.example.project.Modules.Teacher;
import com.example.project.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class TeacherDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Teacher teacher = teacherRepository.findTeacherByEmail(email);

        if (teacher != null){
            return new TeacherDetailsImpl(teacher);
        } else throw new UsernameNotFoundException("User not Found!");
    }
}
