package org.itstep.service;

import
        java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.itstep.dto.*;
import org.itstep.model.*;
import org.itstep.repository.*;
import org.itstep.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class AddTest {

    @InjectMocks
    AcademyService academyService;

    @Mock
    StudentRepository studentRepository;

    @Mock
    TeacherRepository teacherRepository;

    @Mock
    GroupRepository groupRepository;

    List<Student> students = new ArrayList<>();
    Set<Group> groups = new HashSet<>();
    Set<Teacher> teachers = new HashSet<>();

    Group group = new Group(1, "Test", students, teachers);
    Student student = new Student(1, "Test", "Test", LocalDate.of(2000, 1, 1), group);
    Teacher teacher = new Teacher(1, "Test", "Test", LocalDate.of(2000, 1, 1), groups);

    @Test
    void getStudent() {
        teachers.add(teacher);

        when(studentRepository.findById(1)).thenReturn(Optional.of(student));

        StudentDto studentDto = academyService.getStudentDto(1);

        assertNotNull(studentDto);
        assertEquals(1, studentDto.getId());
        assertEquals("Test", studentDto.getFirstName());
        assertEquals("Test", studentDto.getLastName());
        assertEquals(LocalDate.of(2000, 1, 1), studentDto.getBirthDate());
        assertEquals(1, studentDto.getGroup());
        assertEquals("Test", studentDto.getGroupName());

        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    void getGroup() {
        students.add(student);
        teachers.add(teacher);

        when(groupRepository.findById(1)).thenReturn(Optional.of(group));

        GroupDto groupDto = academyService.getGroupDto(1);

        assertNotNull(groupDto);
        assertEquals(1, groupDto.getId());
        assertEquals("Test", groupDto.getName());

        verify(groupRepository, times(1)).findById(1);
    }

    @Test
    void getTeacher() {
        groups.add(group);

        when(teacherRepository.findById(1)).thenReturn(Optional.of(teacher));

        TeacherDto teacherDto = academyService.getTeacherDto(1);

        assertNotNull(teacherDto);
        assertEquals(1, teacherDto.getId());
        assertEquals("Test", teacherDto.getFirstName());
        assertEquals("Test", teacherDto.getLastName());
        assertEquals(LocalDate.of(2000, 1, 1), teacherDto.getStartWork());
        assertEquals(groups.stream().filter(data -> Objects.equals(data, new Group(1, "Test", students, teachers))).findFirst().get().getName(), teacherDto.getGroupsName().get(0));

        verify(teacherRepository, times(1)).findById(1);
    }

}

