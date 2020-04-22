package org.itstep.service.security;


import org.itstep.domain.Student;
import org.itstep.domain.Teacher;
import org.itstep.repository.StudentRepository;
import org.itstep.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Student student = studentRepository.findUserByLogin(userName);
        Teacher teacher = teacherRepository.findUserByLogin(userName);

        if (student != null) {
            return studentRepository.findUserByLogin(userName);
        } else if (teacher != null) {
            return teacherRepository.findUserByLogin(userName);
        } else {
            return new User("admin", "{noop}admin",
                    AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        }
    }
}