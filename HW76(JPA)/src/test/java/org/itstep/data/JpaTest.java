package org.itstep.data;

import org.itstep.model.Group;
import org.itstep.model.Student;
import org.itstep.model.Teacher;
import org.itstep.service.AcademyService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JpaTest {

    @Autowired
    AcademyService academyService;

    @PersistenceContext
    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    void insertStudentWithGroup() {
        assertNotNull(academyService);
        Group group = new Group("Java spring 2019");
        // save
        Student student = new Student("Вася", "Пупкин", LocalDate.of(2000, 1, 1), group);
        group.setStudents(List.of(student));
        // save group
        academyService.save(group);
        // save student
        Integer id = academyService.save(student);

        // read
        // read student
        student = academyService.getStudent(id);
        assertEquals("Вася", student.getFirstName());
        assertEquals("Пупкин", student.getLastName());
        assertEquals(LocalDate.of(2000, 1, 1), student.getBirthDate());
        assertNotNull(student.getGroup());
        assertEquals("Java spring 2019", student.getGroup().getName());

        // read group
        group = academyService.getGroup(group.getId());
        assertNotNull(group);
        assertEquals("Java spring 2019", group.getName());
        assertNotNull(group.getStudents());
        assertEquals(1, group.getStudents().size());
        assertEquals("Вася", group.getStudents().get(0).getFirstName());
        assertEquals("Пупкин", group.getStudents().get(0).getLastName());
        assertEquals(LocalDate.of(2000, 1, 1), group.getStudents().get(0).getBirthDate());
    }

    @Test
    void insertTeacher(){
        assertNotNull(academyService);
        Teacher teacher = new Teacher( "Test", "Test", LocalDate.of(2000, 1, 1), new HashSet<>());
        Integer id = academyService.save(teacher);

        teacher = academyService.getTeacher(id);
        assertEquals("Test", teacher.getFirstName());
        assertEquals("Test", teacher.getLastName());
        assertEquals(LocalDate.of(2000, 1, 1), teacher.getStartWork());
        assertNotNull(teacher.getGroups());
    }
}
